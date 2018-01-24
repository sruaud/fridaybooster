package Concurrent;
import java.util.ArrayList;
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
		ArrayList<CompletableFuture<Void>> cf=new ArrayList<CompletableFuture<Void>>();
		
		for (int i =0;i< 50; i++) {
			int dur=(i==30)?30000:100;
			int idx=i;
			cf.add(CompletableFuture.runAsync(new Task(idx,dur,cpt), executor));
			cpt.incrementAndGet();
		}
		CompletableFuture<Void> finale=CompletableFuture.allOf(cf.toArray(new CompletableFuture[cf.size()]));
		finale.get();
		executor.shutdown();
		System.out.println("DONE");
	}
}
