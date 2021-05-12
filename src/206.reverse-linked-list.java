/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
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
    public ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) return head;
        ListNode cur = head;
        while (null != head.next) {
            ListNode tmp = head.next.next;
            head.next.next = cur;
            cur = head.next;
            head.next = tmp;
        }
        return cur;
    }
}
// @lc code=end
