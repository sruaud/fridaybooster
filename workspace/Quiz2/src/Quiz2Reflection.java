import java.lang.reflect.Field;

public class Quiz2Reflection {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		hack(); 
		
		Integer nombre1 = 1;
		Integer nombre2 = 1;
		

		System.out.println("1 + 1 =  " + (nombre1 + nombre2));
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void hack() throws NoSuchFieldException,
			IllegalAccessException {
		Field value = Integer.class.getDeclaredField("value"); 
		value.setAccessible(true); 
		value.set(1, 2);
	}
}
