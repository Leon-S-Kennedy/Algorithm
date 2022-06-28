import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class OrangesRotting {
    int time=0;
    int[] dx=new int[]{1,0,0,-1};
    int[] dy=new int[]{0,1,-1,0};
    public int orangesRotting(int[][] grid) {
        if(grid==null){
            return -1;
        }
        int r=grid.length;
        int c=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        Map<Integer,Integer> depath=new HashMap<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                    grid[i][j]=0;
                }
            }
        }
        int res=0;
        while(!queue.isEmpty()){
            boolean flag=false;
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx=cur[0]+dx[j];
                    int ny=cur[1]+dy[j];
                    if(0<=nx&&nx<r&&0<=ny&&ny<c&&grid[nx][ny]==1){          //在范围内并且是个好橘子 才有资格成为烂橘子
                        flag=true;
                        grid[nx][ny]=2;
                        queue.offer(new int[]{nx,ny});
                    }
                }
            }
            if(flag){
                time++;
            }
        }
        for (int[] ints : grid) {
            for (int j = 0; j < c; j++) {
                if (ints[j] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }

    public static void main(String[] args) {
        int[][] grid=new int[][]{
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        int i = new OrangesRotting().orangesRotting(grid);
        System.out.println(i);
    }
}
