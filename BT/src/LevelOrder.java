import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class LevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        if(root==null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> ans=new ArrayList<>();
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);


        while (!queue.isEmpty()){

            List<Integer> level = new ArrayList<>();
            int size=queue.size();
            for (int i = 0; i < size; i++) {

                Node cur= queue.poll();
                level.add(cur.val);

                for (Node child : cur.children) {
                    queue.offer(child);
                }
            }
            ans.add(level);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Node> list=new ArrayList<>();
        list.add(new Node(3,new ArrayList<>()));
        list.add(new Node(2,new ArrayList<>()));
        list.add(new Node(4,new ArrayList<>()));
        Node root = new Node(1,list);
        List<List<Integer>> list1 = new LevelOrder().levelOrder(root);
        for (List<Integer> integers : list1) {
            for (Integer integer : integers) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
