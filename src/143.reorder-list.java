/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
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

    public void reorderList(ListNode head) {
        if (null == head || null == head.next || null == head.next.next) return;

        ListNode p = head, q = head, half, tmp;
        while (null != q && null != q.next) {
            q = q.next.next;
            p = p.next;
        }
        half = reverse(p.next);
        p.next = null;
        p = head;
        q = half;
        while (null != q) {
            tmp = q.next;
            q.next = p.next;
            p.next = q;
            q = tmp;
            p = p.next.next;
        }
    }
}
// @lc code=end

/*
    public ListNode order(ListNode head) {
        if (null == head || null == head.next || null == head.next.next) return head;

        ListNode pre = head, end = head.next;
        while (null != end.next) {
            pre = pre.next;
            end = end.next;
        }
        
        pre.next = null;
        end.next = order(head.next);
        head.next = end;
        return head;
    }

    public void reorderList(ListNode head) {
        order(head);
    }
    public void reorderList(ListNode head) {
        order(head);
    }
*/
