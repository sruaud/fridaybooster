import java.math.BigInteger;
import java.util.stream.Stream;

public class BadStream {
	public static Double theNext(Double dummy) {
		System.out.print(".");
		return Double.valueOf(Math.random());
	}
	public static void main(String[] args) {
		System.out.println("démarrage du générateur de nombres aléatoires > 0.9");
		long deb = System.nanoTime();
		Stream.iterate(Double.valueOf(1), BadStream::theNext)
				//.parallel()
				.map(x -> {
					try {
						Thread.sleep(100); // big calculation
					} catch (Exception e) {
					}
					return x;
				}).filter(x -> x > 0.9).limit(20)
				.forEach(x -> System.out.printf("%f\n", x));
		;
		System.out.printf("durée %d\n", (System.nanoTime() - deb) / 1000000);
	}
}
