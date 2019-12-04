import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {
    class Solution {
    //        If the elements are sorted in monotonically increasing (or decreasing) order,
    //        the majority element can be found at index [n/2] and [n/2] + 1
    //         incidentally, if nn is even).
    //
    //        Algorithm:
    //
    //        For this algorithm, we simply do exactly what is described: sort nums,
    //        and return the element in question. To see why this will always return the majority element
    //                (given that the array has one), consider the figure below (the top example is for an
    //        odd-length array and the bottom is for an even-length array):

        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length/2];
        }
    }


//    class Solution {
//        public int majorityElement(int[] nums) {
//            HashMap<Integer, Integer> hm = new HashMap<>();
//            int answer=0, max=0;
//
//            for(int i=0; i<nums.length; i++){
//                if(hm.containsKey(nums[i])){
//                    //if key exists increm val by 1
//                    hm.put(nums[i], hm.get(nums[i]) + 1);
//                }else{
//                    // add it and set val to 1
//                    hm.put(nums[i], 1);
//                }
//
//
//                if(hm.get(nums[i]) > max){
//                    // calls key and compares to val stored in answer
//                    // to find highest number
//                    max = hm.get(nums[i]);
//                    answer = nums[i];
//                }
//            }
//            return answer;
//        }
//    }
}
