package com.opencode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
* @Description 98. 验证二叉搜索树
* @level medium
* @Date 2020-05-06 20:24:22
* @Version 1.0
**/
public class Solution98 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        while (root.left != null) {
            System.out.println(root.left.val);
            root.left = root;
        }
        return true;
    }

    @Test
    public void isValidBSTTest() {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(7);
        treeNode.left.left = new TreeNode(6);
        treeNode.left.right = null;
        treeNode.right = new TreeNode(12);
        treeNode.right.left = new TreeNode(11);
        treeNode.right.right = new TreeNode(13);
        boolean result = new Solution98().isValidBST(treeNode);
        Assert.assertTrue(result);
    }

}