public class MaxHuiWen {
    public static int getAns1(String s){
        return process1(s.toCharArray(),0,s.length()-1);
    }

    private static int process1(char[] c, int i, int j) {
        if(i==j){
            return 1;
        }
        if(i==j-1){
            return (c[i]==c[j])?2:1;
        }
        int p1=(c[i]==c[j])? process1(c, i+1, j-1)+2: process1(c, i+1, j-1);
        int p2=process1(c, i+1, j);
        int p3=process1(c, i, j-1);
        return Math.max(Math.max(p1,p2),p3);
    }
    public static int getAns(String s){
        if(s==null||s.length()==0){
            return 0;
        }
        int N=s.length();
        char[] c = s.toCharArray();
        int [][] dp=new int[N][N];
        for (int i = 0; i < N; i++) {
            int j=i;
            dp[i][j]=1;
        }
        for (int j = 1; j < N; j++) {
            int i=j-1;
            dp[i][j]=(c[i]==c[j])?2:1;
        }
        for (int t = 2; t < N; t++) {
            for (int j =t; j <N ; j++) {
                int i=j-t;

                int p1=(c[i]==c[j])?dp[i+1][j-1]+2:dp[i+1][j-1];
                int p2=dp[i+1][j];
                int p3=dp[i][j-1];
                dp[i][j]=Math.max(Math.max(p1,p2),p3);
            }
        }
        return dp[0][N-1];
    }
}
