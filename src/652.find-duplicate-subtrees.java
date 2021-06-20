/*
 * @lc app=leetcode id=652 lang=java
 *
 * [652] Find Duplicate Subtrees
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
    Map<String, Integer> subTrees = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();

    public String triverse(TreeNode root) {
        if (root == null) return "#";

        String tree = root.val + "," + triverse(root.left) + "," + triverse(root.right);
        subTrees.put(tree, subTrees.getOrDefault(tree, 0) + 1);
        if (subTrees.get(tree) == 2)
            result.add(root);
        
        return tree;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        triverse(root);
        return result;
    }
}
// @lc code=end
