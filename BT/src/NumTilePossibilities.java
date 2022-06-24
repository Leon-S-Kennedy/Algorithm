import java.util.*;

public class NumTilePossibilities {
    public int numTilePossibilities(String tiles) {
        int[] list=new int[26];
        for (char c : tiles.toCharArray()) {
            list[c-'A']++;
        }
        return dfs(list);
    }
    public int dfs(int[] list){
        int sum=0;
        for (int i = 0; i < 26; i++) {
            if(list[i]==0){
                continue;
            }
            list[i]--;
            sum++;
            sum+=dfs(list);
            list[i]++;
        }
        return sum;
    }
    //此方法使用词频的方法将问题抽象化，不直接去排列字母，而是直接通过一个词频列表来辅助统计个数。厉害厉害！！！
}
