package tools;

public class Timer {

	private static long startTime;
	private static long stopTime;

	public static void start() {

		Timer.startTime = System.currentTimeMillis();
	}

	public static void stop() {

		Timer.stopTime = System.currentTimeMillis();
	}

	public static long elapsedTime() {

		return stopTime - startTime;
	}

	public static String debug() {

		return String.format("\n\nExecution time : %d milliseconds.\n\n", Timer.elapsedTime());
	}
}
