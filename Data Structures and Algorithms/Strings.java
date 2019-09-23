import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Strings {

	public static void main(String[] args) {
		//System.out.println(compress("ttteesst"));
		String test = compress("tteess");
		System.out.println(test);
		
	}
	
	public static String compress(String s) {
		StringBuilder compressedString = new StringBuilder();
		int count = 0;
		
		for(int i = 0;  i < s.length();i++) {
			
			count++;
			
			if(i + 1 >=  s.length() || s.charAt(i) != s.charAt(i + 1)) {
				
				compressedString.append(s.charAt(i));
				compressedString.append(count);
				count=0;
			}
		}
		
		return compressedString.length() < s.length() ? compressedString.toString() : s;
		
	}
	
	public static String longestSubString(String one, String two) {
		/*char[] a = one.toCharArray();
		char[] b = two.toCharArray();
		StringBuilder sb = new StringBuilder();
		int counter = 0;
		ArrayList<String> bs = new ArrayList<String>(a);
		bs.add(one.toCharArray());
		bs.contains(two);

		*/
		return "";
	}
	
	
	public static String replace(String s) {
		/*
		 * String s = "this is a test sentence ";
		System.out.println(replace(s));
		 */
		char[] a = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		for(char ele : a) {
			if(ele == ' ') {
				sb.append("%20");
			}else {
				sb.append(ele);
			}
		}
		return sb.toString();
	}
	
	
	public static boolean StringPermutation(String original, String permutation) {
		/*System.out.println(StringPermutation("test", "eh"));
		System.out.println(StringPermutation("cats","stac"));*/
		StringBuilder sb = new StringBuilder();
		
		if (sb.append(permutation).reverse().toString().contains(original)) {
			return true;
		}
		return false;
	}
	
	public static String sort(String s) {
		/**
		 * helper method
		 */
		char[] a = s.toCharArray();
		Arrays.sort(a);
		
		return new String(a);
	}
	
	public static boolean StringPermutationV2(String original, String permutation) {
		/*
		 * for comparing any letter arrengment 
		 */
		if (sort(original) == sort(permutation)){
			return true;
		}
		return false;
	}
	
	
    public static boolean isUnique(String S) {
    	/*
    	 * 
    	 * String test  ="test";
		String test2  ="tes";
		System.out.println(isUnique(test));
		System.out.println(isUnique(test2));
		*/
    	Set<Character> idk = new HashSet<Character>();
    	for(char ele: S.toCharArray()) {
    		idk.add(ele);
    	}
    	
        int c = S.toCharArray().length;
        
        if(c == idk.size()) {
        	return true;
        }
        
       for(char ele : idk) {
    	   System.out.println(ele);
       }
		return false;
        
    }

}
