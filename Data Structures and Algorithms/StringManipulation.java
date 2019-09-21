

public class StringManipulation {

	public static void main(String[] args) {
		
		String text = "this is my string for zendesk";
		String text2 = "ZenDesk";
		
		System.out.println(text);
		System.out.println("after manipulation");
		System.out.println(answer(text));
		
		System.out.println("*********************************************");
		System.out.println("String manipulation with dots");
		System.out.println(text2);
		System.out.println("after manipulation");
		System.out.println(answerV2(text2));
	}

	private static String answerV2(String InputText) {
		StringBuilder sb = new StringBuilder();
		int len = InputText.toCharArray().length; // is 6 arrays start at 0
		
		for(int i = 0; i < len;i++) {
			
			//if i is not 5 so second last character in array
			if(i != len - 1)
				//add a dot
				sb.append(InputText.charAt(i)+".");
					else
				//add nothing
				sb.append(InputText.charAt(i));
		
		}
		//print out result
		String result = sb.toString();
		
		return result;
	}
	
	
	public static String  answer(String text) {
		StringBuilder sb = new StringBuilder();
		int len = text.toCharArray().length;
		//System.out.println(len);
		
		for (int i = len -1; i >= 0 ;i--) {
			sb.append(text.charAt(i));
		}
		
		String result = sb.toString();
		
		return result;
	}

}
