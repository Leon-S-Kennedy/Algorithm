import java.util.Arrays;

public class CanJump {
    public boolean canJump(int[] nums) {
        int maxjumpindex=nums[0];
        for (int i = 0; i <=maxjumpindex&&i< nums.length; i++) {    //这个就利用了改变循环终止条件的手段，使用该方法时需要小心
            int cur=i+nums[i];
            if(cur>=maxjumpindex){
                maxjumpindex=cur;
            }
        }
        return nums.length-1<=maxjumpindex;
    }

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        System.out.println(canJump.canJump(new int[]{1,2,3}));
    }
}
