package Arrays;

import java.util.Arrays;

public class FindMissingElement {

    class Solution {
        public int solution(int[] A) {
            Arrays.sort(A);
            int min = 1;
            int len = A.length;

            for (int i = 0; i < len; i++){
                if(A[i] == min){
                    min++;
                }
            }
            return min;
        }
    }

}
