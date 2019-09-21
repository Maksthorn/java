import java.util.HashSet;
import java.util.Set;

public class Strings {

	public static void main(String[] args) {
		
		
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
