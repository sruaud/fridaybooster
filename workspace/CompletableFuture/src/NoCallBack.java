import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

public class NoCallBack {

	static NoCallBack c = new NoCallBack();

	public CompletableFuture<String> callMethod(String val) {
		// lancement de la tâche synchrone dans un thread du pool JVM
		// Note: On peut (et on doit) utiliser la méthode qui prend un Executor
		// en argument pour contrôler
		// finement le pool de thread utilisé
		return CompletableFuture.supplyAsync(() -> Service.toggleCaseSync(val));
	}

	public void simpleCall(String msg) throws InterruptedException,
			ExecutionException {
		String result = c.callMethod(msg).get();

		System.out.println("Result is " + result);
	}

	public void chainingCall(String msg) throws InterruptedException,
			ExecutionException {
		String result = c.callMethod(msg).thenApply(x -> {
			System.out.println("First call says " + x);
			return x;
		}).thenCompose(x -> c.callMethod(x)).exceptionally(ex -> {
			System.out.println("Failed in the chain");
			return null;
		}).get();

		System.out.println("Result is " + result);
	}

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		c.chainingCall("hello");
	}

}
