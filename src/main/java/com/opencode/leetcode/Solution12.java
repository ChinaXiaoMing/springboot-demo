package com.opencode.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
* @Description 12.整数转罗马数字
* @level medium
* @Date 2020-05-24 09:45:46
* @Version 1.0
**/
public class Solution12 {

    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    /**
     * 贪心算法
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < values.length && num > 0; i++) {
            while (values[i] <= num) {
                num = num - values[i];
                stringBuilder.append(symbols[i]);
            }
        }
        return stringBuilder.toString();
    }

    @Test
    public void intToRomanTest() {
        int num = 1994;
        String result = new Solution12().intToRoman(num);
        Assert.assertEquals("MCMXCIV", result);
    }

}