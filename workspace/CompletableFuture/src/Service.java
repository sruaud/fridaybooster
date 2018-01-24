import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;


public class Service {

	static public void toggleCaseAsync(final String me,
			final AsyncHandler<String> asyncHandler) {

		System.out.printf("toggleCaseAsync called with %s ", me);
		new Thread(() -> {
		
			String toggledres = toggleCaseSync(me);
			Response<String> resp = new ResponseImpl<String>(toggledres);
			System.out.println("done");
			asyncHandler.handleResponse(resp);
		}).start();
	}

	static public String toggleCaseSync(final String me) {
		
		System.out.printf("computing", me);

		try {
			for (int i = 0; i < 30; i++) {
				System.out.printf(".");
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
		}

		if (me.equals("BOOM")) {
			throw new RuntimeException("Patatra");
		}
		String toggledres;
		if (me.matches("[A-Z]*")) {
			toggledres = me.toLowerCase();
		} else {
			toggledres = me.toUpperCase();
		}
		return toggledres;
	}
}
