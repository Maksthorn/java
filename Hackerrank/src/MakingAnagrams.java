import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MakingAnagrams {
    public static class Solution {

        // Complete the makeAnagram function below.
        static int makeAnagram(String a, String b) {
            int min_del =0;
            int [] a_freq= new int[26];
            int [] b_freq= new int[26];

            for(int i =0; i< a.length(); i++){
                char c = a.charAt(i);
                int charToInt= (int)c;
                int position = charToInt - (int)'a';
                a_freq[position]++;

            }

            for(int i =0; i< b.length(); i++){
                char c = b.charAt(i);
                int charToInt= (int)c;
                int position = charToInt - (int)'a';
                b_freq[position]++;

            }

            for(int i=0; i<26; i++){
                int dif = Math.abs(a_freq[i] - b_freq[i]);
                min_del += dif;
            }

            return min_del;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String a = scanner.nextLine();

            String b = scanner.nextLine();

            int res = makeAnagram(a, b);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }

}
