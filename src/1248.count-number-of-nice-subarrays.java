/*
 * @lc app=leetcode id=1248 lang=java
 *
 * [1248] Count Number of Nice Subarrays
 */

// @lc code=start
class Solution {
    public int atMostOdd(int[] nums, int k) {
        int left = 0, right = 0, count = 0;
        while (right < nums.length) {
            k -= (nums[right++] & 1) != 0 ? 1 : 0;
            while (k < 0)
                k += (nums[left++] & 1) != 0 ? 1 : 0;
            count += right - left;
        }
        return count;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return atMostOdd(nums, k) - atMostOdd(nums, k - 1);
    }
}
// @lc code=end
