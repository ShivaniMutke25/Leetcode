# Subarray Sum Equals K - LeetCode #560

**Link:** https://leetcode.com/problems/subarray-sum-equals-k/

## Problem Description
Given an array of integers `nums` and an integer `k`, return the total number of continuous subarrays whose sum equals to `k`.

**Example:**
- Input: nums = [1,1,1], k = 2
- Output: 2
- Explanation: Subarrays [1,1] at positions (0,1) and (1,2) sum to 2

**Constraints:**
- 1 <= nums.length <= 2 * 10^4
- -1000 <= nums[i] <= 1000
- -10^7 <= k <= 10^7

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n²) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Prefix Sum + HashMap (Optimal) | O(n) | O(n) | Always - optimal solution | Memory constraints tight |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Prefix Sum + HashMap**
**Why:** This is the optimal O(n) solution that demonstrates understanding of prefix sums and hash-based lookups.

**Interview Logic:**
1. "I'll use prefix sums: prefix[i] = sum of nums[0..i]"
2. "For each prefix[j], I need prefix[i-1] = prefix[j] - k for a valid subarray"
3. "I'll store prefix sums in HashMap with their frequencies"
4. "When I see currentSum, I check if (currentSum - k) exists in the map"
5. "This gives us O(n) time with O(n) space"

### Alternative Approaches to Mention:
- **Brute Force:** "The naive approach would check all subarrays, but that's O(n²)"
- **Sliding Window:** "This won't work because numbers can be negative"

### Follow-up Questions to Prepare:
- "Why do we initialize with {0:1}?" → Handles subarrays starting from index 0
- "What if all numbers are positive?" → We could use sliding window then
- "Can we find the actual subarrays?" → Yes, store indices in the map

## Key Insights
- Prefix sum at index i = sum of nums[0..i]
- Subarray sum from i to j = prefix[j] - prefix[i-1]
- If prefix[j] - k exists in prefix sums, we found a valid subarray

## Approach Details

### 1. Brute Force
Check all possible subarrays and calculate their sums.

### 2. Prefix Sum + HashMap (Optimal)
Use prefix sums and HashMap to find subarrays in O(n) time.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
