/*
 * @lc app=leetcode id=226 lang=java
 *
 * [226] Invert Binary Tree
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
    public void swap(TreeNode root) {
        if (null == root || (null == root.left && null == root.right)) return;

        TreeNode tmp = root.left;
        swap(root.left);
        swap(root.right);
        root.left = root.right;
        root.right = tmp;
    }

    public TreeNode invertTree(TreeNode root) {
        swap(root);
        return root;
    }
}
// @lc code=end
