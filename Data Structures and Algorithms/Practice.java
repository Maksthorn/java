

public class Practice {


	public static void main(String[] args) {
			String input = "test string";
			System.out.println(answer(input));
	}

	private static String answer(String input) {
		int len = input.length();
		StringBuilder sb = new StringBuilder();
		char[] array = input.toCharArray();
		
		for(int i = len - 1; i >= 0; i--) {
			sb.append(array[i]);
		}
		String result = sb.toString();
		return result;
	}


}
