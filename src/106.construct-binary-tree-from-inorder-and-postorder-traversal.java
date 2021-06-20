/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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
    int[] post;
    List<Integer> inList = new ArrayList<>();

    public TreeNode build(int postRoot, int inStart, int inEnd) {
        TreeNode root = new TreeNode(post[postRoot]);
        if (inStart == inEnd) return root;
        int inRoot = inList.indexOf(post[postRoot]);
        
        root.left = inRoot == inStart ? null : build(postRoot - (inEnd - inRoot) - 1, inStart, inRoot - 1);
        root.right = inRoot == inEnd ? null : build(postRoot - 1, inRoot + 1, inEnd);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post = postorder;
        for (int i = 0; i < inorder.length; i++)
            inList.add(inorder[i]);
        return build(postorder.length - 1, 0, inorder.length - 1);
    }
}
// @lc code=end
