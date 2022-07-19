import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public static boolean wordBreak(String s, Set<String> dict){
        if(s.length()==0){
            return true;
        }
        for (int i=1;i<=s.length();i++){
            if(dict.contains(s.substring(0,i))){
                if(wordBreak(s.substring(i),dict)){
                    return true;
                }
            }
        }
        return false;
    }
    HashMap<String,Boolean> dp=new HashMap<>();
    public static boolean wordBreak2(String s, Set<String>dict, HashMap<String,Boolean> dp){
        if(dp.containsKey(s)){
            return dp.get(s);
        }
        if(s.length()==0){
            dp.put(s,true);
            return true;
        }
        for (int i=1;i<=s.length();i++){
            if(dict.contains(s.substring(0,i))){
                if(wordBreak2(s.substring(i),dict,dp)){
                     dp.put(s,true);
                     return true;
                }
            }
        }
        dp.put(s,false);
        return false;
    }

    public static void main(String[] args) {
        String s="nowcodeis";
        Set<String> dict=new HashSet<>();
        dict.add("now");
        dict.add("code");
        dict.add("is");
        System.out.println(wordBreak(s,dict));
    }
}
