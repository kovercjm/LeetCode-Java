/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */

// @lc code=start
class Solution {
    public int fib(int n) {
        if (n <= 1) return n;
        int pre = 0, cur = 1, next = 0;
        while (n-- >= 2) {
            next = pre + cur;
            pre = cur;
            cur = next;
        }
        return next;
    }
}
// @lc code=end
