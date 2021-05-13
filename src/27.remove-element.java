/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int end = -1;
        for (int cur = 0; cur < nums.length; cur++)
            if (nums[cur] != val) {
                nums[++end] = nums[cur];
            }
        return end + 1;
    }
}
// @lc code=end
