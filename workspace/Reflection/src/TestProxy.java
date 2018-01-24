import java.lang.reflect.*;

public class TestProxy {
	public static void main(String[] args) throws Exception {
		test1();
		test2();
	}

	private static void test1() {
		Sample obj = new Sample();
		ISample proxy = (ISample) Proxy.newProxyInstance(obj.getClass()
				.getClassLoader(), obj.getClass().getInterfaces(),
				new SampleProxy(obj));
		System.out.printf("calling m2 with 2 returns %d\n", proxy.m2(2));
		System.out.printf("calling m1 returns %d\n", proxy.m1());
		System.out.println("Done");
	}

	private static void test2() { // mock
		Sample obj = new Sample();
		ISample proxy = (ISample) Proxy.newProxyInstance(obj.getClass()
				.getClassLoader(), obj.getClass().getInterfaces(),
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						if (method.getName().equals("m1")) {
							return 12;
						}
						return method.invoke(obj, args);
					}
				});
		System.out.printf("calling m2 with 2 returns %d\n", proxy.m2(2));
		System.out.printf("calling m1 returns %d\n", proxy.m1());
		System.out.println("Done");
	}	
}