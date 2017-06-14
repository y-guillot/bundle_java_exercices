package streamapi;


import java.util.Arrays;
import java.util.List;

import tools.Timer;

public class StreamApi {

	/**
	 * Application main program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Timer.start();
		StreamApi.execute();
		Timer.stop();
		StreamApi.display(Timer.debug());

	}

	/**
	 * Main "Command pattern".
	 */
	private static void execute() {

		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

		myList.stream()
			.filter(s -> s.startsWith("c"))
			.map(String::toUpperCase)
			.sorted()
			.forEach(System.out::println);
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
