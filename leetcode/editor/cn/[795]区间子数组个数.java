//给你一个整数数组 nums 和两个整数：left 及 right 。找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组
//，并返回满足条件的子数组的个数。 
//
// 生成的测试用例保证结果符合 32-bit 整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,1,4,3], left = 2, right = 3
//输出：3
//解释：满足条件的三个子数组：[2], [2, 1], [3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,9,2,5,6], left = 2, right = 8
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 0 <= left <= right <= 10⁹ 
// 
//
// Related Topics 数组 双指针 👍 233 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int l = 0, r = 0, len = nums.length;
        List<Integer> res = new ArrayList<>();
        while (l < len) {
            //找到L
            while (nums[l] > left && nums[l] < right) {
                ++l;
                if (l >= len) break;
            }
            r = l;
            while (r <= len && nums[r] >= left && nums[r] <= right) {
                ++r;
            }
            --r;
            res.add(r - l + 1);
            l = r + 1;
        }
        if (res.size() == 0) return 0;
        int count = 0;
        for (Integer i : res) {
            for (int integer = 1; integer <= i; integer++) {
                count += i;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
