package Maps;

import java.util.*;

public class MaxSubArrayEqualsToK {

    public int maxSubArray(int[] nums, int k){
        // [1, -1, 5,- 2, 3]
        // l == 3

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int maxLen = 0;

        for(int i =0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
            map.putIfAbsent(sum, i);
        }

        return maxLen;
    }
}
