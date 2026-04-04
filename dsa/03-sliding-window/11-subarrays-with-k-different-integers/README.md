# Subarrays with K Different Integers - LeetCode #992

**Link:** https://leetcode.com/problems/subarrays-with-k-different-integers/

## Problem Description
Given an integer array `nums` and an integer `k`, return the number of good subarrays of `nums`. A good subarray is a subarray where the number of distinct integers is exactly `k`.

**Example:**
- Input: nums = [1,2,1,2,3], k = 2
- Output: 7
- Explanation: Subarrays with exactly 2 distinct integers are:
  [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]

**Constraints:**
- 1 <= nums.length <= 2 * 10^4
- 1 <= nums[i] <= 10^5
- 1 <= k <= nums.length

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n²) | O(n) | Learning, tiny inputs | Any realistic input |
| 2 | Sliding Window (Optimal) | O(n) | O(k) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Sliding Window with Two Counters**
**Why:** This is the optimal O(n) solution that uses the insight: subarrays with exactly K distinct = subarrays with at most K distinct - subarrays with at most K-1 distinct.

**Interview Logic:**
1. "I'll use the formula: exactly K = at most K - at most (K-1)"
2. "I'll implement a helper function to count subarrays with at most K distinct integers"
3. "I'll use sliding window with frequency map to track distinct elements"
4. "When distinct count > K, I'll shrink the window from left"
5. "I'll count all valid subarrays ending at each position"
6. "Finally, I'll return atMostK(nums, k) - atMostK(nums, k-1)"
7. "This gives us O(n) time with O(k) space"

### Alternative Approaches to Mention:
- **Brute Force:** "The naive approach would check all subarrays, but that's O(n²)"
- **Single Window Approach:** "We could try to maintain exactly K distinct, but it's more complex"

### Follow-up Questions to Prepare:
- "Why use at most K minus at most K-1?" → Easier to count at most K than exactly K
- "What if K = 1?" → Just count subarrays with all identical elements
- "Can we optimize space further?" → No, O(k) is optimal since we need to track K distinct elements

## Key Insights
- Counting "exactly K" is harder than "at most K"
- Use inclusion-exclusion: exactly K = at most K - at most (K-1)
- Sliding window efficiently counts subarrays with at most K distinct
- Each position contributes to multiple valid subarrays

## Approach Details

### 1. Brute Force
Check all possible subarrays and count distinct integers.

### 2. Sliding Window (Optimal)
Use sliding window with frequency counting and the inclusion-exclusion principle.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
