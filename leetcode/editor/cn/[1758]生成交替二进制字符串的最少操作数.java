//给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。 
//
// 交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。例如，字符串 "010" 是交替字符串，而字符串 "0100" 
//不是。 
//
// 返回使 s 变成 交替字符串 所需的 最少 操作数。 
//
// 
//
// 示例 1： 
//
// 输入：s = "0100"
//输出：1
//解释：如果将最后一个字符变为 '1' ，s 就变成 "0101" ，即符合交替字符串定义。
// 
//
// 示例 2： 
//
// 输入：s = "10"
//输出：0
//解释：s 已经是交替字符串。
// 
//
// 示例 3： 
//
// 输入：s = "1111"
//输出：2
//解释：需要 2 步操作得到 "0101" 或 "1010" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s[i] 是 '0' 或 '1' 
// 
//
// Related Topics 字符串 👍 52 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minOperations(String s) {
        char[] array = s.toCharArray();
        if (array.length == 1) return 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != ((i % 2) == 0 ? '1' : '0')) count1++;
            if (array[i] != ((i % 2) == 1 ? '1' : '0')) count2++;
        }
        return Math.min(count1, count2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
