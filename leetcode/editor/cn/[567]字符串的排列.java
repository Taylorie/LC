//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
//
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 803 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int valid = 0, l = 0, r = 0;
        while (r < s2.length()) {
            char charAt = s2.charAt(r++);
            window.put(charAt, window.getOrDefault(charAt, 0) + 1);
            if (window.get(charAt).equals(need.get(charAt))) ++valid;
            if (r - l == s1.length()) {
                if (valid == need.size()) return true;
                char charAt1 = s2.charAt(l);
                ++l;
                if (need.containsKey(charAt1)) {
                    if (need.get(charAt1).equals(window.get(charAt1))) --valid;
                    window.put(charAt1, window.getOrDefault(charAt1, 0) - 1);
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
