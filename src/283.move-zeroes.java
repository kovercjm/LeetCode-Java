/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        while (i < nums.length && nums[i] != 0)
            i++;
        if (i == nums.length) return;

        int j = i;
        while (++j < nums.length)
            if (nums[j] != 0)
                nums[i++] = nums[j];
        while (i < nums.length)
            nums[i++] = 0;
        return;
    }
}
// @lc code=end
