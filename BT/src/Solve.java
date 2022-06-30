public class Solve {
    int[] dx=new int[]{1,0,0,-1};
    int[] dy=new int[]{0,1,-1,0};
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int[][] T=new int[m][n];

        for (int i = 0; i < n; i++) {
            if(board[0][i]=='O'){
                dfs(board,T,0,i,m,n);
            }
            if(board[m-1][i]=='O'){
                dfs(board,T,m-1,i,m,n);
            }
        }
        for (int i = 1; i < m-1; i++) {
            if(board[i][0]=='O'){
                dfs(board,T,i,0,m,n);
            }
            if(board[i][n-1]=='O'){
                dfs(board,T,i,n-1,m,n);
            }
        }
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < m-1; j++) {
                if(board[j][i]=='O'){
                    board[j][i]='X';
                }
            }
        }
        System.out.println();
    }

    private void dfs1(char[][] board, int[][] t, int x, int y, int m, int n) {
/*
        if(!(0<=x&&x<m&&0<=y&&y<n)){
            return;
        }
*/
        if(board[x][y]=='X'){
            return;
        }
        if(t[x][y]==2){
            return;
        }
        board[x][y]='X';
        t[x][y]=2;
        for (int i = 0; i < 4; i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            dfs1(board, t, nx, ny, m, n);
        }
    }

    private void dfs(char[][] board, int[][] t, int x, int y,int m,int n) {
        if(!(0<=x&&x<m&&0<=y&&y<n)){
            return;
        }
        if(board[x][y]=='X'){
            return;
        }
        if(t[x][y]==2){
            return;
        }
        t[x][y]=2;
        for (int i = 0; i < 4; i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            dfs(board, t, nx, ny, m, n);
        }
    }

    public static void main(String[] args) {
        char[][] board=new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        Solve solve = new Solve();
        solve.solve(board);
    }
}
