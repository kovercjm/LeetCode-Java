/*
 * @lc app=leetcode id=1248 lang=java
 *
 * [1248] Count Number of Nice Subarrays
 */

// @lc code=start
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostOdd(nums, k) - atMostOdd(nums, k - 1);
    }
    public int atMostOdd(int[] nums, int k) {
        int left = 0, right = 0, count = 0;
        while (right < nums.length) {
            k -= 0 != (nums[right++] & 1) ? 1 : 0;
            while (k < 0)
                k += 0 != (nums[left++] & 1) ? 1 : 0;
            count += right - left;
        }
        return count;
    }
}
// @lc code=end
