/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int length = 1;
        tails[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tails[length - 1])
                tails[length++] = nums[i];
            else {
                int left = 0, right = length, mid;
                while (left < right) {
                    mid = left + (right - left) / 2;
                    if (tails[mid] > nums[i])
                        right = mid;
                    else if (tails[mid] < nums[i])
                        left = mid + 1;
                    else if (tails[mid] == nums[i])
                        right = mid;
                }
                tails[left] = nums[i];
            }
        }
        return length;
    }
}
// @lc code=end

// DP solution
/*
    public int lengthOfLIS(int[] nums) {
        int[] length = new int[nums.length];
        length[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            length[i] = 1;
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j])
                    length[i] = Math.max(length[i], length[j] + 1);
        }
        int max = 0;
        for (int l : length)
            max = Math.max(max, l);
        return max;
    }
*/
