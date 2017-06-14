package paircount;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import tools.Timer;

public class PairCount {

	// Unmutated list of numbers.
	public static final List<Integer> numbers = new LinkedList<Integer>();
	// Map referencing (key,value) as (number,occurrence).
	public static final Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
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
			if (argsRep > 0) PairCount.rep = argsRep;
		} catch (Exception e) {
			/* void */
		}

		try {
			PairCount.maxNum = Math.abs(Integer.parseInt(args[1]));
		} catch (Exception e) {
			/* void */
		}
		

		PairCount.execute();

		Timer.stop();
		PairCount.display(Timer.debug());
	}

	/**
	 * Main "Command pattern".
	 */
	private static void execute() {

		PairCount.generateNumbers();
		PairCount.evaluateNumbers();
		PairCount.countPairs();
	}

	/**
	 * Fill the original list of numbers.
	 */
	private static void generateNumbers() {

		for (int i = 0; i < PairCount.rep; ++i) {
			PairCount.numbers.add(PairCount.getRandom());
		}

		/* Debug */
		PairCount.display(
				String.format(
						"A total of %s numbers between 0 to %s has been generated :\n",
						PairCount.numbers.size(),
						PairCount.maxNum));
		PairCount.numbers.forEach((v) -> PairCount.display(v + " ")); // numbers.forEach(System.out::print);
		PairCount.display("\n\n");
		/* End Debug */
	}

	/**
	 * Build map (key,value) as (number,occurrence).
	 */
	private static void evaluateNumbers() {

		PairCount.numbers.forEach((v) -> {
			int cpt = 1;
			if (PairCount.occurrences.containsKey(v)) cpt = PairCount.occurrences.get(v) + 1;
			PairCount.occurrences.put(v, cpt);
		});

		/* Debug */
		PairCount.occurrences
				.forEach((k, v) -> PairCount.display(String.format("%d has been generated %d times\n", k, v)));
		/* End Debug */
	}

	/**
	 * Count the amount of generated pairs
	 */
	private static void countPairs() {

		PairCount.occurrences.forEach((k, v) -> {
			PairCount.pairs += v / 2;
		});

		/* Debug */
		PairCount.display(String.format("\n>>> A total of %d pairs has been generated <<<", PairCount.pairs));
		/* End Debug */
	}

	/**
	 * Generate a random integer.
	 * 
	 * @return
	 */
	private static int getRandom() {

		return new Random().nextInt(PairCount.maxNum);
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
