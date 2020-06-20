package com.opencode.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
* @Description 3. 无重复字符的最长子串
* @level medium
* @Date 2020-05-13 19:58:27
* @Version 1.0
**/
public class Solution3 {

    /**
     * 滑动窗口 + 哈希
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                left = Math.max(left, map.get(chars[i]) + 1);
            }
            map.put(chars[i], i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    @Test
    public void lengthOfLongestSubstringTest() {
        String s = "abcabcbb";
        int result = new Solution3().lengthOfLongestSubstring(s);
        Assert.assertEquals(3, result);
    }

}