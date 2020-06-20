package com.opencode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
* @Description 69. x的平方根
* @level easy
* @Date 2020-05-09 21:18:01
* @Version 1.0
**/
public class Solution69 {

    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }

    @Test
    public void mySqrtTest() {
        int result = new Solution69().mySqrt(8);
        Assert.assertEquals(2, result);
    }

}