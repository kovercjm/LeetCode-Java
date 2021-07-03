/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
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
    public int count(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        
        int left = count(root.left);
        if (left == -1) return -1;
        int right = count(root.right);
        if (right == -1 || Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        return count(root) != -1;
    }
}
// @lc code=end
