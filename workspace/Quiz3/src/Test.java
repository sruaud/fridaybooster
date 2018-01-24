
public class Test extends Thread {
	private static final int MAXLOOP = 100000000;
	Counter c;

	Test(Counter c) {
		this.c = c;
		start();
	}

	public void run() {
		for (int i = 0; i < MAXLOOP; i++)
			c.decr();
	}

	public static void main(String args[]) throws Exception {
		Counter c = new Counter();
		Test rc = new Test(c);
		for (int i = 0; i < MAXLOOP; i++)
			c.inc();
		rc.join();
		System.out.println("Final value of c.val: " + c.val);
	}
}