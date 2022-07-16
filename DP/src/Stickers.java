import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Stickers {
    //此题无法用填表的方法来动态规划，用傻缓存就行了
    //因为可变的参数是字符串，是无穷的（不像整数）

    public static int getAns1(String[] stickers, String target) {
        int ans=process1(stickers,target);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public static int process1(String[] stickers, String target){
        if(target.length()==0){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        for (String s : stickers) {
            String rest=minus(target,s);
            if(rest.length()!=target.length()){         //说明此时的贴纸可以产生效果
                min=Math.min(min,process1(stickers,rest));
            }
        }
        return min+(min==Integer.MAX_VALUE?0:1);
    }
    private static String minus(String target, String s) {
        char[] c1=target.toCharArray();
        char[] c2=s.toCharArray();
        int[] count=new int[26];
        for (char c : c1) {
            count[c-'a']++;     //统计各个字母在target 中出现的频率
        }
        for (char c : c2) {
            count[c-'a']--;     //每出现一个字符就抵消一个
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<26;i++){
            if(count[i]>0){     //指对应字母还存在元素
                for (int j = 0; j < count[i]; j++) {
                    sb.append((char) (i+'a'));      //将剩下的字母按顺序输出
                }
            }
        }
        return sb.toString();
    }
    public static int process2(int[][] stickers,String target){
        //stickers是一个二维数组，每一列表示一个stickers的词频表
        if(target.length()==0){
            return 0;
        }
        char[] tar=target.toCharArray();
        int[] count=new int[26];
        for (char c:tar){
            count[c-'a']++;
        }
        int N=stickers.length;
        int min=Integer.MAX_VALUE;
        for (int i=0;i<N;i++){
            int[] sticker = stickers[i];
            if(sticker[tar[0]-'a']>0){//表示选取的贴纸 一定是含有target第一个字母的贴纸(剪枝，相当于知识换个位置这种方法并不影响最后的结果)
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<26;j++){
                    if(count[j]>0){
                        int num = count[j] - sticker[j];    //此步是进行相减，遍历每个字母，将用该贴纸之后还需要的结果表示出来。
                        for (int k = 0; k < num; k++) {
                            sb.append((char)(j+'a') );
                        }
                    }
                }
                String rest= sb.toString();
                min=Math.min(min,process2(stickers,rest));
            }
        }
        return min+(min==Integer.MAX_VALUE?0:1);
    }
    public static int process3(int[][] stickers, String target, HashMap<String,Integer> dp){
        if(dp.containsKey(target)){     //如果剩余字符串出现在map中，我们直接返回map中的值
            return dp.get(target);
        }
        //stickers是一个二维数组，每一列表示一个stickers的词频表
        if(target.length()==0){
            return 0;
        }
        char[] tar=target.toCharArray();
        int[] count=new int[26];
        for (char c:tar){
            count[c-'a']++;
        }
        int N=stickers.length;
        int min=Integer.MAX_VALUE;
        for (int i=0;i<N;i++){
            int[] sticker = stickers[i];
            if(sticker[tar[0]-'a']>0){//表示选取的贴纸 一定是含有target第一个字母的贴纸(剪枝，相当于知识换个位置这种方法并不影响最后的结果)
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<26;j++){
                    if(count[j]>0){
                        int num = count[j] - sticker[j];    //此步是进行相减，遍历每个字母，将用该贴纸之后还需要的结果表示出来。
                        for (int k = 0; k < num; k++) {
                            sb.append((char)(j+'a') );
                        }
                    }
                }
                String rest= sb.toString();
                min=Math.min(min,process3(stickers,rest,dp));
            }
        }

        int ans= min+(min==Integer.MAX_VALUE?0:1);  //将结果记录到map中
        dp.put(target,ans);
        return ans;
    }

}
