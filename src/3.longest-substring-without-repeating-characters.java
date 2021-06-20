/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, length = Integer.MIN_VALUE;
        Map<Character, Integer> window = new HashMap<>();

        while (s.length() > right) {
            window.put(s.charAt(right), window.getOrDefault(s.charAt(right++), 0) + 1);

            while (window.get(s.charAt(right - 1)) > 1) {
                length = Math.max(right - left - 1, length);
                window.put(s.charAt(left), window.get(s.charAt(left++)) - 1);
            }
        }
        return Integer.MIN_VALUE == length ? s.length() : Math.max(right - left, length);
    }
}
// @lc code=end
