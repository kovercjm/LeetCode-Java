/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0, right = 0, valid = 0;
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : s1.toCharArray())
            target.put(c, target.getOrDefault(c, 0) + 1);
        
        while (right < s2.length()) {
            char next = s2.charAt(right++);
            if (target.containsKey(next)) {
                window.put(next, window.getOrDefault(next, 0) + 1);
                if (window.get(next).equals(target.get(next)))
                    valid++;
            }

            if (right - left == s1.length()) {
                if (valid == target.size())
                    return true;
                char previous = s2.charAt(left++);
                if (target.containsKey(previous)) {
                    if (window.get(previous).equals(target.get(previous)))
                        valid--;
                    window.put(previous, window.get(previous) - 1);
                }
            }
        }
        return false;
    }
}
// @lc code=end
