//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 数组 回溯 👍 1568 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> res = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        HashSet<Integer> columns = new HashSet<>();
        HashSet<Integer> diagonals1 = new HashSet<>();
        HashSet<Integer> diagonals2 = new HashSet<>();
        backtracking(res, queens, n, 0, columns, diagonals1, diagonals2);
        return res;
    }

    private void backtracking(ArrayList<List<String>> res, int[] queens, int n, int row, HashSet<Integer> columns, HashSet<Integer> diagonals1, HashSet<Integer> diagonals2) {
        if (row == n) {
            res.add(new ArrayList<>(generateBoard(queens, n)));
        } else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) continue;
                int diagnoal1 = row - i;
                if (diagonals1.contains(diagnoal1)) continue;
                int diagnoal2 = row + i;
                if (diagonals2.contains(diagnoal2)) continue;
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagnoal1);
                diagonals2.add(diagnoal2);
                backtracking(res,queens,n,row+1,columns,diagonals1,diagonals2);
                queens[row]=-1;
                columns.remove(i);
                diagonals1.remove(diagnoal1);
                diagonals2.remove(diagnoal2);
            }
        }
    }

    private List<String> generateBoard(int[] queens, int n) {
        ArrayList<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row,'.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
