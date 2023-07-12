//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。 
//
// 示例 1： 
//
// 
//输入: s = "leetcode"
//输出: false 
// 
//
// 示例 2： 
//
// 
//输入: s = "abc"
//输出: true
// 
//
// 限制： 
//
// 
// 0 <= len(s) <= 100 
// s[i]仅包含小写字母 
// 如果你不使用额外的数据结构，会很加分。 
// 
//
// Related Topics 位运算 哈希表 字符串 排序 👍 285 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isUnique(String astr) {
        int i = 0;
        for (char c : astr.toCharArray()) {
            int index = c - 'a';
            if((i&(1<<index))!=0)return false;
            else
            i |= 1 << index;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
