package com.opencode.leetcode.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 100内的素数
 * @Author xiaoming
 * @Date 2020/6/22 21:40
 * @Version 1.0
 **/
public class Question2 {

    public List<Integer> primes(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i < num; i++) {
            if (isPrimes(i)) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * 判断是否为素数
     * @param num
     * @return
     */
    private boolean isPrimes(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> primes = new Question2().primes(100);
        primes.forEach(x -> System.out.print(x + ","));
    }

}
