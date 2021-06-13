/*
 * @lc app=leetcode id=654 lang=java
 *
 * [654] Maximum Binary Tree
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
    public int[] nums;

    public TreeNode build(int start, int end) {
        int max = -1, index = -1;
        for (int i = start; i <= end; i++)
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }

        TreeNode root = new TreeNode(max);
        root.left = start == index ? null : build(start, index - 1);
        root.right = end == index ? null : build(index + 1, end);
        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        return build(0, nums.length - 1);
    }
}
// @lc code=end
