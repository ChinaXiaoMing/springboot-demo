package com.opencode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
* @Description 2.两数相加
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
* @level medium
* @Date 2020-05-09 21:31:48
* @Version 1.0
**/
public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return null;
    }

    private void helper(ListNode l1, ListNode l2, int sum) {
        if (l1.val != 0 && l2.val != 0) {
            sum = l1.val + l2.val;
            if (sum > 10) {
                helper(l1, l2, sum + 1);
            }
            if (l1.next != null && l2.next == null) {
                sum = l1.next.val;
            }
            if (l2.next != null && l1.next == null) {
                sum = l2.next.val;
            }
        }
    }

    @Test
    public void addTwoNumbersTest() {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);
        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
        ListNode listNode3 = new ListNode(7);
        listNode3.next = new ListNode(0);
        listNode3.next.next = new ListNode(8);
        Assert.assertEquals(listNode3, new Solution2().addTwoNumbers(listNode1, listNode2));
    }

}