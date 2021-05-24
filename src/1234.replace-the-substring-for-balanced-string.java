/*
 * @lc app=leetcode id=1234 lang=java
 *
 * [1234] Replace the Substring for Balanced String
 */

// @lc code=start
class Solution {
    public int balancedString(String s) {
        int quarter = s.length() / 4, left = 0, right = 0, length = s.length();
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'A']++;

        if (count['Q' - 'A'] <= quarter && count['W' - 'A'] <= quarter && count['E' - 'A'] <= quarter && count['R' - 'A'] <= quarter)
            return 0;

        while (right < s.length()) {
            count[s.charAt(right++) - 'A']--;
            while (left < right && count['Q' - 'A'] <= quarter && count['W' - 'A'] <= quarter && count['E' - 'A'] <= quarter && count['R' - 'A'] <= quarter) {
                length = Math.min(length, right - left);
                count[s.charAt(left++) - 'A']++;
            }
        }
        return length;
    }
}
// @lc code=end
