package Concurrent;
import java.util.concurrent.atomic.AtomicInteger;

public class Task implements Runnable {
	int c, idx;
	AtomicInteger cpt;
	
	public Task(int idx, int c, AtomicInteger cpt) {
		this.c = c;
		this.idx = idx;
		this.cpt=cpt;
	}

	@Override
	public void run() {
		try {
			System.out.printf("Running %d for %d ms\n",idx,c);
			Thread.sleep(c);
			cpt.decrementAndGet();
			System.out.printf("Done %d Remaining %d\n",idx,cpt.get());
		} catch (InterruptedException e) {
		}
	}
}