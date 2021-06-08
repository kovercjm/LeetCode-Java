/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (null == head) return head;
        if (map.containsKey(head)) return map.get(head);

        Node newHead = new Node(head.val);
        map.put(head, newHead);
        newHead.next = copyRandomList(head.next);
        newHead.random = copyRandomList(head.random);

        return newHead;
    }
}
// @lc code=end
