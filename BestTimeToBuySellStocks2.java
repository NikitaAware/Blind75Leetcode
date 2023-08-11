// Medium
// 12K
// 2.6K
// Companies
// You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

// On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

// Find and return the maximum profit you can achieve.


//other solution is the direct solution with just a for loop
// class Solution {
//     public int maxProfit(int[] prices) {
//         int res = 0;
//         for (int i = 1; i < prices.length; i++) {
//             if (prices[i] > prices[i - 1]) {
//                 res = res + (prices[i] - prices[i - 1]);
//             }
//         }
//         return res;
//     }
// }
import java.util.HashMap;

public class BestTimeToBuySellStocks2 {
    int[] prices;
    int res;
    HashMap<String, Integer> vis;

    BestTimeToBuySellStocks2(int[] prices) {
        this.prices = prices;
        this.res = Integer.MIN_VALUE;
        this.vis = new HashMap<String, Integer>();
    }

    public int maxProfitHelper(int curr, int prev, int profit) {
        if (curr >= prices.length) {
            res = Math.max(res, profit);
            return profit;
        }
        String key = prev + ":" + curr;
        if (vis.containsKey(key)) {
            System.out.println(key);
            int tot = profit + vis.get(key);
            res = Math.max(res, tot);
            return tot;
        }
        int totProfit = Integer.MIN_VALUE;
        // no stock is on hold
        if (prev == -1) {
            // either buy or skip
            int p1 = maxProfitHelper(curr + 1, curr, profit);
            vis.put((curr) + ":" + (curr + 1), p1 - profit);
            int p2 = maxProfitHelper(curr + 1, prev, profit);
            vis.put((prev) + ":" + (curr + 1), p2 - profit);
            totProfit = Math.max(p1, p2);
        } else {
            // if you have a stock on hold
            // sell only when the price is greater
            if (prices[prev] < prices[curr]) {
                int p1 = maxProfitHelper(curr, -1, profit + (prices[curr] - prices[prev]));
                vis.put("-1:" + curr, p1 - (profit + (prices[curr] - prices[prev])));
                totProfit = p1;
            }
            // don't sell
            int p2 = maxProfitHelper(curr + 1, prev, profit);
            vis.put(prev + ":" + (curr + 1), p2 - profit);
            totProfit = Math.max(totProfit, p2);
        }
        res = Math.max(totProfit, res);
        vis.put(key, totProfit - profit);
        return totProfit;
    }

    public int maxProfit() {
        maxProfitHelper(0, -1, 0);
        return res;
    }
}
