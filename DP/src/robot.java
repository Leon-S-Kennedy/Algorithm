public class robot {
    public static int getAns1(int n ,int start,int p,int aim){
        return process1(n,start,p,aim);
    }
    public static int process1(int N,int cur,int rest,int aim){
        if(rest==0){
            return cur==aim? 1:0;
        }
        if(cur==1){
            return process1(N,2,rest-1,aim);
        }
        if(cur==N){
            return process1(N,N-1,rest-1,aim);
        }
        return process1(N,cur-1,rest-1,aim)+process1(N,cur+1,rest-1,aim);
    }
    public static int getAns2(int n ,int start,int p,int aim){
        int[][] dp=new int[n+1][p+1];
        for (int i = 0; i <=n ; i++) {
            for (int j = 0; j <=p ; j++) {
                dp[i][j]=-1;
            }
        }
        return process2(n,start,p,aim,dp);
    }

    private static int process2(int n, int start, int p, int aim,int[][] dp) {
        if(dp[start][p]!=-1){
            return dp[start][p];
        }
        //此处表示之前没有算过
        int ans=0;
        if(p==0){
            ans= start==aim ? 1:0;
            dp[start][p]=ans;
            return ans;

        }
        if(start==1){
            ans=process2(n,2,p-1,aim,dp);
            dp[start][p]=ans;
            return ans;

        }
        if(start==n){
            ans=process2(n,n-1,p-1,aim,dp);
            dp[start][p]=ans;
            return ans;

        }
        ans=process2(n,start-1,p-1,aim,dp)+process2(n,start+1,p-1,aim,dp);

        dp[start][p]=ans;
        return ans;
    }
    public static int getAns3(int n ,int start,int p,int aim){
        int[][] dp=new int[n+1][p+1];
        dp[aim][0]=1;
        for (int j = 1; j <=p ; j++) {
            dp[1][j]=dp[2][j-1];
            for (int i = 2; i <=n-1 ; i++) {
                dp[i][j]=dp[i-1][j-1]+dp[i+1][j-1];
            }
            dp[n][j]=dp[n-1][j-1];
        }
        return dp[start][p];
    }

    public static void main(String[] args) {
        System.out.println(getAns1(5,2,6,4));
        System.out.println(getAns2(5,2,6,4));
        System.out.println(getAns3(5,2,6,4));
    }

}
