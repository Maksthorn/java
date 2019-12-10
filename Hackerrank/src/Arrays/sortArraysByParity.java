package Arrays;

public class sortArraysByParity {
    class Solution {
        public int[] sortArrayByParity(int[] A) {
            int[] ans = new int[A.length];
            int index = 0;

            for (int i = 0; i < A.length; ++i)
                if (A[i] % 2 == 0)
                    ans[index++] = A[i];

            for (int i = 0; i < A.length; ++i)
                if (A[i] % 2 == 1)
                    ans[index++] = A[i];

            return ans;
        }
    }
}
