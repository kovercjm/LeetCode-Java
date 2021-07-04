/*
 * @lc app=leetcode id=501 lang=java
 *
 * [501] Find Mode in Binary Search Tree
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
    public int[] findMode(TreeNode root) {
        int value = Integer.MIN_VALUE, count = 0, max = 1;
        List<Integer> results = new ArrayList<>();
        TreeNode current = root, mostRight = null;

        while (current != null) {
            mostRight = current.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != current)
                    mostRight = mostRight.right;
                if (mostRight.right == null) {
                    mostRight.right = current;
                    current = current.left;
                    continue;
                }
                mostRight.right = null;
            }

            if (value == current.val)
                count++;
            else
                count = 1;
            if (count == max)
                results.add(current.val);
            if (count > max) {
                max = count;
                results.clear();
                results.add(current.val);
            }
            value = current.val;

            current = current.right;
        }

        return results.stream().mapToInt(Integer::intValue).toArray();
    }
}
// @lc code=end
