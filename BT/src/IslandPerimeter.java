public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int i=0;
        int j=0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    // 题目限制只有一个岛屿，计算一个即可
                    i=r;
                    j=c;
                    break;
                    /*
                    * 如果是多个呢，我们就遍历全部的，然后统统 +=   最后返回即可
                    *
                    * */
                }
            }
        }
        return dfs(grid,i,j);
    }

    int dfs(int[][] grid, int r, int c) {
        if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length)) { //此处代表边界
            return 1;
        }
        if (grid[r][c] == 0) {  //此处代表海洋
            return 1;
        }
        if (grid[r][c] == 2) {  //因为走过的为2，所以此处为走过的路，必须返回
            return 0;
        }
        grid[r][c] = 2;
        return dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1)
                + dfs(grid, r, c + 1);
    }

    public static void main(String[] args) {
        int[][] grid=new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        IslandPerimeter islandPerimeter = new IslandPerimeter();
        System.out.println(islandPerimeter.islandPerimeter(grid));
/*
        for (int[] ints : islandPerimeter.islandPerimeter(grid)) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
*/
    }
}
