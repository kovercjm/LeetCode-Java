/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
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
    public List<String> result = new ArrayList<>();

    public void traverse(TreeNode root, StringBuffer prefix) {
        if (root.left == null && root.right == null) {
            result.add(prefix.append(root.val).toString());
            return;
        }
        if (root.left != null) traverse(root.left, (new StringBuffer(prefix)).append(root.val).append("->"));
        if (root.right != null) traverse(root.right, (new StringBuffer(prefix)).append(root.val).append("->"));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        traverse(root, new StringBuffer());
        return result;
    }
}
// @lc code=end
