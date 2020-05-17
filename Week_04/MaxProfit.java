package Week_04;

//题目：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
public class MaxProfit {


    /***
     * 
     * 1.“最好” 的意思往往根据题目而来，可能是 “最小”，也可能是 “最大”；
       2.贪心算法和动态规划相比，它既不看前面（也就是说它不需要从前面的状态转移过来），也不看后面（无后效性，后面的选择不会对前面的选择有影响），因此贪心算法时间复杂度一般是线性的，空间复杂度是常数级别的。
       3.这道题 “贪心” 的地方在于，对于 “今天的股价 - 昨天的股价”，得到的结果有 3 种可能：（1）正数（2）0（3）负数。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        int len = prices.length;
        for (int i = 0; i < len - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            if (diff > 0) {
                res += diff;
            }
        }
        return res;
    }
    
}