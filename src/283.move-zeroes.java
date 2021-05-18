/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        while (i < nums.length && 0 != nums[i]) {
            i++;
        }
        if (i == nums.length) return;

        int j = i;
        while (++j < nums.length) {
            if (0 != nums[j]) {
                nums[i++] = nums[j];
            }
        }
        while (i < nums.length) {
            nums[i++] = 0;
        }
        return;
    }
}
// @lc code=end
