import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetImportance {
    public int getImportance(List<Employee> employees, int id) {
        //此题没有告诉我们id是否连续的，所以我们需要一个map来存放这个信息
        if(employees.isEmpty()){
            return 0;
        }
        HashMap<Integer,Employee> map=new HashMap<>();
        for(Employee e:employees){
            map.put(e.id,e);
        }
        return dfs(map,id);
    }
    public int dfs(HashMap<Integer,Employee> map ,int id){
        Employee e=map.get(id);
        int res=e.importance;
        for(int subid:e.subordinates){
            res+=dfs(map,subid);
        }
        return res;
    }
}
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
}
