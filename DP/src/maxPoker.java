public class maxPoker {
    public static int getAns1(int[] arr){
        int p1=f1(arr,0,arr.length-1);    //表示先手最优解即A的最高分数
        int p2=g1(arr,0,arr.length-1);    //表示后手最优解即B的最高分数
        return Math.max(p1,p2);
    }

    private static int f1(int[] arr, int i, int j) {
        if(i==j){
            return arr[i];
        }
        return Math.max(arr[i]+g1(arr,i+1,j),arr[j]+g1(arr,i,j-1));
    }

    private static int g1(int[] arr, int i, int j) {
        if(i==j){
            return 0;
        }
        return Math.min(f1(arr,i+1,j),f1(arr,i,j-1));
    }
    public static int getAns2(int[] arr){
        int N=arr.length;
        int[][] dp1=new int[N][N];
        int[][] dp2=new int[N][N];
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j < N; j++) {
                dp1[i][j]=-1;
                dp2[i][j]=-1;
            }
        }
        return Math.max(f2(arr,0,N-1,dp1,dp2),g2(arr,0,N-1,dp1,dp2));
    }

    private static int f2(int[] arr, int i, int j,int[][] dp1,int[][] dp2) {
        if(dp1[i][j]!=-1){
            return dp1[i][j];
        }
        int ans=0;
        if(i==j){
            ans=arr[i];
            dp1[i][j]=ans;
            return ans;
        }
        ans=Math.max(arr[i]+g2(arr,i+1,j,dp1,dp2),arr[j]+g2(arr,i,j-1,dp1,dp2));
        dp1[i][j]=ans;
        return ans;
    }

    private static int g2(int[] arr, int i, int j,int[][]dp1,int[][] dp2) {
        if(dp2[i][j]!=-1){
            return dp2[i][j];
        }
        int ans=0;
        if(i==j){
            ans=0;
            dp2[i][j]=ans;
            return ans;
        }
        ans=Math.min(f2(arr,i+1,j,dp1,dp2),f2(arr,i,j-1,dp1,dp2));
        dp2[i][j]=ans;
        return ans;
    }
    public static int getAns3(int[] arr){
        int N=arr.length;
        int[][] dp1=new int[N][N];
        int[][] dp2=new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp1[i][j]=arr[i];
            }
        }
        for (int i = 1; i < N; i++) {
            int row=0;
            int col=i;
            while (col<N){
                dp1[row][col]=Math.max((arr[row]+dp2[row+1][col]),(arr[col]+dp2[row][col-1]));
                dp2[row][col]=Math.min(dp1[row+1][col],dp1[row][col-1]);
                row++;
                col++;
            }
        }
        return Math.max(dp1[0][N-1],dp2[0][N-1]);
    }


    public static void main(String[] args) {
        int[] arr=new int[]{5,10,2,1};
        System.out.println(getAns1(arr));
        System.out.println(getAns2(arr));
        System.out.println(getAns3(arr));
    }
}
