/*
 * @lc app=leetcode id=116 lang=java
 *
 * [116] Populating Next Right Pointers in Each Node
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public void connectBelow(Node left, Node right) {
        if (left == null) return;

        left.next = right;
        connectBelow(left.left, left.right);
        connectBelow(right.left, right.right);
        connectBelow(left.right, right.left);
    }

    public Node connect(Node root) {
        if (root == null || root.left == null) return root;
        connectBelow(root.left, root.right);
        return root;
    }
}
// @lc code=end
