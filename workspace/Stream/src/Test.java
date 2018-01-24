import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
	public static void main(String[] args) {
		String WORDS[]={"hello","world"};
		List<String> res = Arrays.stream(WORDS)
		   .map(w-> w.split(""))
		   .flatMap(Arrays::stream)
		   .distinct() 
		   .collect(Collectors.toList());
		
		res.stream().forEach(System.out::println);

	}
}
