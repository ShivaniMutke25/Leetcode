/**
 * One Pass Approach - Best Time to Buy and Sell Stock (OPTIMAL)
 * 
 * Logic:
 * - Track the minimum price seen so far (best buy opportunity)
 * - At each price, calculate profit if we sell at current price
 * - Update global maximum profit
 * 
 * Key insight: We only need to remember the minimum, not all past prices
 * 
 * When to use: Always - optimal for all cases
 * When NOT to use: Never, this is the best solution
 * 
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            // Calculate profit if we sell at current price
            int profit = price - minPrice;
            
            // Update maximum profit
            maxProfit = Math.max(maxProfit, profit);
            
            // Update minimum price seen so far
            minPrice = Math.min(minPrice, price);
        }
        
        return maxProfit;
    }
}

/*
Example Walkthrough:
prices = [7,1,5,3,6,4]

price=7:
  - profit = 7 - MAX_VALUE = negative
  - maxProfit = 0
  - minPrice = 7

price=1:
  - profit = 1 - 7 = -6
  - maxProfit = 0
  - minPrice = 1

price=5:
  - profit = 5 - 1 = 4
  - maxProfit = 4
  - minPrice = 1 (unchanged)

price=3:
  - profit = 3 - 1 = 2
  - maxProfit = 4 (unchanged)
  - minPrice = 1 (unchanged)

price=6:
  - profit = 6 - 1 = 5
  - maxProfit = 5 ⭐
  - minPrice = 1 (unchanged)

price=4:
  - profit = 4 - 1 = 3
  - maxProfit = 5 (unchanged)
  - minPrice = 1 (unchanged)

Result: maxProfit = 5

Efficiency: Single pass, constant space - this is optimal!
*/