# Maximum Subarray - LeetCode #53

**Link:** https://leetcode.com/problems/maximum-subarray/

## Problem Description
Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

**Example:**
- Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
- Output: 6
- Explanation: The subarray [4,-1,2,1] has the largest sum = 6

**Constraints:**
- 1 <= nums.length <= 10^5
- -10^4 <= nums[i] <= 10^4

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n²) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Kadane's Algorithm (Optimal) | O(n) | O(1) | Always - optimal solution | Never |
| 3 | Divide and Conquer | O(n log n) | O(log n) | Academic purposes | Practical implementation |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Kadane's Algorithm**
**Why:** This is the optimal O(n) time and O(1) space solution that demonstrates understanding of dynamic programming principles.

**Interview Logic:**
1. "I'll use Kadane's algorithm with currentSum and maxSum variables"
2. "For each element, currentSum is max(element, currentSum + element)"
3. "This means either start new subarray or extend existing one"
4. "I update maxSum with the best currentSum found"
5. "This gives us O(n) time with O(1) space"

### Alternative Approaches to Mention:
- **Divide and Conquer:** "We could use divide and conquer, but it's more complex at O(n log n)"
- **Brute Force:** "The naive approach would check all subarrays, but that's O(n²)"
- **Prefix Sum + Min Prefix:** "We could use prefix sums, but Kadane's is simpler"

### Follow-up Questions to Prepare:
- "Why do we reset when currentSum becomes negative?" → Negative prefix can't help future subarrays
- "What if all numbers are negative?" → Return the largest (least negative) number
- "Can we find the actual subarray?" → Keep track of start and end indices

## Key Insights
- Maximum subarray ending at position i either includes nums[i] or starts fresh at i
- If current sum becomes negative, it's better to start new subarray
- Kadane's algorithm maintains both current and global maximums

## Approach Details

### 1. Brute Force
Check all possible subarrays and calculate their sums.

### 2. Kadane's Algorithm (Optimal)
Maintain current sum and global maximum, resetting when sum becomes negative.

### 3. Divide and Conquer
Recursively divide array and combine results from left, right, and crossing subarrays.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
