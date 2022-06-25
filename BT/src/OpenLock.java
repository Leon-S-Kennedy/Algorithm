import java.util.*;

public class OpenLock {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        Set<String> dead=new HashSet<>();
        dead.addAll(Arrays.asList(deadends));
        if(dead.contains("0000")){
            return -1;
        }
        queue.offer("0000");
        visited.add("0000");
        int step=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();

                if(cur.equals(target)){
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String upstr=up(cur,j);
                    String downstr=down(cur,j);
                    if((!visited.contains(upstr))&&(!dead.contains(upstr))){
                        queue.offer(upstr);
                        visited.add(upstr);
                    }
                    if((!visited.contains(downstr))&&(!dead.contains(downstr))){
                        queue.offer(downstr);
                        visited.add(downstr);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String down(String cur, int j) {
        char[] chars = cur.toCharArray();
        if(chars[j]=='9'){
            chars[j]='0';
        }else{
            chars[j]+=1;
        }
        return new String(chars);
    }

    private String up(String cur, int j) {
        char[] chars = cur.toCharArray();
        if(chars[j]=='0'){
            chars[j]='9';
        }else{
            chars[j]-=1;
        }
        return new String(chars);
    }

}
