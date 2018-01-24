import java.lang.reflect.*;

public class TestRunner {
	public static void main(String[] args) throws Exception {
		Class<Sample> testClass = (Class<Sample>) Class.forName("Sample");
		ISample instance=testClass.newInstance(); 
		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(MyTest.class)) {
				try {
					m.invoke(instance);
				} 
				catch (Exception exc) {
					System.out.println("Failed while calling " + m);
				}
			}
		}
		System.out.println("Done");
	}
}