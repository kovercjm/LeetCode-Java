/*
 * @lc app=leetcode id=1658 lang=java
 *
 * [1658] Minimum Operations to Reduce X to Zero
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums, int x) {
        int numsLength = nums.length, result = Integer.MAX_VALUE;
        Map<Integer, Integer> leftPrefixSum = new HashMap<>();
        Map<Integer, Integer> rightPrefixSum = new HashMap<>();

        for (int i = 0, sum = 0; i < numsLength && sum <= x; i++){
            sum += nums[i];
            leftPrefixSum.put(sum, i + 1);
        }
        if (leftPrefixSum.containsKey(x))
            result = Math.min(result, leftPrefixSum.get(x));
        else if (leftPrefixSum.size() == numsLength)
           return -1;

        for (int i = numsLength - 1, sum = 0; i >= 0 && sum <= x; i--){
            sum += nums[i];
            rightPrefixSum.put(sum, numsLength - i);
        }
        if (rightPrefixSum.containsKey(x))
            result = Math.min(result, rightPrefixSum.get(x));

        for (int key : leftPrefixSum.keySet()) {
            if (rightPrefixSum.containsKey(x - key))
                result = Math.min(result, (rightPrefixSum.get(x - key) + leftPrefixSum.get(key)));
        }
        return Integer.MAX_VALUE == result ? -1 : result;
    }
}
// @lc code=end

// Sliding Window
/*
    public int minOperations(int[] nums, int x) {
        int left = 0, right = 0, length = 0, restSum = Arrays.stream(nums).sum() - x;
        if (0 == restSum) return nums.length;
        while (right < nums.length) {
            restSum -= nums[right++];
            while (left < right && 0 > restSum) {
                restSum += nums[left++];
            }
            if (0 == restSum)
                length = Math.max(length, right - left);
        }
        return 0 != length ? nums.length - length : -1;
    }
*/
