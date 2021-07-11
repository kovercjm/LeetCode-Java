/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;

        int[] best = new int[amount + 1];
        best[0] = 0;

        for (int i = 1; i <= amount; i++) {
            best[i] = amount + 1;
            for (int coin : coins) {
                if (coin > i) continue;
                best[i] = Math.min(best[i], best[i - coin] + 1);
            }
        }
        return best[amount] == amount + 1 ? -1 : best[amount];
    }
}
// @lc code=end
