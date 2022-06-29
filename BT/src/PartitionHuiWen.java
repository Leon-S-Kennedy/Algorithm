import java.util.*;

public class PartitionHuiWen {
    List<List<String>> res=new ArrayList<>();
    Deque<String> path=new ArrayDeque<>();
    public List<List<String>> partition(String s) {
        if(s==null||s.length()==0){
            return null;
        }
        backtracing(s.toCharArray(),0);
        return res;
    }
    public void backtracing(char[] c,int startindex){
        if(startindex>c.length-1){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startindex; i <c.length ; i++) {
             if(isHuiwen(c,startindex,i)){
                 path.addLast(String.valueOf(Arrays.copyOfRange(c,startindex,i+1)));
                 backtracing(c,i+1);
                 path.removeLast();
             }
        }
    }

    private boolean isHuiwen(char[] c, int startindex, int i) {
        for (;startindex<=i;startindex++,i--) {
            if(c[startindex]!=c[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PartitionHuiWen partitionHuiWen = new PartitionHuiWen();
        String s="aa";
        for (List<String> strings : partitionHuiWen.partition(s)) {
            for (String string : strings) {
                System.out.print(string+" ");
            }
            System.out.println();
        }
    }
}
