/*
 * @lc app=leetcode id=1658 lang=java
 *
 * [1658] Minimum Operations to Reduce X to Zero
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums, int x) {
        // Prefix sum
        
    }
}
// @lc code=end

// Sliding Window
/*
    public int minOperations(int[] nums, int x) {
        int left = 0, right = 0, length = 0, restSum = Arrays.stream(nums).sum() - x;
        if (0 == restSum) return nums.length;
        while (right < nums.length) {
            restSum -= nums[right++];
            while (left < right && 0 > restSum) {
                restSum += nums[left++];
            }
            if (0 == restSum)
                length = Math.max(length, right - left);
        }
        return 0 != length ? nums.length - length : -1;
    }
*/
