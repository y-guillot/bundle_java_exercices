package paircount;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import tools.Timer;

public class PairCountStream {

	// Unmutated list of numbers.
	public static final List<Integer> numbers = new LinkedList<Integer>();
	// Amount of generated pairs.
	public static int pairs = 0;
	// Default generated-numbers.
	public static int rep = 73;
	// Max number value
	public static int maxNum = 42;

	/**
	 * Application main program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Timer.start();

		try {
			int argsRep = Math.abs(Integer.parseInt(args[0]));
			if (argsRep > 0) PairCountStream.rep = argsRep;
		} catch (Exception e) {
			/* void */
		}

		try {
			PairCountStream.maxNum = Math.abs(Integer.parseInt(args[1]));
		} catch (Exception e) {
			/* void */
		}

		PairCountStream.execute();

		Timer.stop();
		PairCountStream.display(Timer.debug());
	}

	/**
	 * Main "Command pattern".
	 */
	private static void execute() {

		PairCountStream.generateNumbers();
		PairCountStream.countPairs();
	}

	/**
	 * Fill the original list of numbers.
	 */
	private static void generateNumbers() {

		for (int i = 0; i < PairCountStream.rep; ++i) {
			PairCountStream.numbers.add(PairCountStream.getRandom());
		}

		/* Debug */
		PairCountStream.display(
				String.format(
						"A total of %s numbers between 0 to %s has been generated :\n",
						PairCountStream.numbers.size(),
						PairCountStream.maxNum));
		PairCountStream.numbers.forEach((v) -> PairCountStream.display(v + " ")); // numbers.forEach(System.out::print);
		PairCountStream.display("\n\n");
		/* End Debug */
	}

	/**
	 * Count the amount of generated pairs
	 */
	private static void countPairs() {

		PairCountStream.numbers.stream()
				.sorted()
				.reduce(null, (x, y) -> {
					if (x == y) {
						++PairCountStream.pairs;
						return null;
					} else {
						return y;
					}
				});

		/* Debug */
		PairCountStream.display(String.format(">>> A total of %d pairs has been generated <<<", PairCountStream.pairs));
		/* End Debug */

	}

	/**
	 * Generate a random integer.
	 * 
	 * @return
	 */
	private static int getRandom() {

		return new Random().nextInt(PairCountStream.maxNum);
	}

	/**
	 * System display.
	 * 
	 * @param message
	 */
	private static void display(String message) {

		System.out.print(message);
	}
}
