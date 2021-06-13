/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
    int[] pre;
    List<Integer> inList = new ArrayList<>();

    public TreeNode build(int preRoot, int inStart, int inEnd) {
        TreeNode root = new TreeNode(pre[preRoot]);

        if (inStart == inEnd) return root;

        int inRoot = inList.indexOf(pre[preRoot]);
        root.left = inRoot == inStart ? null : build(preRoot + 1, inStart, inRoot - 1);
        root.right = inRoot == inEnd ? null : build(preRoot + (inRoot - inStart) + 1, inRoot + 1, inEnd);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        for (int i = 0; i < inorder.length; i++)
            inList.add(inorder[i]);
        return build(0, 0, inorder.length - 1);
    }
}
// @lc code=end
