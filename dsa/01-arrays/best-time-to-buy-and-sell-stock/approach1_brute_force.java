/**
 * Brute Force Approach - Best Time to Buy and Sell Stock
 * 
 * Logic:
 * - For each price, check all future prices
 * - Calculate profit from selling at each future price
 * - Track maximum profit
 * 
 * When to use: Educational purposes, small inputs only
 * When NOT to use: Performance matters, large inputs (>1000)
 * 
 * Time Complexity: O(n²) - nested loops
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        // Try each day as buy day
        for (int i = 0; i < prices.length; i++) {
            // Try each future day as sell day
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        
        return maxProfit;
    }
}

/*
Example Walkthrough:
prices = [7,1,5,3,6,4]

Buy at index 0 (7):
  - Sell at 1(1): profit = 1-7 = -6
  - Sell at 2(5): profit = 5-7 = -2
  - Sell at 3(3): profit = 3-7 = -4
  - Sell at 4(6): profit = 6-7 = -1
  - Sell at 5(4): profit = 4-7 = -3

Buy at index 1 (1):
  - Sell at 2(5): profit = 5-1 = 4 ✓
  - Sell at 3(3): profit = 3-1 = 2
  - Sell at 4(6): profit = 6-1 = 5 ✓ (BEST)
  - Sell at 5(4): profit = 4-1 = 3

Buy at index 2 (5):
  - Sell at 3(3): profit = 3-5 = -2
  - Sell at 4(6): profit = 6-5 = 1
  - Sell at 5(4): profit = 4-5 = -1

... (remaining combinations would be worse)

Result: maxProfit = 5
*/