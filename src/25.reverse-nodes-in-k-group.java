/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
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
    public ListNode reverseBeforeP(ListNode head, ListNode p) {
        if (p == head.next) {
            head.next = null;
            return head;
        }
        ListNode newHead = reverseBeforeP(head.next, p);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head;
        for (int i = 1; i <= k; i++) {
            if (null == p)
                return head;
            p = p.next;
        }

        ListNode newHead = reverseBeforeP(head, p);
        head.next = reverseKGroup(p, k);
        return newHead;
    }
}
// @lc code=end
