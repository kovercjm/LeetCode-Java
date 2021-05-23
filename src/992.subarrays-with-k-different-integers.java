/*
 * @lc app=leetcode id=992 lang=java
 *
 * [992] Subarrays with K Different Integers
 */

// @lc code=start
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    public int atMostK(int[] nums, int k) {
        int left = 0, result = 0;
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            count.put(nums[right], count.getOrDefault(nums[right], 0) + 1);
            while (k < count.size()) {
                if (1 == count.get(nums[left]))
                    count.remove(nums[left++]);
                else
                    count.put(nums[left], count.get(nums[left++]) - 1);
            }
            result += right - left + 1;
        }
        return result;
    }
}
// @lc code=end
