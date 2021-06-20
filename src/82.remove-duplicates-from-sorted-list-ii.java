/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode start = new ListNode(-101, head);
        ListNode p = start, q = start.next.next;

        while (q != null) {
            if (q.val != p.next.val) {
                p = p.next;
                q = q.next;
            } else {
                while (q != null && q.val == p.next.val)
                    q = q.next;
                p.next = q;
                q = q == null ? null : q.next;
            }
        }

        return start.next;
    }
}
// @lc code=end
