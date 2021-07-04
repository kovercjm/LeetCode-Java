/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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
    public List<List<Integer>> results = new ArrayList<>();

    public void traverse(TreeNode root, int targetSum, List<Integer> prefix) {
        if (root == null) return;
        prefix.add(root.val);

        if (root.left == null && root.right == null && root.val == targetSum)
            results.add(new ArrayList<>(prefix));
        traverse(root.left, targetSum - root.val, prefix);
        traverse(root.right, targetSum - root.val, prefix);
        prefix.remove(prefix.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        traverse(root, targetSum, new ArrayList<Integer>());
        return results;
    }
}
// @lc code=end
