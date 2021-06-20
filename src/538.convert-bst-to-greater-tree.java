/*
 * @lc app=leetcode id=538 lang=java
 *
 * [538] Convert BST to Greater Tree
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
    public int sum = 0;

    public void triverse(TreeNode root) {
        if (root == null) return;
        triverse(root.right);
        sum += root.val;
        root.val = sum;
        triverse(root.left);
    }

    public TreeNode convertBST(TreeNode root) {
        triverse(root);
        return root;
    }
}
// @lc code=end
