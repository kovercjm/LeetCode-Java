/*
 * @lc app=leetcode id=117 lang=java
 *
 * [117] Populating Next Right Pointers in Each Node II
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
    public Node connect(Node root) {
        if (root == null) return root;

        Node dummy = new Node(-101), current = root, link = dummy;

        while (current != null) {
            if (current.left != null) {
                link.next = current.left;
                link = link.next;
            }
            if (current.right != null) {
                link.next = current.right;
                link = link.next;
            }
            current = current.next;
            if (current == null && dummy.next != null) {
                current = dummy.next;
                dummy.next = null;
                link = dummy;
            }
        }
        return root;
    }
}
// @lc code=end
