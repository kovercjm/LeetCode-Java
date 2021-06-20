/*
 * @lc app=leetcode id=1373 lang=java
 *
 * [1373] Maximum Sum BST in Binary Tree
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
    public int max = 0;

    public int[] count(TreeNode root) {       // int[] = {sum, min, max}
        if (root == null) return new int[]{0};

        int[] leftResult = count(root.left), rightResult = count(root.right);

        if (leftResult == null || rightResult == null ||
            (root.left != null && leftResult[2] >= root.val) ||
            (root.right != null && root.val >= rightResult[1])) return null;

        int sum = root.val + leftResult[0] + rightResult[0];
        max = Math.max(sum, max);
        return new int[]{ sum, root.left != null ? leftResult[1] : root.val,
            root.right != null ? rightResult[2] : root.val};
    }
    
    public int maxSumBST(TreeNode root) {
        count(root);
        return max;
    }
}
// @lc code=end
