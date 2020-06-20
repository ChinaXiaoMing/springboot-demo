package com.opencode.leetcode;

/**
 * @Description TODO
 * @Author xiaoming
 * @Date 2020/5/12 23:57
 * @Version 1.0
 **/
public class MinStack {

    class Node {
        int val;
        int min;
        Node next;
        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    Node head;

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x);
        } else {
            Node node = new Node(x, Math.min(x, head.min));
            node.next = head;
            head = node;
        }
    }

    public void pop() {
        if (head != null) {
            head = head.next;
        }
    }

    public int top() {
        if (head != null) {
            return head.val;
        }
        return -1;
    }

    public int getMin() {
        return head.min;
    }

}
