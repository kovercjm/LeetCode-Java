/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
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
    public List<TreeNode> generate(int min, int max) {
        List<TreeNode> result = new ArrayList();

        if (min >= max) {
            result.add(min == max ? new TreeNode(min) : null);
        } else {
            for (int i = min; i <= max; i++) {
            List<TreeNode> leftList = generate(min, i - 1);
            List<TreeNode> rightList = generate(i + 1, max);
            for (TreeNode left : leftList)
                for (TreeNode right : rightList)
                    result.add(new TreeNode(i, left, right));
            }
        }
        
        return result;
    }

    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }
}
// @lc code=end
