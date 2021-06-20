/*
 * @lc app=leetcode id=977 lang=java
 *
 * [977] Squares of a Sorted Array
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int i = 0, j = nums.length - 1;
        for (int r = nums.length - 1; r >= 0; r--)
            if (Math.abs(nums[i]) < Math.abs(nums[j]))
                result[r] = nums[j] * nums[j--];
            else 
                result[r] = nums[i] * nums[i++];
        return result;    
    }
}
// @lc code=end
