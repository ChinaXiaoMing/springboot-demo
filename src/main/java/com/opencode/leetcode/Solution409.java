package com.opencode.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
* @Description 409. 最长回文串
* @level easy
* @Date 2020-05-17 22:49:01
* @Version 1.0
**/
public class Solution409 {

    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                count = count + 2;
                map.remove(chars[i]);
            } else {
                map.put(chars[i], i);
            }
        }
        return map.size() == 0 ? count : count + 1;
    }

    @Test
    public void longestPalindromeTest() {
        String s = "abccccdd";
        int result = new Solution409().longestPalindrome(s);
        Assert.assertEquals(7, result);
    }

}