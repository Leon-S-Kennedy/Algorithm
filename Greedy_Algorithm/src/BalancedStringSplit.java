public class BalancedStringSplit {
    public int balancedStringSplit(String s) {
        int sum=0;
        for (int i =s.length()-2; i >=0 ; i--) {
            if (isBanlance(s,i)){
                sum=1+balancedStringSplit(s.substring(0,i));
                break;
            }
        }
        return sum;
    }
    public boolean isBanlance(String s,int i){
        int l=0;
        int r=0;
        for (int j =i; j <s.length() ; j++) {
            if(s.toCharArray()[j]=='L'){
                l++;
            }
            if(s.toCharArray()[j]=='R'){
                r++;
            }
        }
        return l==r;
    }

    public static void main(String[] args) {
        String s="RLRRLLRLRL";
        System.out.println(new BalancedStringSplit().balancedStringSplit(s));
    }
}
