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
    // Morris Solution
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode current = root, mostRight = null;

        while (current != null) {
            mostRight = current.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != current)
                    mostRight = mostRight.right;
                if (mostRight.right == null) {
                    result.add(current.val);
                    mostRight.right = current;
                    current = current.left;
                    continue;
                }
                mostRight.right = null;
            } else {
                result.add(current.val);
            }
            current = current.right;
        }
        return result;
    }
}
// @lc code=end

// Recursion Solution
/* 
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
*/
