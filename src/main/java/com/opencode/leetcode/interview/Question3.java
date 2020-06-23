package com.opencode.leetcode.interview;

/**
 * @Description 爬楼梯每步可以走1个、2个或3个台阶，总有什么种走法？
 * @Author xiaoming
 * @Date 2020/6/22 22:21
 * @Version 1.0
 **/
public class Question3 {

    public int stairsCount(int num) {
        if (num <= 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        if (num == 2) {
            return 2;
        }
        if (num == 3) {
            return 4;
        }
        return stairsCount(num - 3) + stairsCount(num - 2) + stairsCount(num - 1);
    }

    public static void main(String[] args) {
        int i = new Question3().stairsCount(4);
        System.out.println(i);
    }

}
