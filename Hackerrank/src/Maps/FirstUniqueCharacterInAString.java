package Maps;

import java.util.HashMap;

public class FirstUniqueCharacterInAString {
    // https://www.baeldung.com/java-bifunction-interface
    // https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
    // .map(Tests::doubleIt)
    // is equivalent to
    // .map(i -> Tests.doubleIt(i))
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> counts = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            System.out.println("char is " + ch);
            counts.merge(ch, 1, Integer::sum);
            System.out.println(counts);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (counts.get(ch) == 1) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String a = "test";
        System.out.println(firstUniqChar(a));

    }

}
