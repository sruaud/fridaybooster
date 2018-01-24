import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SampleProxy implements InvocationHandler {

	Sample target;

	public SampleProxy(Sample target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		MyTest annot = method.getDeclaredAnnotation(MyTest.class); // doesn't work because method is from ISample (not annotated). Only Sample's one is.
		annot = target.getClass().getMethod(method.getName(), method.getParameterTypes()).getDeclaredAnnotation(MyTest.class);
		
		if (null != annot) {
			System.out
			.printf("method %s '%s' called from proxy\n", method.getName(),annot.prefix());
		} else {
			System.out
					.printf("method %s called from proxy\n", method.getName());
		}
		return method.invoke(target, args);
	}

}
