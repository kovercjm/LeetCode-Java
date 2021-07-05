/*
 * @lc app=leetcode id=1008 lang=java
 *
 * [1008] Construct Binary Search Tree from Preorder Traversal
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
    public int[] array;

    public TreeNode build(int start, int end) {
        if (start >= end) return null;

        int seperate = start;
        while (seperate < end && array[seperate] <= array[start])
            seperate++;

        return new TreeNode(array[start], build(start + 1, seperate), build(seperate, end));
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        array = preorder;
        return build(0, preorder.length);
    }
}
// @lc code=end
