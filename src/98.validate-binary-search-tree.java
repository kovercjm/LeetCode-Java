/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (null == root) return true;
        if (null != min && min.val >= root.val || null != max && max.val <= root.val) return false;
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);    
    }
}
// @lc code=end
