public class NumDistinct {
    public static int numDistinct (String S, String T) {
        if(S.length()<T.length()){
            return 0;
        }

        int[][] dp=new int[S.length()+1][T.length()+1];
        for (int i = 0; i <=S.length(); i++) {
            for (int j = 0; j <= T.length(); j++) {
                dp[i][j]=-1;
            }
        }
        return process(S.toCharArray(),T.toCharArray(),S.length()-1,T.length()-1,dp);
    }

    private static int process(char[] s, char[] t, int i, int j,int[][] dp) {

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if(j>i){
            ans= 0;
            dp[i][j]=ans;
            return ans;
        }
        if(j==0){
            if(i==0){
                ans= s[i]==t[j] ?1:0;
                dp[i][j]=ans;
                return ans;
            }
            ans= s[i]==t[j]?1+process(s, t, i-1, j,dp):process(s, t, i-1, j,dp);
            dp[i][j]=ans;
            return ans;
        }
        ans= s[i]==t[j]?process(s, t, i-1, j-1,dp)+process(s, t, i-1, j,dp):process(s, t, i-1, j,dp);
        dp[i][j]=ans;
        return ans;
    }

    public static void main(String[] args) {
        String s="ccc";
        String t="c";
        System.out.println(numDistinct(s, t));

    }
}
