public class Jump {
    public int jump(int[] nums) {
        int cur=0;
        int sum=0;
        while (cur<nums.length-1){
            if(cur+nums[cur]>= nums.length-1){
                return sum+1;
            }
            int max=0;
            int maxindex=0;
            for (int i = cur; i <=cur+nums[cur]&&i<= nums.length-1 ; i++) {
                if(i+nums[i]>=max){
                    max=i+nums[i];
                    maxindex=i;
                }
            }
            cur=maxindex;
            sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int jump = new Jump().jump(new int[]{2,3,1});
        System.out.println(jump);
    }
}
