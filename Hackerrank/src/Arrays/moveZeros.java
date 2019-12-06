package Arrays;

public class moveZeros {
    class Solution {
        public void moveZeroes(int[] nums) {
            int countedZeros = 0, startNewIndex = 0;
            int len = nums.length;

            for(int i = 0; i < len; i++){
                if(nums[i] != 0){
                    // if its not a 0 skip
                    nums[startNewIndex] = nums[i];
                    // use startNewIndex to start at 0 in nums array
                    startNewIndex++;
                }else{
                    // if it is a 0 add to counter for later
                    countedZeros++;
                }
            }

            for(int numbers = len - countedZeros; numbers < len; numbers++){
                // take arr len + 0s in that array to find
                // where the number index ends and start adding 0s from there
                nums[numbers] = 0;
            }

        }
    }
}
