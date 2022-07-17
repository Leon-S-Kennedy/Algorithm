import java.util.ArrayList;

public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle.isEmpty()){
            return 0;
        }
        int N=triangle.size();
        int[][] dp=new int[N][N];
        for (int i = 0; i < N; i++) {
            dp[N-1][i]=triangle.get(N-1).get(i);
        }
        for (int j = N-2; j>=0; j--) {
            for (int i = 0; i <=j; i++) {
                dp[j][i]=Math.min(dp[j+1][i],dp[j+1][i+1])+triangle.get(j).get(i);
            }
        }
        return dp[0][0];
    }
    public static int getAns(ArrayList<ArrayList<Integer>> triangle){
        int [][] dp=new int[triangle.size()][triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.size(); j++) {
                dp[i][j]=Integer.MIN_VALUE;
            }
        }
        return process(triangle,0,0,dp);
    }
    public static int process(ArrayList<ArrayList<Integer>> triangle,int i,int j,int[][] dp){
        if (dp[i][j]!=Integer.MIN_VALUE){
            return dp[i][j];
        }
        int ans=0;
        if(i==triangle.size()-1){
            ans=triangle.get(triangle.size()-1).get(j);
            dp[i][j]=ans;
            return ans;
        }
        ans= Math.min(process(triangle,i+1,j,dp),process(triangle, i+1, j+1,dp))+triangle.get(i).get(j);
        dp[i][j]=ans;
        return ans;
    }

}
