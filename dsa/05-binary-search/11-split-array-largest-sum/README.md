# Split Array Largest Sum - LeetCode #410

**Link:** https://leetcode.com/problems/split-array-largest-sum/

## Problem Description
Given an integer array `nums` and an integer `k`, split the array into `k` non-empty subarrays. Write an algorithm to minimize the largest sum among these `k` subarrays.

**Example:**
- Input: nums = [7,2,5,10,8], k = 2
- Output: 18
- Explanation: Split into [7,2,5] and [10,8]. Largest sum is 18.

**Constraints:**
- 1 <= nums.length <= 10^4
- 1 <= k <= nums.length
- 1 <= nums[i] <= 10^6

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n^k) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Binary Search + Prefix Sum (Optimal) | O(n log n) | O(n) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Binary Search + Prefix Sum**
**Why:** This is optimal O(n log n) solution that finds minimum largest sum using binary search.

**Interview Logic:**
1. "I'll use binary search on possible largest sums"
2. "For each candidate sum, I'll check if we can split into k subarrays"
3. "If possible, I'll try smaller sums"
4. "If not possible, I'll try larger sums"
5. "This gives us O(n log n) time with O(n) space"

### Alternative Approaches to Mention:
- **Brute Force:** "The naive approach would try all possible splits, but that's O(n^k)"
- **DP Approach:** "We could use dynamic programming, but binary search is more efficient"

### Follow-up Questions to Prepare:
- "Why binary search?" → O(n log n) vs O(n^k) brute force
- "What if k equals array length?" → Largest sum is max(nums)
- "Can we optimize further?" → No, O(n log n) is optimal for this problem
- "What about edge cases?" → Single element, k = 1

## Key Insights
- Binary search on answer space (possible largest sums)
- Need helper function to check if split is possible
- Prefix sum array enables O(1) subarray sum calculation
- Time complexity is O(n log max) - log max for binary search, n for feasibility check
- Space complexity is O(n) for prefix sum array

## Approach Details

### 1. Brute Force
Try all possible ways to split array into k subarrays and find minimum largest sum.

### 2. Binary Search + Prefix Sum (Optimal)
Use binary search on sum range with prefix sum array for efficient subarray sum calculation.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
