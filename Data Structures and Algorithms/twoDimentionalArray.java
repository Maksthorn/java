
public class twoDimentionalArray {

	public static void main(String[] args) {
		
		int[][] ar = {
				{1,2,3},
				{4,5,6},
				{9,8,9}};
		
		System.out.println(dif(ar));
		
	}
	
	static int dif(int[][] arr) {
		
		int left = 0, right = 0;
		int n = arr.length;
		
		for(int i = 0; i < n; i++) {
			left += arr[i][i];
			System.out.println("left " + left);
			right +=arr[i][n-1-i];
			System.out.println("right " + right);
		}
		
		return (Math.abs(left - right));
		
	}
	
}
