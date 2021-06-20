/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, result = 0, countZero = 0;
        for (right = 0; right < nums.length; right++) {
            countZero += nums[right] == 0 ? 1 : 0;
            while (k < countZero) {
                result = Math.max(result, right - left);
                countZero -= nums[left++] == 0 ? 1 : 0;
            }
        }
        return Math.max(result, right - left);
    }
}
// @lc code=end
