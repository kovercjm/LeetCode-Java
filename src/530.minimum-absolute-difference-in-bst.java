/*
 * @lc app=leetcode id=530 lang=java
 *
 * [530] Minimum Absolute Difference in BST
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int result = Integer.MAX_VALUE, pre = -1;

    public void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        if (pre != -1)
            result = Math.min(Math.abs(pre - root.val), result);
        pre = root.val;
        traverse(root.right);
    }

    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return result;
    }
}
// @lc code=end
