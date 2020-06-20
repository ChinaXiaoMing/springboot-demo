package com.opencode.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
* @Description 145. 二叉树后序遍历
* @level hard
* @Date 2020-05-07 23:12:10
* @Version 1.0
**/
public class Solution145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root != null) {
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.peek();
                if (cur == null) {
                    stack.pop();
                    res.add(stack.peek().val);
                    stack.pop();
                    continue;
                }
                stack.push(null);
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }

        return res;
    }

//    /**
//     * 递归实现
//     * @param root
//     * @return
//     */
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        helper(root, res);
//        return res;
//    }
//
//    private void helper(TreeNode root, List<Integer> res) {
//        if (root != null) {
//            if (root.left != null) {
//                helper(root.left, res);
//            }
//            if (root.right != null) {
//                helper(root.right, res);
//            }
//            res.add(root.val);
//        }
//    }

    @Test
    public void postorderTraversalTest() {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(7);
        treeNode.left.left = new TreeNode(6);
        treeNode.left.right = null;
        treeNode.right = new TreeNode(12);
        treeNode.right.left = new TreeNode(11);
        treeNode.right.right = new TreeNode(13);
        List<Integer> list = new Solution145().postorderTraversal(treeNode);
        list.forEach(x -> System.out.print(x + ","));
        Assert.assertEquals(1, 1);
    }

}