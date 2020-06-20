package com.opencode.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
* @Description 144. 二叉树前序遍历
* @level medium
* @Date 2020-05-07 22:28:13
* @Version 1.0
**/
public class Solution144 {

    /**
     * 栈 + 迭代
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            //压入根节点
            stack.push(root);
            while (!stack.isEmpty()) {
                //栈顶元素出栈，获取当前节点
                TreeNode cur = stack.pop();
                //按根->左->右插入列表中
                res.add(cur.val);
                if (cur.right != null) {
                    //右子树先入栈，方便后出栈
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    //左子树后入栈，方便先出栈
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
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        helper(root, res);
//        return res;
//    }
//
//    private void helper(TreeNode root, List<Integer> res) {
//        if (root != null) {
//            res.add(root.val);
//            if (root.left != null) {
//                helper(root.left, res);
//            }
//            if (root.right != null) {
//                helper(root.right, res);
//            }
//        }
//    }

    @Test
    public void preorderTraversalTest() {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(7);
        treeNode.left.left = new TreeNode(6);
        treeNode.left.right = null;
        treeNode.right = new TreeNode(12);
        treeNode.right.left = new TreeNode(11);
        treeNode.right.right = new TreeNode(13);
        List<Integer> list = new Solution144().preorderTraversal(treeNode);
        list.forEach(x -> System.out.print(x + ","));
        Assert.assertEquals(1, 1);
    }

}