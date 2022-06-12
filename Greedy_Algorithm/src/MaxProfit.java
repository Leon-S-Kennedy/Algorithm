import java.util.Map;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int sum=0;
        for (int i = 0; i < prices.length-1; i++) {
            sum+= Math.max(0,prices[i+1]-prices[i]);
        }
        return sum;
    }
}
