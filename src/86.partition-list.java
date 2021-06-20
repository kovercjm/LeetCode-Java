/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
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
    public ListNode partition(ListNode head, int x) {
        ListNode originalStart = new ListNode(-101, head);
        ListNode newStart = new ListNode(-101, null);
        ListNode p = originalStart, q = newStart, t;
        while (p.next != null) {
            if (p.next.val < x) {
                q.next = p.next;
                q = q.next;
                p.next = p.next.next;
            } else
                p = p.next;
        }
        q.next = originalStart.next;
        return newStart.next;
    }
}
// @lc code=end
