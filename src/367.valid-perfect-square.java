/*
 * @lc app=leetcode id=367 lang=java
 *
 * [367] Valid Perfect Square
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int left = 1, right = num - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid == num) 
                return true;
            else if (num > (long) mid * mid)
                left = mid + 1;
            else if (num < (long) mid * mid)
                right = mid - 1;
        }
        return false;
    }
}
// @lc code=end
