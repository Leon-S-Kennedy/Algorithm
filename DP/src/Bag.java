public class Bag {

    public static int maxValue1(int[] w,int[] v,int bag){
        return pocess1(w,v,0,bag);
    }
    private static int pocess1(int[] w, int[] v, int i, int bag) {
        if(bag<0){
            return -1;
        }
        if(i== w.length){
            return 0;
        }
        int p1=pocess1(w,v,i+1,bag);
        int p2=0;
        if(bag>=w[i]){
            p2=v[i]+pocess1(w,v,i+1,bag-w[i]);
        }
        return Math.max(p1,p2);
    }


    public static int maxValue2(int[] w,int[] v,int bag){
        int[][] map=new int[w.length+1][bag+1];
        for (int i = 0; i < w.length+1; i++) {
            for (int j = 0; j < bag+1; j++) {
                map[i][j]=-2;
            }
        }
        return pocess2(w,v,0,bag,map);
    }

    private static int pocess2(int[] w, int[] v, int i, int bag,int[][] map) {
        if(map[i][bag]!=-2){
            return map[i][bag];
        }else{
            int ans=0;
            if(bag<0){
                ans=-1;
                map[i][bag]=ans;
                return ans;
            }
            if(i==w.length){
                ans=0;
                map[i][bag]=ans;
                return ans;
            }
            int p1=pocess2(w,v,i+1,bag,map);

            int p2=0;
            if(bag>=w[i]){
                p2=v[i]+pocess2(w,v,i+1,bag-w[i],map);
            }
            ans=Math.max(p1,p2);
            map[i][bag]=ans;
            return ans;
        }
    }
    public static int maxValue3(int[] w,int[] v,int bag){
        //顺便就给初始值了
        int[][] map=new int[w.length+1][bag+1];

        for (int row=w.length-1;row>=0;row--){
            for (int col = 0; col <=bag ; col++) {
                //状态转移方程
                int p1=map[row+1][col];
                int p2=0;
                if(col>=w[row]){
                    p2=v[row]+map[row+1][col-w[row]];
                }
                map[row][col]=Math.max(p1,p2);

            }
        }
        //返回最终结果
        return map[0][bag];
    }

    public static void main(String[] args) {
        int[] w=new int[]{1,2,3,4};
        int[] v=new int[]{2,3,4,4};
        System.out.println(maxValue1(w, v, 5));
        System.out.println(maxValue2(w, v, 5));
        System.out.println(maxValue3(w, v, 5));

    }
}
