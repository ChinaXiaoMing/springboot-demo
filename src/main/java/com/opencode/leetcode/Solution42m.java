package com.opencode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
* @Description 面试题42. 连续子数组的最大和
* @level easy
* @Date 2020-05-13 20:07:49
* @Version 1.0
**/
public class Solution42m {

    /**
     * 动态规划
     * 转换函数 f(n) = f(n - 1) + num[n]
     * f(n- 1) < 0时 f(n) = num[n]
     * f(0) = num[0]
     * f(1) = Math.max(num[0],0) + num[1]
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1], 0) + nums[i];
            max = Math.max(nums[i], max);
        }
        return max;
    }

    @Test
    public void maxSubArrayTest() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = new Solution42m().maxSubArray(nums);
        Assert.assertEquals(6, result);
    }

}