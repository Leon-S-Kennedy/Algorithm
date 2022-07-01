import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveNQueens {
    List<List<String>> res=new ArrayList<>();       //定义一个全局变量存放结果

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard=new char[n][n];         //定义一个二维数组表示棋盘情况
        for (char[] chars : chessboard) {           //将棋盘进行初始化
            Arrays.fill(chars,'.');
        }
        backtrack(n,0,chessboard);                  //调用回溯方法
        return res;
    }

    /**
     *
     * @param n             表示皇后的个数
     * @param row             表示开始的层数
     * @param chessboard    表示棋盘
     */
    private void backtrack(int n, int row, char[][] chessboard) {
        if(row==n){
            //此时表示n个皇后已经就位，此时我们应该保存结果并返回
            res.add(Array2List(chessboard));
            return;
        }
        for (int col = 0; col < n; col++) {
            if(isValid(n,chessboard,row,col)){      //表示此时的棋盘可以放置皇后
                chessboard[row][col]='Q';
                backtrack(n,row+1,chessboard);
                chessboard[row][col]='.';            //此步表示回溯
            }
        }
    }

    private boolean isValid(int n, char[][] chessboard, int row, int col) {
        //如何检查是否合法呢？
        //我们可以知道，该行一定在之前的皇后下面的行，所以该点合不合法
        //只需要判断是否同列、是否位于右下（-45°）、左下（-135°）
        for (int i = 0; i < row; i++) {             //检查同列上是否含有’Q‘
            if(chessboard[i][col]=='Q'){
                return false;
            }
        }
        for (int m = 0; row-m>=0&&col-m>=0 ; m++) { //检查（-45°）表示行数和列数均在范围内
            if(chessboard[row-m][col-m]=='Q'){
                return false;
            }
        }
        for (int m = 0; row-m>=0&&col+m<n ; m++) { //检查（-135°）表示行数和列数均在范围内
            if(chessboard[row-m][col+m]=='Q'){
                return false;
            }
        }
        return true;
    }

    private List<String> Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(new String(c));
        }
        return list;
    }
}
