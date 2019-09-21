import java.util.Stack;

public class VendingMachineWithStack {
	
	public static void main(String[] args) {
			String input = "12+3+2";
			//String input2 = "+";
			//String input3 = "";
			
			char[] characters = input.toCharArray();
		
			System.out.println(answer(characters));
	
		}

	private static int answer(char[] characters) {
			Stack<Integer> NumericalStack = new Stack<Integer>();
			Stack<Character> OperatorStack = new Stack<Character>();
			int len = characters.length;
			
			//push items onto the stack
			for(int i = 0; i < len; i++) {
				char item = characters[i];
				
				if(Character.isDigit(item)) {
					int newItem = Character.getNumericValue(item);
					NumericalStack.push(newItem);
				}else{
					OperatorStack.push(item);
				}
			}
			
			//perform operation
			int sum = 0;
			while(!NumericalStack.isEmpty() && !OperatorStack.isEmpty()) {
				System.out.println("Starts again test ");
				int first = NumericalStack.pop();
				int second = NumericalStack.pop();
				char operator = OperatorStack.pop();
				
				if (operator == '+') {
					sum += first + second;
				}
				
			}
			
			
			return sum;
		

	}
	
	/*public static void main(String[] args) {
		//String input = "12+3+265";
		String input2 = "+9752/3271--0000000000-";	
		char[] characters = input2.toCharArray();
		System.out.println(answer(characters));
	}

	private static int answer(char[] characters) {
		Stack<Integer> numericalStack = new Stack<Integer>();
		Stack<Character> operatorStack = new Stack<Character>();
		int len = characters.length;
		
		for(int i = 0; i < len; i++) {
			char item = characters[i];
			
			if(Character.isDigit(item)) {
				int convertedItem = Character.getNumericValue(item);
				numericalStack.push(convertedItem);
			}else{
				operatorStack.push(item);
			}
		}
		
		int sum = 0;
		while(!numericalStack.isEmpty() && !operatorStack.isEmpty()) {
			int first = numericalStack.pop();
			int second = numericalStack.pop();
			
			char operator = operatorStack.pop();
			
			
			switch(operator) {
			case '+':
				sum += first + second;
				break;
			case '/':
				sum += first / second;
				break;
			case '-':
				sum += first - second;
				break;
			case '*':
				sum += first * second;
				break;
			}
			
		}
			
		
		return sum;
	}*/

}
