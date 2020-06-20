package com.opencode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
* @Description 9. 回文数
* @level easy
* @Date 2020-05-17 20:26:04
* @Version 1.0
**/
public class Solution9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int num = 0;
        int sum = 0;
        int y = x;
        while (x > 0) {
            num = x % 10;
            sum = sum * 10 + num;
            x /= 10;
        }
        return sum == y;
    }

    @Test
    public void longestPalindromeTest() {
        int x = 121;
        boolean result = new Solution9().isPalindrome(x);
        Assert.assertTrue(result);
    }

}