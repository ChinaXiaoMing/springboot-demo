package com.opencode.leetcode.interview;

/**
 * @Description 二进制为1的个数
 * @Author xiaoming
 * @Date 2020/6/22 21:33
 * @Version 1.0
 **/
public class Question1 {

    public int getBinaryCount(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int binaryCount = new Question1().getBinaryCount(15);
        System.out.println(binaryCount);
    }

}
