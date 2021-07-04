/*
 * @lc app=leetcode id=783 lang=java
 *
 * [783] Minimum Distance Between BST Nodes
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

    public int minDiffInBST(TreeNode root) {
        traverse(root);
        return result;
    }
}
// @lc code=end
