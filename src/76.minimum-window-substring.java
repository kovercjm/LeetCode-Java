/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int left = 0, right = 0, start = -1, length = Integer.MAX_VALUE, valid = 0;
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray())
            target.put(c, target.getOrDefault(c, 0) + 1);

        while (s.length() > right) {
            char next = s.charAt(right++);
            if (target.get(next) != null) {
                window.put(next, window.getOrDefault(next, 0) + 1);
                if (target.get(next).equals(window.get(next)))
                    valid++;
            }
            
            while (target.size() == valid) {
                if (right - left < length) {
                    start = left;
                    length = right - left;
                }
                char previous = s.charAt(left++);
                if (target.get(previous) != null) {
                    window.put(previous, window.get(previous) - 1);
                    if (target.get(previous).equals(window.get(previous) + 1))
                        valid--;
                }
            }
        }
        return start == -1 ? "" : s.substring(start, start + length);
    }
}
// @lc code=end
