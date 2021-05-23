/*
 * @lc app=leetcode id=930 lang=java
 *
 * [930] Binary Subarrays With Sum
 */

// @lc code=start
class Solution {
    // Count Zero
    public int numSubarraysWithSum(int[] nums, int goal) {
        int left = 0, sum = 0, count = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (left < right && sum > goal)
                sum -= nums[left++];
            if (sum == goal) {
                int zero = left;
                while (zero < right && 0 == nums[zero])
                    zero++;
                count += zero - left + 1;
            }
        }
        return count;
    }
}
// @lc code=end

// 前缀和
/*
    public int atMostSum(int[] nums, int goal) {
        if (goal < 0) return 0;
        int left = 0, sum = 0, result = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > goal)
                sum -= nums[left++];
            result += right - left + 1;
        }
        return result;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMostSum(nums, goal) - atMostSum(nums, goal - 1);
    }
*/
