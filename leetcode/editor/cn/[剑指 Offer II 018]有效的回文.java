//给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 本题中，将空字符串定义为有效的 回文串 。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串 
//
// 示例 2: 
//
// 
//输入: s = "race a car"
//输出: false
//解释："raceacar" 不是回文串 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// 字符串 s 由 ASCII 字符组成 
// 
//
// 
//
// 
// 注意：本题与主站 125 题相同： https://leetcode-cn.com/problems/valid-palindrome/ 
//
// Related Topics 双指针 字符串 👍 52 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            while (left <= right && !Character.isLetterOrDigit(s.charAt(left)))
                ++left;
            while (left <= right && !Character.isLetterOrDigit(s.charAt(right)))
                --right;

            if (left <= right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            ++left;
            --right;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
