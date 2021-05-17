/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (1 >= nums.length) return nums.length;
        int i = 0; 
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] < nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
// @lc code=end
