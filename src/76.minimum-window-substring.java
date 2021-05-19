/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int left = 0, right = 0, start = -1, length = Integer.MAX_VALUE, valid = 0;
        HashMap<Character, Integer> target = new HashMap<Character, Integer>();
        HashMap<Character, Integer> window = new HashMap<Character, Integer>();
        for (char c : t.toCharArray())
            target.put(c, target.getOrDefault(c, 0) + 1);

        while (right < s.length()) {
            char next = s.charAt(right++);
            if (null != target.get(next)) {
                window.put(next, window.getOrDefault(next, 0) + 1);
                if (target.get(next).equals(window.get(next)))
                    valid++;
            }
            
            while (valid == target.size()) {
                if (right - left < length) {
                    start = left;
                    length = right - left;
                }
                char previous = s.charAt(left++);
                if (null != target.get(previous)) {
                    window.put(previous, window.get(previous) - 1);
                    if (target.get(previous) == window.get(previous) + 1)
                        valid--;
                }
            }
        }
        return -1 == start ? "" : s.substring(start, start + length);
    }
}
// @lc code=end
