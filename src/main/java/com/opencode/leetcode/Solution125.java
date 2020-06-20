package com.opencode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
* @Description 125. 验证回文串
* @level easy
* @Date 2020-05-17 23:07:52
* @Version 1.0
**/
public class Solution125 {

    public boolean isPalindrome(String s) {
        String result = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        char[] chars = result.toCharArray();
        char[] reverse = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            reverse[i] = chars[chars.length - 1 - i];
        }
        String newStr = new String(reverse);
        System.out.println(newStr);
        return newStr.equals(result);
    }

    @Test
    public void isPalindromeTest() {
        String s = "A man, a plan, a canal: Panama";
        boolean result = new Solution125().isPalindrome(s);
        Assert.assertTrue(result);
    }

}