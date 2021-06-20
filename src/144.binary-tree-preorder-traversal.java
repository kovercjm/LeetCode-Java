/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
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
    List<Integer> result = new ArrayList<>();

    public void traversal(TreeNode root) {
        if (root == null) return;
        result.add(root.val);
        traversal(root.left);
        traversal(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        traversal(root);
        return result;
    }
}
// @lc code=end
