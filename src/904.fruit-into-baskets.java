/*
 * @lc app=leetcode id=904 lang=java
 *
 * [904] Fruit Into Baskets
 */

// @lc code=start
class Solution {
    public int totalFruit(int[] tree) {
        int left = 0, right = 0, answer = 0, sum = 0;
        Map<Integer, Integer> window = new HashMap<>();
        while (right < tree.length) {
            int next = tree[right++];
            window.put(next, window.getOrDefault(next, 0) + 1);
            sum++;

            while (window.size() > 2) {
                int previous = tree[left++];
                answer = Math.max(--sum, answer);
                if (window.get(previous) == 1)
                    window.remove(previous);
                else
                    window.put(previous, window.get(previous) - 1);
            }
        }
        return Math.max(sum, answer);
    }
}
// @lc code=end
