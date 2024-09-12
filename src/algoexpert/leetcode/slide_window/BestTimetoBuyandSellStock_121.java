package algoexpert.leetcode.slide_window;

import java.util.Arrays;

public class BestTimetoBuyandSellStock_121 {
    //121. Best Time to Buy and Sell Stock
    public static void main(String[] args) {
        int[] arr1 = {2,1,2,1,0,1,2};
        int res1 = maxProfit(arr1);
        System.out.println(res1);
    }

    public static int maxProfit(int[] prices) {

        int l = 0;
        int profit = 0;

        for (int r = 1; r < prices.length; r++) {
            if (prices[l] > prices[r]){
                  l = r;
            } else {
                int diff = prices[r] - prices[l];
                if (diff > profit){
                    profit = diff;
                }
            }
        }
        return profit;
    }


}
