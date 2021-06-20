/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode start = new ListNode(-1, head);
        ListNode p = start, q;
        
        while (p.next != null && p.next.next != null) {
            q = p.next.next;
            p.next.next = q.next;
            q.next = p.next;
            p.next = q;
            p = q.next;
        }

        return start.next;
    }
}
// @lc code=end
