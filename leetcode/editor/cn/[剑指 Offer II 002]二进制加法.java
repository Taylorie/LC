//给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: a = "11", b = "10"
//输出: "101" 
//
// 示例 2: 
//
// 
//输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
//
// 
//
// 
// 注意：本题与主站 67 题相同：https://leetcode-cn.com/problems/add-binary/ 
//
// Related Topics 位运算 数学 字符串 模拟 👍 62 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        int aLen = a.length() - 1;
        int bLen = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (aLen >= 0 || bLen >= 0) {
            int aChar = aLen >= 0 ? a.charAt(aLen--) == '1' ? 1 : 0 : 0;
            int bChar = bLen >= 0 ? b.charAt(bLen--) == '1' ? 1 : 0 : 0;
            int sum = aChar + bChar + carry;
            carry = sum >= 2 ? 1 : 0;
            sb.append(sum % 2);
        }
        if(carry==1)sb.append(1);
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
