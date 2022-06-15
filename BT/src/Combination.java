import java.util.*;

public class Combination {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        Deque<Integer> path=new LinkedList<>();

        if(k<=0||k>n){
            return null;
        }
        backtracing(n,k,1,result,path);
        return result;
    }
    public void backtracing(int n,int k,int startindex,List<List<Integer>> result,Deque<Integer> path){
        if(path.size()==k){
            result.add(new ArrayList<>(path));  //此处建议使用双端队列，不过用栈也可以实现
            return;
        }

        for (int i = startindex;n-i+1>=k-path.size() ; i++) {   //此处的限制条件是    剩下元素的个数>=还需要的元素个数（剪枝操作）
            path.push(i);
            backtracing(n, k, i+1,result,path);
            path.pop();
        }
    }
}
