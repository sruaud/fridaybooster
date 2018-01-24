public class Sample implements ISample {
	
	
	@MyTest(prefix = "nice m1")
	public int m1() {
		System.out.println("m1 running");
		return 3;
	} 


	
	public int m2(int nb) {
		System.out.println("m2 running with " + nb);
		return nb+1;
	}


	@MyTest(prefix = "failing m3")
	public void m3() { 
		System.out.println("m3 running");
		throw new RuntimeException("Boom");
	}
}