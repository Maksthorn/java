import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class numsNotInArray {
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            Set<Integer> set = new HashSet<>();
            // java 10+ sadly leetcode uses 8
            // var mySet = Set.of(someArray);
            for(int i = 1; i <= nums.length; i++){
                set.add(i);
            }
            for(int num : nums){
                set.remove(num);
            }
            return new ArrayList(set);
        }
    }
// also nice
//    class Solution {
//        public List<Integer> findDisappearedNumbers(int[] nums) {
//            List<Integer> list = new ArrayList<>();
//
//            for (int i=1; i<=nums.length; i++) {
//                list.add(i);
//            }
//
//            for (int i=0; i<nums.length; i++) {
//                list.set(nums[i] - 1, -1);
//            }
//
//            list.removeIf(i -> i == -1);
//
//            return list;
//        }
//    }
}
