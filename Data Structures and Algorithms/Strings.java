import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Strings {

	public static void main(String[] args) {
		
		
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
