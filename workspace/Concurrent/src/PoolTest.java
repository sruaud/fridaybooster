import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class PoolTest {
	static AtomicInteger cpt=new AtomicInteger(0);
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor=Executors.newFixedThreadPool(4);
		ArrayList<Task> tab=new ArrayList();
		
		for (int i =0;i< 50; i++) {
			int dur=(i==30)?30000:100;
			int idx=i;
			executor.submit(new Task(idx,dur,cpt));
			cpt.incrementAndGet();
		}
		
		Thread.sleep(40000);
		
		executor.shutdown();
		System.out.println("DONE");
	}
}
