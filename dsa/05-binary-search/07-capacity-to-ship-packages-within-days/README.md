# Capacity to Ship Packages Within D Days - LeetCode #1011

**Link:** https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

## Problem Description
A conveyor belt has packages that must be shipped from one port to another within `D` days. The `i-th` package on the conveyor belt has a weight of `weights[i]`. Each day, we load the ship with packages in the order given by `weights`. We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages being shipped within `D` days.

**Example:**
- Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
- Output: 15
- Explanation: Ship capacity 15.

**Constraints:**
- 1 <= D <= weights.length <= 500
- 1 <= weights[i] <= 500

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n * max) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Binary Search (Optimal) | O(n log max) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Binary Search**
**Why:** This is optimal O(n log max) solution that finds minimum capacity using binary search.

**Interview Logic:**
1. "I'll use binary search on possible ship capacities"
2. "For each capacity, I'll check if we can ship all packages in D days"
3. "If possible, I'll try smaller capacities"
4. "If not possible, I'll try larger capacities"
5. "This gives us O(n log max) time with O(1) space"

### Alternative Approaches to Mention:
- **Brute Force:** "The naive approach would try all capacities, but that's O(n * max)"
- **DP Approach:** "We could use dynamic programming, but binary search is more efficient"

### Follow-up Questions to Prepare:
- "Why binary search?" → O(n log max) vs O(n * max) brute force
- "What if D equals weights length?" → Capacity must be max(weights)
- "Can we optimize further?" → No, O(n log max) is optimal for this problem
- "What about edge cases?" → Single package, D = 1

## Key Insights
- Binary search on answer space (possible ship capacities)
- Need helper function to check if capacity is feasible
- Time complexity is O(n log max) - log max for binary search, n for feasibility check
- Space complexity is constant: O(1)
- Need to find minimum feasible capacity

## Approach Details

### 1. Brute Force
Try all possible capacities from max(weights) to sum(weights).

### 2. Binary Search (Optimal)
Use binary search on capacity range to find minimum feasible capacity.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
