/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(-101);
        ListNode p = l1, q = l2, end = start;
        while (p != null && q != null) {
            if (p.val <= q.val){
                end.next = p;
                p = p.next;
                end = end.next;
            } else {
                end.next = q;
                q = q.next;
                end = end.next;
            }
        }
        end.next = p == null ? q : p;
        return start.next;
    }
}
// @lc code=end
