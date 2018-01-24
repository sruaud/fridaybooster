import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

public class CallBack {

	static CallBack c = new CallBack();

	

	public CompletableFuture<String> callMethod(String val) {
		CompletableFuture<String> cf = new CompletableFuture<String>();

		Service.toggleCaseAsync(val, resp -> {
			String res;
			try {
				res = resp.get();
				cf.complete(res);
			} catch (Exception e) {
				cf.completeExceptionally(e);
			}
		});
		return cf;
	}
	
	

	public void simpleCall() throws InterruptedException, ExecutionException {
		String result = c.callMethod("hello").get();

		System.out.println("Result is " + result);
	}

	public void chainingCall() throws InterruptedException, ExecutionException {
		String result = c.callMethod("hello").thenApply(x -> {
			System.out.println("First call says " + x);
			return x;
		}).thenCompose(x -> c.callMethod(x)).get();

		System.out.println("Result is " + result);
	}

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		c.chainingCall();
	}

}
