/*
 * @lc app=leetcode id=978 lang=java
 *
 * [978] Longest Turbulent Subarray
 */

// @lc code=start
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length <= 1) return arr.length;
        if (arr.length == 2) return arr[0] == arr[1] ? 1 : 2;

        int[] relation = new int[arr.length - 1];
        for (int i = 0; i < relation.length; i++)
            if (arr[i] > arr[i + 1])
                relation[i] = 1;
            else if (arr[i] < arr[i + 1])
                relation[i] = -1;
            else
                relation[i] = 0;

        int left = relation[0] == 0 ? 1 : 0, right = 1, max = 0;
        for (right = 1; right < relation.length; right++)
            if (relation[right] == relation[right - 1] || relation[right] == 0) {
                max = Math.max(max, right - left + 1);
                left = relation[right] == 0 ? right + 1 : right;
                continue;
            }
        return Math.max(max, (right - left + 1));
    }
}
// @lc code=end
