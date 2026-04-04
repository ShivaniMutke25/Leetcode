# Maximum Average Subarray - LeetCode #643

**Link:** https://leetcode.com/problems/maximum-average-subarray/

## Problem Description
Given an integer array `nums` and an integer `k`, find the contiguous subarray of length `k` that has the maximum average value. Return the value of the maximum average subarray.

**Example:**
- Input: nums = [1,12,-5,-6,50,3], k = 4
- Output: 12.75
- Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75

**Constraints:**
- 1 <= k <= nums.length <= 10^5
- -10^4 <= nums[i] <= 10^4

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(nk) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Prefix Sum (Optimal) | O(n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Prefix Sum**
**Why:** This is the optimal O(n) solution that demonstrates understanding of sliding window with prefix sums.

**Interview Logic:**
1. "I'll use a sliding window of size k with prefix sum optimization"
2. "I'll compute the sum of the first k elements"
3. "Then slide the window one element at a time, updating the sum"
4. "I'll keep track of the maximum sum seen"
5. "Finally, I'll return maxSum/k for the maximum average"
6. "This gives us O(n) time with O(1) space"

### Alternative Approaches to Mention:
- **Brute Force:** "The naive approach would compute sum for every subarray of size k, but that's O(nk)"
- **Kadane's-like Approach:** "We could adapt Kadane's algorithm, but prefix sum is simpler for fixed window size"

### Follow-up Questions to Prepare:
- "Why prefix sum over sliding window?" → Both are O(n), but prefix sum is more intuitive for fixed size
- "Can we optimize further?" → No, O(n) is optimal since we need to examine each element
- "What if k = nums.length?" → Just return average of entire array

## Key Insights
- Fixed window size k makes this a classic sliding window problem
- Prefix sum allows O(1) window updates
- Maximum average corresponds to maximum sum for fixed window size

## Approach Details

### 1. Brute Force
Compute sum for every possible subarray of length k.

### 2. Prefix Sum (Optimal)
Use sliding window with prefix sum for efficient sum updates.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
