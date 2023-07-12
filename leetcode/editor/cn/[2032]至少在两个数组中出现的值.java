//给你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个 元素各不相同的 数组，且由 至少 在 两个 数组中出现的所有值组成。数组中的
//元素可以按 任意 顺序排列。
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
//输出：[3,2]
//解释：至少在两个数组中出现的所有值为：
//- 3 ，在全部三个数组中都出现过。
//- 2 ，在数组 nums1 和 nums2 中出现过。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
//输出：[2,3,1]
//解释：至少在两个数组中出现的所有值为：
//- 2 ，在数组 nums2 和 nums3 中出现过。
//- 3 ，在数组 nums1 和 nums2 中出现过。
//- 1 ，在数组 nums1 和 nums3 中出现过。
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
//输出：[]
//解释：不存在至少在两个数组中出现的值。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length, nums3.length <= 100 
// 1 <= nums1[i], nums2[j], nums3[k] <= 100 
// 
//
// Related Topics 数组 哈希表 👍 27 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] ints = new int[101];
        setInts(nums1,ints);
        setInts(nums2,ints);
        setInts(nums3,ints);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] >= 2) res.add(i);
        }
        return res;
    }
    private void setInts(int[] nums,int[] ints){
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            ints[nums[i]]++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
