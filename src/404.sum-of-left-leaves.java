/*
 * @lc app=leetcode id=404 lang=java
 *
 * [404] Sum of Left Leaves
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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root.left != null && root.left.left == null && root.left.right == null)
            return root.left.val + (root.right != null && (root.right.left != null || root.right.right != null) ? sumOfLeftLeaves(root.right) : 0);

        return (root.left != null && (root.left.left != null || root.left.right != null) ? sumOfLeftLeaves(root.left) : 0) +
            (root.right != null && (root.right.left != null || root.right.right != null) ? sumOfLeftLeaves(root.right) : 0);
    }
}
// @lc code=end
