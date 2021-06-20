/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {
    public int[][] result;

    public int count(int min, int max) {
        if (min >= max) return 1;
        if (result[min][max] != 0)
            return result[min][max];
        
        int sum = 0;
        for (int i = min; i <= max; i++)
            sum += count(min, i - 1) * count (i + 1, max);
        result[min][max] = sum;
        return sum;
    }
    public int numTrees(int n) {
        result = new int[n][n];
        return count(0, n - 1);
    }
}
// @lc code=end
