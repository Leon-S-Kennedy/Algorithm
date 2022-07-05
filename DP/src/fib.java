public class fib {
    public static int fib1(int n){
        if(n==1||n==2){
            return 1;
        }
        return fib1(n-1)+fib1(n-2);
    }
    public static int fib2(int n,int[] dp){
        dp[0]=0;
        dp[1]=1;
        for (int i = 2; i <=n ; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }


    public static int fib3(int n){
        int [] dp=new int[n+1];
        return pocess2(n,dp);
    }
    public static int pocess2(int n, int[] dp) {
        if(dp[n]!=0){
            return dp[n];
        }
        int ans=0;
        if(n==1||n==2){
            ans=1;
        }else{
            ans = pocess2(n - 1, dp) + pocess2(n - 2, dp);
        }
        dp[n]=ans;
        return ans;
    }
    public static int fib4(int n){
        int[] F=new int[n+1];
        F[0]=0;
        F[1]=1;
        for (int i = 2; i <=n; i++) {
            F[i]=F[i-1]+F[i-2];
        }
        return F[n];
    }

    public static int fib5(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 1;
        }
        int fn=0;
        int fn2=0,fn1=1;
        for (int i = 2; i <=n; i++) {
            fn=fn1+fn2;
            fn2=fn1;
            fn1=fn;
        }
        return fn;
    }


    public static void main(String[] args) {
        System.out.println(fib1(7));
        System.out.println(fib2(7,new int[7+1]));
        System.out.println(fib3(7));
        System.out.println(fib4(7));
        System.out.println(fib5(7));
    }
}
