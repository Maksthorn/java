import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class BinarySearch {

	public static void main(String[] args) {
		ArrayList<Integer> ar = new ArrayList<>();
		
		Random rand = new Random();
		
		for(int i = 0; i < 6; i++) {
			int idk = rand.nextInt(25);
			ar.add(idk);
		}
		
		Collections.sort(ar);
		
		System.out.println(singleNumber(ar));

	}
	
	
    public static int singleNumber(ArrayList<Integer> ar) {
        HashSet<Integer> hs = new HashSet<Integer>();
        int len = ar.size();
        
        for(int i = 0; i < len; i++){
            int tmp = ar.get(i);
            if (hs.contains(tmp)){
                hs.remove(tmp);
            }else{
                hs.add(tmp);
            }
        }

        int result=0;
        for(Integer item:hs){
            result = item;
        }
        
        return result;
    }

}
