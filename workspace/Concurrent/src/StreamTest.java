import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class StreamTest {
	static AtomicInteger cpt=new AtomicInteger(0);
	
	public static void main(String[] args) {
		ArrayList<Task> tab=new ArrayList();
		for (int i =0;i< 50; i++) {
			int dur=(i==30)?30000:100;
			tab.add(new Task(i,dur,cpt));
			cpt.incrementAndGet();
		}
		tab.stream().parallel().forEach(Task::run);		
	}
}
