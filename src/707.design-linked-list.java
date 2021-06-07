/*
 * @lc app=leetcode id=707 lang=java
 *
 * [707] Design Linked List
 */

// @lc code=start
class MyLinkedList {
    private ListNode start;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        start = new ListNode(-1, null);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        ListNode p = start;

        while (0 < index && null != p.next) {
            index--;
            p = p.next;
        }

        if (0 == index && null != p.next)
            return p.next.val;
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        start.next = new ListNode(val, start.next);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode p = start;

        while (null != p.next)
            p = p.next;

        p.next = new ListNode(val, null);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode p = start;

        while (0 < index && null != p.next) {
            index--;
            p = p.next;
        }
        
        if (0 == index)
            p.next = new ListNode(val, p.next);
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode p = start;

        while (0 < index && null != p.next) {
            index--;
            p = p.next;
        }

        if (0 == index && null != p.next)
            p.next = p.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end
