/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (0 == x || 1 == x) return x;
        int left = 0, right = x, answer = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (x >= (long) mid * mid) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}
// @lc code=end
