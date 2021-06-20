/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode p = head, q = head;
        do {
            if (q == null || q.next == null)
                return null;
            p = p.next;
            q = q.next.next;
        } while (p != q);

        q = head;
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
}
// @lc code=end
