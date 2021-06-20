/*
 * @lc app=leetcode id=844 lang=java
 *
 * [844] Backspace String Compare
 */

// @lc code=start
class Solution {
    public static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        while (i >= 0 || j >= 0) {
            i = getNextAvailable(s, i);
            j = getNextAvailable(t, j);
            if (i >= 0 && j >= 0) {
                if (s.charAt(i--) != t.charAt(j--))
                    return false;
            } else if (i >= 0 || j >= 0)
                return false;
        }
        return true;
    }
    private static int getNextAvailable(String s, int i) {
        for (int available = 1; i >= 0 && (available <= 0 || s.charAt(i) == '#'); i--)
            available += s.charAt(i) == '#' ? -1 : 1;
        return i;
    }
}
// @lc code=end

// Stack
/* 
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String str) {
        StringBuffer ret = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            char ch = str.charAt(i);
            if (ch != '#')
                ret.append(ch);
            else if (ret.length() > 0)
                ret.deleteCharAt(ret.length() - 1);
        }
        return ret.toString();
    }
*/
