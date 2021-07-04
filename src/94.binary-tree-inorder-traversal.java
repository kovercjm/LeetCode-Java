/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode current = root, mostRight = null;

        while (current != null) {
            mostRight = current.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != current)
                    mostRight = mostRight.right;
                if (mostRight.right == null) {
                    mostRight.right = current;
                    current = current.left;
                    continue;
                } else
                    mostRight.right = null;
            }
            result.add(current.val);
            current = current.right;
        }
        
        return result;
    }
}
// @lc code=end

// Recursion Solution
/*
    public List<Integer> result = new ArrayList<>();

    public void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        result.add(root.val);
        traverse(root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return result;
    }
*/
