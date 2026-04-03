# Best Time to Buy and Sell Stock - LeetCode #121

**Link:** https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

## Problem Description
Given an array `prices` where `prices[i]` is the price on day i, maximize profit from buying on one day and selling on a later day. You cannot sell before you buy.

**Example:**
- Input: prices = [7,1,5,3,6,4]
- Output: 5
- Explanation: Buy at 1, sell at 6, profit = 6-1 = 5

**Constraints:**
- 1 <= prices.length <= 10^5
- 0 <= prices[i] <= 10^4

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n²) | O(1) | Learning, guaranteed small input | Standard interviews, larger inputs |
| 2 | One Pass (Optimal) | O(n) | O(1) | All situations - optimal and simple | N/A |

## 🎯 Interview Strategy

### Most Appropriate Approach: **One Pass**
**Why:** This is the optimal solution that demonstrates understanding of the problem's key insight - we only need to track the minimum price seen so far.

**Interview Logic:**
1. "I'll maintain two variables: minPrice and maxProfit"
2. "As I iterate through prices, I calculate potential profit: currentPrice - minPrice"
3. "I update maxProfit if this profit is better"
4. "I also update minPrice if currentPrice is lower"
5. "This gives us O(n) time with O(1) space"

### Alternative Approaches to Mention:
- **Brute Force:** "The naive approach would check every buy-sell pair, but that's O(n²)"
- **Kadane's variation:** "We could also solve this by finding maximum subarray on price differences"

### Follow-up Questions to Prepare:
- "What if we can make multiple transactions?" → Different problem (LeetCode #122)
- "What if we need to track the actual days?" → Keep track of indices when updating maxProfit
- "What if there's a transaction fee?" → Adjust profit calculation

## Key Insights
- Track minimum price seen so far
- At each price, calculate max profit with current price as sell
- Update global maximum

## Approach Details

### 1. Brute Force
Check every possible buy-sell pair to find maximum profit.

### 2. One Pass (Optimal)
Track minimum price and calculate profit at each step.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*