public class NumIslands {
    int[] dx={-1,0,0,1};
    int[] dy={0,1,-1,0};
    public int numIslands(char[][] grid) {
         int m=grid.length;
         int n=grid[0].length;
         int[][] T=new int[m][n];
         int sum=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]=='1'&&T[i][j]!=2){
                    dfs(grid,T,i,j,m,n);
                    sum++;
                }
            }
        }
        return sum;
    }

    private void dfs(char[][] grid, int[][] t, int x, int y, int m, int n) {
        if (!(0 <= x && x < m && 0 <= y && y < n)||grid[x][y]=='0') {
            return;
        }
        grid[x][y]=0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(grid, t, nx, ny, m, n);
        }
    }

    public static void main(String[] args) {

    }
}
