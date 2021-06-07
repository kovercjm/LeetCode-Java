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
        if (null == head) return head;
        ListNode start = new ListNode(-101, head);
        ListNode p = start, q = start.next.next;

        while (q != null) {
            if (q.val != p.next.val) {
                p = p.next;
                q = q.next;
            } else {
                while (null != q && q.val == p.next.val)
                    q = q.next;
                p.next = q;
                q = null == q ? null : q.next;
            }
        }

        return start.next;
    }
}
// @lc code=end
