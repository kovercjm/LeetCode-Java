/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
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
    public int countNodes(TreeNode root) {
        if (null == root) return 0;

        int leftHight = 0, rightHight = 0;
        TreeNode t = root;
        while (null != t.left) {
            t = t.left;
            leftHight++;
        }
        t = root;
        while (null != t.right) {
            t = t.right;
            rightHight++;
        }
        
        if (leftHight == rightHight)
            return (int)Math.pow(2, leftHight + 1) - 1;
        else 
            return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
// @lc code=end
