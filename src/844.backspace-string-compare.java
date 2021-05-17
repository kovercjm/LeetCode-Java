/*
 * @lc app=leetcode id=844 lang=java
 *
 * [844] Backspace String Compare
 */

// @lc code=start
class Solution {
    public static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        while (i >= 0 && j >= 0) {
            for (int available = 1; 0 <= i && (available <= 0 || '#' == s.charAt(i)); i--) {
                available += '#' == s.charAt(i) ? -1 : 1;
            }
            for (int available = 1; 0 <= j && (available <= 0 || '#' == t.charAt(j)); j--) {
                available += '#' == t.charAt(j) ? -1 : 1;
            }
            if (0 > i && 0 > j)
                return true;
            else if (0 > i || 0 > j || s.charAt(i--) != t.charAt(j--))
                break;
        }
        return i == j;
    }
}
// @lc code=end
