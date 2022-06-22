public class MaxAreaOfIsland {
    int[] dx={-1,0,0,1};
    int[] dy={0,1,-1,0};
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int max=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1){
                    max=Math.max(max,dfs(grid,i,j,m,n));
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int x, int y, int m, int n) {
        if (!(0 <= x && x < m && 0 <= y && y < n)||grid[x][y]==0) {
            return 0;
        }
        grid[x][y]=0;
        int num=1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            num+=dfs(grid, nx, ny, m, n);
        }
        return num;
    }

    public static void main(String[] args) {
        int[][] a=new int[][]{
                {0,0,1},
                {0,0,0},
                {0,1,1},
        };
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        System.out.println(maxAreaOfIsland.maxAreaOfIsland(a));
    }
}
