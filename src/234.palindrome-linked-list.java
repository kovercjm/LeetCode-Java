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
        if (head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
    
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;

        ListNode p = head, q = head.next.next, half;
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
        }
        half = reverse(p.next);
        p.next = null;
        p = head;
        while (p != null) {
            if (p.val != half.val)
                return false;
            p = p.next;
            half = half.next;
        }
        return true;
    }
}
// @lc code=end
