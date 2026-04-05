class Solution {
    //bruteforce
    /** 
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(profit, maxProfit);
            }
        }
        return maxProfit;
    }
    */
    //one pass
    public int maxProfit(int[] prices) {
        int minPrice= Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price : prices){
            maxProfit = Math.max(price-minPrice,maxProfit);
            minPrice=Math.min(minPrice,price);
        }
        return maxProfit;
    }
}
