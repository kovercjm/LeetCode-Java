/*
 * @lc app=leetcode id=1038 lang=java
 *
 * [1038] Binary Search Tree to Greater Sum Tree
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
    public int sum;

    public void triverse(TreeNode root) {
        if (null == root) return;
        triverse(root.right);
        sum += root.val;
        root.val = sum;
        triverse(root.left);
    }

    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        triverse(root);
        return root;
    }
}
// @lc code=end
