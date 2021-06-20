/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
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
    public int k, result;
    
    public void triverse(TreeNode root) {
        if (root == null || k < 0) return;

        triverse(root.left);
        if (--k == 0) result = root.val;
        triverse(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        result = -1;
        triverse(root);
        return result;
    }
}
// @lc code=end
