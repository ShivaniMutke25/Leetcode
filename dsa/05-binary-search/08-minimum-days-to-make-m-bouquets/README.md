# Minimum Days to Make m Bouquets - LeetCode #1482

**Link:** https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

## Problem Description
You are given an integer array `bloomDay` where `bloomDay[i]` is the day the `i-th` flower blooms, and an integer `m` and `k`. You need to make `m` bouquets. To make a bouquet, you need `k` adjacent flowers from the garden.

The garden consists of `n` flowers, the `i-th` flower will bloom in the `bloomDay[i]` day. You can use each flower at most once to make a bouquet.

Return the minimum number of days you need to wait to be able to make `m` bouquets from the garden. If it is impossible to make `m` bouquets return `-1`.

**Example:**
- Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
- Output: 3

**Constraints:**
- 1 <= bloomDay.length <= 10^5
- 1 <= bloomDay[i] <= 10^9
- 1 <= m <= 10^6
- 1 <= k <= bloomDay.length

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n * max) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Binary Search (Optimal) | O(n log max) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Binary Search**
**Why:** This is optimal O(n log max) solution that finds minimum days using binary search.

**Interview Logic:**
1. "I'll use binary search on possible days"
2. "For each day, I'll check if we can make m bouquets"
3. "If possible, I'll try fewer days"
4. "If not possible, I'll try more days"
5. "This gives us O(n log max) time with O(1) space"

### Alternative Approaches to Mention:
- **Brute Force:** "The naive approach would try all days, but that's O(n * max)"
- **Sliding Window:** "We could use sliding window, but binary search is more efficient"

### Follow-up Questions to Prepare:
- "Why binary search?" → O(n log max) vs O(n * max) brute force
- "What if m*k > n?" → Impossible, return -1
- "Can we optimize further?" → No, O(n log max) is optimal for this problem
- "What about edge cases?" → Single flower, k=1

## Key Insights
- Binary search on answer space (possible days)
- Need helper function to check if m bouquets can be made
- Time complexity is O(n log max) - log max for binary search, n for feasibility check
- Space complexity is constant: O(1)
- Need to handle impossible case

## Approach Details

### 1. Brute Force
Try all possible days from min(bloomDay) to max(bloomDay).

### 2. Binary Search (Optimal)
Use binary search on day range to find minimum feasible day.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
