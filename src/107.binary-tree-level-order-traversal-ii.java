/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Stack<List<Integer>> resultStack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.size() > 0) {
            List<Integer> levelResult = new ArrayList<>();
            for (int i = 1, size = queue.size(); i <= size; i++) {
                TreeNode node = queue.poll();
                levelResult.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            resultStack.push(levelResult);
        }

        List<List<Integer>> result = new ArrayList<>();
        while (!resultStack.isEmpty())
            result.add(resultStack.pop());
        return result;
    }
}
// @lc code=end
