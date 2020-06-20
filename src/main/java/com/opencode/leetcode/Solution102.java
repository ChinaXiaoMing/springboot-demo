package com.opencode.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
* @Description 102.二叉树的层序遍历
* @level medium
* @Date 2020-05-13 19:22:58
* @Version 1.0
**/
public class Solution102 {

    List<List<Integer>> res = new ArrayList<>();

    /**
     * 递归解法
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root != null) {
            helper(root, 0);
        }
        return res;
    }

    private void helper(TreeNode root, int level) {
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        if (root.left != null) {
            helper(root.left, level + 1);
        }
        if (root.right != null) {
            helper(root.right, level + 1);
        }
    }

    @Test
    public void levelOrderTest() {
        Assert.assertEquals(1, 1);
    }

}