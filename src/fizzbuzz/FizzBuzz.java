package fizzbuzz;

public class FizzBuzz {

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i <= 100; ++i) {
			String result = "";
		    if (i % 3 == 0) result = "Fizz";
		    if (i % 5 == 0) result += "Buzz";
		    sb.append(result.isEmpty() ? i : result).append(" ");
		}
		
		System.out.println(sb);

	}

}
