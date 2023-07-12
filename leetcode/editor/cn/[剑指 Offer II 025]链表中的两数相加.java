//给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。 
//
// 
//
// 
// 注意：本题与主站 445 题相同：https://leetcode-cn.com/problems/add-two-numbers-ii/ 
//
// Related Topics 栈 链表 数学 👍 93 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayDeque<ListNode> deque1 = new ArrayDeque<>();
        ArrayDeque<ListNode> deque2 = new ArrayDeque<>();
        ListNode dummy1 = l1, dummy2 = l2;
        while (dummy1 != null) {
            deque1.push(dummy1);
            dummy1 = dummy1.next;
        }
        while (dummy2 != null) {
            deque2.push(dummy2);
            dummy2 = dummy2.next;
        }
        ListNode node = null;
        int carry = 0;
        while (!deque1.isEmpty() || !deque2.isEmpty() || carry > 0) {
            int x = 0, y = 0;
            if (!deque1.isEmpty()) x = deque1.poll().val;
            if (!deque2.isEmpty()) y = deque2.poll().val;
            int val = x + y + carry;
            ListNode dummy = new ListNode(val % 10);
            carry = val / 10;
            dummy.next = node;
            node = dummy;
        }
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
