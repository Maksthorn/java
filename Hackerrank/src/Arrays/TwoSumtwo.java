package Arrays;

import java.util.ArrayList;
import java.util.List;

class TwoSumtwo {
    public int twoSum(int[] numbers, int target) {
        int answer = 0;
        List<Integer> arr = new ArrayList<>();


        for(int i = 0; i < numbers.length; i++){
            int tmp = numbers[i + 1];
            answer = numbers[i] + tmp;

            if (answer == target){
                arr.add(answer);
                //https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/discuss/459056/O(N)-TIME-O(1)-SPACE-BINARY-SEARCH-JAVA-SOLUTION
                //TODO redo with binary search tomorrow
            }

        }

        return answer;
    }
}
