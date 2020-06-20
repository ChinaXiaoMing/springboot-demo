package com.opencode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
* @Description 560. 和为K的子数组
* @level medium
* @Date 2020-05-15 19:40:19
* @Version 1.0
**/
public class Solution560 {

    /**
     * f(i) = f(i - 1) + nums[i]
     * 在[i, j]区间内f(i) - f(j - 1) = k ==> f(j - 1) = f(i) - k
     * @param nums
     * @param k
     * @return
     */
    public int subArraySum(int[] nums, int k) {
        return 1;
    }

    @Test
    public void subArraySumTest() {
        int[] nums = {1, 1, 1};
        int k = 2;
        int result = new Solution560().subArraySum(nums, k);
        Assert.assertEquals(2, result);
    }

}