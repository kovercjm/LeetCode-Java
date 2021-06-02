/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> position = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (position.containsKey(target - nums[i]))
                return new int[]{position.get(target - nums[i]), i};
            position.put(nums[i], i);
        }
        return null;
    }
}
// @lc code=end
