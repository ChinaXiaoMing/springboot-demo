package com.opencode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
* @Description 5. 最长回文子串
* @level medium
* @Date 2020-05-17 20:15:04
* @Version 1.0
**/
public class Solution5 {

    public String longestPalindrome(String s) {
        return "";
    }

    @Test
    public void longestPalindromeTest() {
        String s = "babad";
        String result = new Solution5().longestPalindrome(s);
        Assert.assertEquals("bab", result);
    }

}