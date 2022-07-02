public class aaa111 {
/*
    public static int getAns(String s){
        return howMuch(s.toCharArray(),0);
    }

    private static int howMuch(char[] s, int i) {
        if(i==s.length){
            return 1;
        }
        if(i==s.length-1){
            return 1;
        }
        int t1=howMuch(s, i+1);

        int t2=0;
        if(((s[i]-'0')*10+(s[i+1]-'0'))<=26){
            t2=howMuch(s,i+2);
        }
        return t1+t2;
    }
*/

    public static int getAns1(String s){
        return process1(s.toCharArray(),0);
    }
    public static int process1(char[] s,int i){
        if(i==s.length){
            return 1;           //后续没有字符的时候，此时整体算一种方案，而不是零
        }
        if(s[i]=='0'){             //此时以零开头，说明这个方案不行，有问题，此时返回零
            return 0;
        }
        //s[i]!=0
        int p=process1(s,i+1);
        if(i+1<s.length&&((s[i]-'0')*10+(s[i+1]-'0'))<=26){
            p+=process1(s, i+2);
        }
        return p;
    }
    public static int getAns3(String s){
        char[] chars = s.toCharArray();
        int[] dp=new int[chars.length+1];
        dp[chars.length]=1;
        //为什么要从右往左呢？因为，我们发现，在递归中，每一个值都依赖于之后的值。（递归改动态规划的时候，填表的顺序很重要）
        for (int j = chars.length-1; j >=0 ; j--) {
            if(chars[j]!='0'){
                if(j+1<chars.length&&((chars[j]-'0')*10+(chars[j+1]-'0'))<=26){
                    dp[j]=dp[j+1]+dp[j+2];
                }else {
                    dp[j]=dp[j+1];
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String s="122";
        System.out.println(getAns1(s));
        System.out.println(getAns3(s));
    }
}
