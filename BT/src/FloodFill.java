import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FloodFill {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if(currColor!=newColor){
            dfs(image, sr, sc, currColor, newColor);
        }
        return image;
    }

    public void dfs(int[][] image, int x, int y, int color, int newColor) {
        if (image[x][y] == color) {
            image[x][y] = newColor;
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < image.length && my >= 0 && my < image[0].length) {
                    dfs(image, mx, my, color, newColor);
                }
            }
        }
    }
    public int[][] floodFill1(int[][] image, int sr, int sc, int newColor){
        if(image[sr][sc]!=newColor){
            dfs1(image,sr,sc,image[sr][sc],newColor);
        }
        return image;
    }
    public void dfs1(int[][] image, int x, int y, int color, int newColor){
        if(image[x][y]==color){
            for (int i = 0; i < 4; i++) {
                int mx=x+dx[i];
                int my=y+dy[i];
                if(0<=mx&&mx< image.length&& my >= 0 && my < image[0].length){
                   dfs1(image, mx, my, color, newColor);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] image=new int[][]{{0,0,0},{0,1,1}};
        for (int[] ints : new FloodFill().floodFill(image, 1, 1, 1)) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }
}
