/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int left = 0, right = 0, valid = 0;
        List<Integer> answer = new ArrayList<>();
        Map<Character, Integer> target = new HashMap<>(p.length());
        Map<Character, Integer> window = new HashMap<>(p.length());
        for (char c : p.toCharArray())
            target.put(c, target.getOrDefault(c, 0) + 1);
        
        while (right < s.length()) {
            char current = s.charAt(right++);
            if (target.containsKey(current)) {
                window.put(current, window.getOrDefault(current, 0) + 1);
                if (target.get(current).equals(window.get(current)))
                    valid++;
            }

            if (right - left == p.length()) {
                if (target.size() == valid)
                    answer.add(left);
                char previous = s.charAt(left++);
                if (target.containsKey(previous)) {
                    if (target.get(previous).equals(window.get(previous)))
                        valid--;
                    window.put(previous, window.get(previous) - 1);
                }
            }
        }
        return answer;
    }
}
// @lc code=end
