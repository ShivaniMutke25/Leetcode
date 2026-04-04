# Binary Subarrays with Sum - LeetCode #930

**Link:** https://leetcode.com/problems/binary-subarrays-with-sum/

## Problem Description
Given a binary array `nums` and an integer `goal`, return the number of non-empty subarrays with a sum equal to `goal`. A subarray is a contiguous part of the array.

**Example:**
- Input: nums = [1,0,1,0,1], goal = 2
- Output: 4
- Explanation: The 4 subarrays are bolded and underlined below:
  - [1,0,1,0,1]
  - [1,0,1,0,1]
  - [1,0,1,0,1]
  - [1,0,1,0,1]

**Constraints:**
- 1 <= nums.length <= 3 * 10^4
- nums[i] is either 0 or 1.
- 0 <= goal <= nums.length

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n²) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Prefix Sum + HashMap (Optimal) | O(n) | O(n) | Always - optimal solution | Memory constraints tight |
| 3 | Sliding Window (for goal > 0) | O(n) | O(1) | Goal > 0, memory critical | Goal = 0 |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Prefix Sum + HashMap**
**Why:** This is the optimal O(n) solution that works for all cases including goal = 0, demonstrating understanding of prefix sum patterns.

**Interview Logic:**
1. "I'll use prefix sum with HashMap to count subarrays with sum = goal"
2. "I'll maintain a running prefix sum as I iterate through the array"
3. "For each prefix sum, I'll check if (prefixSum - goal) exists in the map"
4. "If it exists, I add its frequency to the result"
5. "I'll update the map with current prefix sum frequency"
6. "This gives us O(n) time with O(n) space"

### Alternative Approaches to Mention:
- **Sliding Window:** "If goal > 0, we could use sliding window with O(1) space"
- **Brute Force:** "The naive approach would check all subarrays, but that's O(n²)"

### Follow-up Questions to Prepare:
- "Why HashMap instead of array?" → Prefix sums can be larger than array bounds
- "What if goal = 0?" → Sliding window won't work, need prefix sum approach
- "Can we optimize space?" → Use sliding window if goal > 0, otherwise O(n) is optimal

## Key Insights
- Prefix sum allows O(1) subarray sum calculation
- HashMap tracks frequency of prefix sums seen so far
- Subarray sum = prefixSum[j] - prefixSum[i]
- Count pairs where difference equals goal

## Approach Details

### 1. Brute Force
Check all possible subarrays for sum equal to goal.

### 2. Prefix Sum + HashMap (Optimal)
Use prefix sum with frequency counting to find subarrays with target sum.

### 3. Sliding Window (for goal > 0)
Use sliding window when goal > 0 for O(1) space solution.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
