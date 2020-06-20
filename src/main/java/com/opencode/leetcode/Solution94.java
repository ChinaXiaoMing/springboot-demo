package com.opencode.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
* @Description 94. 二叉树中序遍历
* @level medium
* @Date 2020-05-06 22:12:28
* @Version 1.0
**/
public class Solution94 {

//    /**
//     * 栈实现
//     * @param root
//     * @return
//     */
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        while (!stack.isEmpty() || root != null) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            list.add(root.val);
//            root = root.right;
//        }
//        return list;
//    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    /**
     * 递归实现
     * @param root
     * @param res
     */
    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    @Test
    public void inorderTraversalTest() {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(7);
        treeNode.left.left = new TreeNode(6);
        treeNode.left.right = new TreeNode(8);
        treeNode.right = new TreeNode(12);
        treeNode.right.left = new TreeNode(11);
        treeNode.right.right = new TreeNode(13);
        List<Integer> list = new Solution94().inorderTraversal(treeNode);
        list.forEach(x -> System.out.print(x + ","));
        Assert.assertEquals(1, 1);
    }

}