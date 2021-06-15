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
    Map<String, Integer> subTrees;
    List<TreeNode> result;

    public String triverse(TreeNode root) {
        if (null == root) return "#";

        String tree = root.val + "," + triverse(root.left) + "," + triverse(root.right);
        subTrees.put(tree, subTrees.getOrDefault(tree, 0) + 1);
        if (2 == subTrees.get(tree))
            result.add(root);
        
        return tree;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        subTrees = new HashMap<>();
        result = new ArrayList<>();
        triverse(root);
        return result;
    }
}
// @lc code=end
