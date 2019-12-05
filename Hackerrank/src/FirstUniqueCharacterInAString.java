import java.util.HashMap;

public class FirstUniqueCharacterInAString {
    class Solution {
        public int firstUniqChar(String s) {
            HashMap<Character, Integer> counts = new HashMap<>();
            // https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#merge-K-V-java.util.function.BiFunction-
            // https://stackoverflow.com/questions/81346/most-efficient-way-to-increment-a-map-value-in-java
            // Save counts of characters
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                // What it does : if key do not exists, put 1 as value, otherwise sum 1 to the value linked to key
                counts.merge(ch, 1, Integer::sum);
            }

            // Find 1st unique character
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (counts.get(ch) == 1) {
                    return i;
                }
            }
            return -1;
        }

    }

}
