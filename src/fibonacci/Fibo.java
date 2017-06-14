package fibonacci;

public class Fibo {

	private static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) {

		int rep = 42;
		
		if (args.length > 0 && Integer.parseInt(args[0]) > 0) {
			rep = Integer.parseInt(args[0]);
		} 
		
		Fibo.recursive_execute(rep, 0, 1);
		System.out.println(Fibo.result);
	}

	public static long recursive_execute(int n, long a, long b) {
		
		if (n >= 0) Fibo.result.append(String.valueOf(a)).append("\n");
		return (n > 0) ? recursive_execute(n - 1, b, a + b) : a;
	}
}
