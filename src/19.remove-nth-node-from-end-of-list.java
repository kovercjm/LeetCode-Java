/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(-1, head);
        ListNode p = start, q = start.next;

        while (n-- > 0 && q != null)
            q = q.next;

        while (q != null) {
            q = q.next;
            p = p.next;
        }

        p.next = p.next.next;
        return start.next;
    }
}
// @lc code=end
