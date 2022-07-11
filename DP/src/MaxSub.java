public class MaxSub {
    public static int getAns1(String s1,String s2){
        if(s1==null||s2==null||s1.length()==0||s2.length()==0){
            return 0;
        }
        return process1(s1.toCharArray(),s2.toCharArray(),s1.length()-1,s2.length()-1);
    }

    private static int process1(char[] c1, char[] c2, int i, int j) {
        if(i==0&&j==0){
            return c1[i]==c2[j] ? 1:0;
        }else if(i==0){
            return c1[i]==c2[j] ? 1:process1(c1, c2, i, j-1);
        }else if (j==0){
            return c1[i]==c2[j] ? 1:process1(c1, c2, i-1, j);
        }else {
            int p1=process1(c1, c2, i, j-1);
            int p2=process1(c1, c2, i-1, j);
            int p3=(c1[i]==c2[j])? 1+process1(c1, c2, i-1, j-1) :process1(c1, c2, i-1, j-1);
            return Math.max(Math.max(p1,p2),p3);
        }
    }
    public static int getAns(String s1,String s2){
        if(s1==null||s2==null||s1.length()==0||s2.length()==0){
            return 0;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[][] dp=new int[s1.length()][s2.length()];
        dp[0][0]=(c1[0]==c2[0])?1:0;
        for (int i = 1; i < s1.length(); i++) {
            dp[i][0]=(c1[i]==c2[0])?1:dp[i-1][0];
        }
        for (int j = 1; j < s2.length(); j++) {
            dp[0][j]=(c1[0]==c2[j])?1:dp[0][j-1];
        }
        for (int j = 1; j <s2.length() ; j++) {
            for (int i = 1; i < s1.length(); i++) {
                int p1=dp[i][j-1];
                int p2=dp[i-1][j];
                int p3=(c1[i]==c2[j])? 1+dp[i-1][j-1] :dp[i-1][j-1];
                dp[i][j]=Math.max(Math.max(p1,p2),p3);
            }
        }
        return dp[s1.length()-1][s2.length()-1];
    }

    public static void main(String[] args) {
    }
}
