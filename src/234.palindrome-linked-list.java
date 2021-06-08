/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
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
    public ListNode reverse(ListNode head) {
        if (null == head.next) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
    
    public boolean isPalindrome(ListNode head) {
        if (null == head.next) return true;

        ListNode p = head, q = head.next.next, half;
        while (null != q && null != q.next) {
            p = p.next;
            q = q.next.next;
        }
        half = reverse(p.next);
        p.next = null;
        p = head;
        while (null != p) {
            if (p.val != half.val)
                return false;
            p = p.next;
            half = half.next;
        }
        return true;
    }
}
// @lc code=end
