import java.util.*;

public class CombinationSum {
    List<List<Integer>> res=new ArrayList<>();
    Deque<Integer> path=new ArrayDeque<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null){
            return null;
        }
        Arrays.sort(candidates);
        backTracing(candidates,target,0);
        return res;
    }
    public void backTracing(int[] candidates,int target,int startindex){
        if(sum(path)==target){
            res.add(new ArrayList<>(path));
            return;
        }
        if(sum(path)>target){
            return;
        }
        for (int i = startindex; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            backTracing(Arrays.copyOfRange(candidates,i,candidates.length), target,startindex);
            path.removeLast();
        }
    }

    private int sum(Deque<Integer> path) {
        int sum=0;
        for (Integer integer : path) {
            sum+=integer;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] candidates=new int[]{2,3,6,7};
        int target=7;
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> list = combinationSum.combinationSum(candidates, target);
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
