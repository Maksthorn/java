import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RepeatedString {

    public static class Solution {

        // Complete the repeatedString function below.
        static long repeatedString(String str, long n) {
            long count = 0;

            for (int i = 0; i < str.length(); i++)
                if (str.charAt(i) == 'a')
                    count++;

            // atleast k repetition are required
            long repetitions = n / str.length();
            count = count * repetitions;

            // if n is not the multiple of the
            // string size check for the remaining
            // repeating character.
            for (int i = 0;
                 i < n % str.length(); i++)
            {
                if (str.charAt(i) == 'a')
                    count++;
            }

            return count;

        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String s = scanner.nextLine();

            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long result = repeatedString(s, n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }

}
