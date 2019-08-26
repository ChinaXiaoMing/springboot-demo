package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num2 = target - nums[i];
            if (map.containsKey(num2) && map.get(num2) != i) {
                result[0] = map.get(num2);
                result[1] = i;
            }
            map.put(nums[i], i);
        }
        return result;
    }

}
