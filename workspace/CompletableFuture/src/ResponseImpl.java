import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.xml.ws.Response;

public class ResponseImpl<T> implements Response<T> {
	T val;

	public ResponseImpl(T val) {
		this.val = val;
	}

	@Override
	public boolean cancel(boolean mayInterruptIfRunning) {
		return false;
	}

	@Override
	public boolean isCancelled() {
		return false;
	}

	@Override
	public boolean isDone() {
		return false;
	}

	@Override
	public T get() throws InterruptedException, ExecutionException {
		return val;
	}

	@Override
	public T get(long timeout, TimeUnit unit) throws InterruptedException,
			ExecutionException, TimeoutException {
		return val;
	}

	@Override
	public Map<String, Object> getContext() {
		return null;
	}

}
