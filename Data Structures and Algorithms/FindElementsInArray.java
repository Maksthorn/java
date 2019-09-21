import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class FindElementsInArray {

	public static void main(String[] args) {
		ArrayList<Integer> ar = new ArrayList<>();
		
		Random rand = new Random();
		
		for(int i = 0; i < 6; i++) {
			int idk = rand.nextInt(25);
			ar.add(idk);
		}

		
		System.out.println(findSecondElement(ar));
		
		
		
	}

	private static String findSecondElement(ArrayList<Integer> ar) {
		System.out.println(ar);
		System.out.println("Array created !");
		Collections.sort(ar);
		System.out.println("Array sorted...");
		System.out.println(ar);
		int len = ar.size();
		System.out.println("arry size is " + len);
		//-1 since arrays start at 0 -2 for second last element in arraylist
		int[] idk = {ar.get(len - 2),ar.get(len - 1)};
		
		//return as string format
		return Arrays.toString(idk);
	}
	


}
