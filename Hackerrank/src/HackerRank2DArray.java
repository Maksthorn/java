import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HackerRank2DArray {
    public static class Solution {

        // Complete the hourglassSum function below.
        static int hourglassSum(int[][] arr) {
            int max_sum = Integer.MIN_VALUE; // constraints say that the input is between -9 to 9 meaning for 7 elements min val is -63 max
            int rows = arr.length -2;
            int cols = arr[0].length -2;

            for (int i=0; i < rows; i++){
                for(int j=0; j< cols; j++){
                    int cur_sum =
                            arr[i][j] + arr[i][j+1] + arr[i][j+2] +
                                    arr[i+1][j+1]+
                                    arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];

                    max_sum = Math.max(max_sum, cur_sum);

                }
            }

            return max_sum;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int[][] arr = new int[6][6];

            for (int i = 0; i < 6; i++) {
                String[] arrRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 6; j++) {
                    int arrItem = Integer.parseInt(arrRowItems[j]);
                    arr[i][j] = arrItem;
                }
            }

            int result = hourglassSum(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }


}
