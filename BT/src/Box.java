public class Box {
    public static void dfs(int[] boxs,int [] books,int index,int n){
        if(index==n+1){
            for (int i = 1; i <=n ; i++) {
                System.out.print(boxs[i]+" ");
            }
            System.out.println();
            return ;
        }
        for (int i = 1; i <=n; i++) {
            if(books[i]==0){
                boxs[index]=i;
                books[i]=1;
                dfs(boxs, books, index+1, n);
                books[i]=0;
            }
        }
    }

    public static void main(String[] args) {
        int[] boxs=new int[4];
        int[] books=new int[4];
        dfs(boxs,books,1,3);
    }
}
