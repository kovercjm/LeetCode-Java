/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
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
    public boolean hasCycle(ListNode head) {
        ListNode p = head, q = head;
        do {
            if (null == q || null == q.next)
                return false;
            p = p.next;
            q = q.next.next;
        } while (p != q);

        return true;
    }
}
// @lc code=end
