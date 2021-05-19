/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, length = Integer.MAX_VALUE, sum = 0;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= target) {
                length = Math.min(right - left, length);
                sum -= nums[left++];
            }
        }
        return Integer.MAX_VALUE == length ? 0 : length;
    }
}
// @lc code=end
