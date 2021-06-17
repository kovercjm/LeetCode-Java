/*
 * @lc app=leetcode id=450 lang=java
 *
 * [450] Delete Node in a BST
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
    public TreeNode findSuccessor(TreeNode node) {
        while (null != node.left)
            node = node.left;
        return node;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (null == root) return null;
        if (root.val < key)
            root.right = deleteNode(root.right, key);
        else if (root.val > key)
            root.left = deleteNode(root.left, key);
        else {
            if (null == root.left) return root.right;
            if (null == root.right) return root.left;
            TreeNode tmp = findSuccessor(root.right);
            tmp.left = root.left;
            root = root.right;
        }
        return root;
    }
}
// @lc code=end
