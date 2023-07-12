//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints <= 2 * 10⁴ 
// timePoints[i] 格式为 "HH:MM" 
// 
//
// 
//
// 
// 注意：本题与主站 539 题相同： https://leetcode-cn.com/problems/minimum-time-difference/ 
//
// Related Topics 数组 数学 字符串 排序 👍 44 👎 0


import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 60 * 24) return 0;
        Collections.sort(timePoints);
        int ans = Integer.MAX_VALUE;
        int first = getMinutes(timePoints.get(0));
        System.out.println(first);
        int prev = first;
        for (int i = 1; i < timePoints.size(); i++) {
            int minutes = getMinutes(timePoints.get(i));
            ans = Math.min(ans, minutes-prev);
            if (ans == 0) return 0;
            prev = minutes;
        }
        ans = Math.min(ans, first + 1440 - prev);
        return ans;
    }

    private int getMinutes(String time) {
        return ((time.charAt(0) - '0') * 10 + (time.charAt(1) - '0')) * 60 + ((time.charAt(3) - '0') * 10 + (time.charAt(4) - '0'));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
