//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2892 👎 0

package editor.cn;

/**
 *
 */
//java:最长回文子串
public class P5LongestPalindromicSubstring {
    public void main(String[] args) {
        Solution solution = new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            int i = 0;
            int start = 0, end = 0;
            while (i < n) {
                int j = i;
                while (j + 1 < n && s.charAt(j) == s.charAt(j + 1)) {
                    j++;
                }
                int left = i, right = j;
                while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                }
                if (right - left > end - start) {
                    start = left;
                    end = right;
                }
                i = j + 1;//跳过相同的
            }
            return s.substring(start + 1, end);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}