public class ChinaChass {
    public static int getAns1(int x, int y, int k) {
        return process1(x, y, 0, 0, k);
    }
    public static int process1(int x, int y, int i, int j, int rest) {
        if (rest == 0) {
            return (i == x && j == y) ?1:0;
        }
        if (i<0||i>8||j<0||j>9) {
            return 0;
        }
        int ways =process1(x, y, i-1, j-2, rest-1);
        ways+=process1(x, y, i-1, j+2, rest-1);
        ways+=process1(x, y, i+1, j+2, rest-1);
        ways+=process1(x, y, i+1, j-2, rest-1);
        ways+=process1(x, y, i-2, j+1, rest-1);
        ways+=process1(x, y, i-2, j-1, rest-1);
        ways+=process1(x, y, i+2, j+1, rest-1);
        ways+=process1(x, y, i+2, j-1, rest-1);
        return ways;
    }
    public static int getAns2(int a,int b,int k){
        int[][][] dp =new int[10][9][k+1];
        dp[a][b][0]=1;
        for (int z=1;z<=k;z++){
            for (int x=0;x<10;x++){
                for (int y=0;y<9;y++){
                    int p = pick(dp,x - 1, y - 2, z - 1);
                    p+= pick(dp,x - 1, y + 2, z - 1);
                    p+= pick(dp,x + 1, y - 2, z - 1);
                    p+= pick(dp,x + 1, y + 2, z - 1);
                    p+= pick(dp,x - 2, y - 1, z - 1);
                    p+= pick(dp,x - 2, y + 1, z - 1);
                    p+= pick(dp,x + 2, y - 1, z - 1);
                    p+= pick(dp,x + 2, y + 1, z - 1);
                    dp[x][y][z]=p;
                }
            }
        }
        return dp[0][0][k];
    }
    public static int pick(int[][][]dp,int x,int y,int rest){
        if (x<0||x>9||y<0||y>8) {
            return 0;
        }
        return dp[x][y][rest];
    }

    public static void main(String[] args) {
        System.out.println(getAns1(7, 7, 10));
        System.out.println(getAns2(7, 7, 10));
    }
}