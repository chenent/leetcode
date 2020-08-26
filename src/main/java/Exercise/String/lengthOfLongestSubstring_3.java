package Exercise.String;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstring_3 {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len <= 1) return len;
        Set<Character> set = new HashSet<>();
        int right = -1, ans = 0;
        for (int left = 0; left < len; left++) {
            if (left > 0) set.remove(s.charAt(left - 1));
            while (right + 1 < len && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new lengthOfLongestSubstring_3().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new lengthOfLongestSubstring_3().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new lengthOfLongestSubstring_3().lengthOfLongestSubstring("abcabcbb"));
    }

}
