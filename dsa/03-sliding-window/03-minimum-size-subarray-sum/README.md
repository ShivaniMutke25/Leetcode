# Minimum Size Subarray Sum - LeetCode #209

**Link:** https://leetcode.com/problems/minimum-size-subarray-sum/

## Problem Description
Given an array of positive integers `nums` and a positive integer `target`, return the minimal length of a subarray of which the sum is greater than or equal to `target`. If there is no such subarray, return `0`.

**Example:**
- Input: nums = [2,3,1,2,4,3], target = 7
- Output: 2
- Explanation: The subarray [4,3] has the minimal length of 2 under the problem's constraint.

**Constraints:**
- 1 <= target <= 10^9
- 1 <= nums.length <= 10^5
- 1 <= nums[i] <= 10^4

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n²) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Sliding Window (Optimal) | O(n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Sliding Window**
**Why:** This is the optimal O(n) solution that demonstrates understanding of sliding window with positive integers.

**Interview Logic:**
1. "I'll use a sliding window with two pointers: left and right"
2. "I'll maintain the sum of the current window"
3. "I'll expand the window by moving right pointer until sum >= target"
4. "Then I'll contract the window from the left to find the minimum size"
5. "I'll track the minimum window size found"
6. "This gives us O(n) time with O(1) space"

### Alternative Approaches to Mention:
- **Brute Force:** "The naive approach would check all subarrays, but that's O(n²)"
- **Prefix Sum + Binary Search:** "We could use prefix sum with binary search, but sliding window is simpler"

### Follow-up Questions to Prepare:
- "Why does sliding window work here?" → All numbers are positive, so expanding increases sum
- "What if numbers can be negative?" → Sliding window won't work, need different approach
- "Can we optimize further?" → No, O(n) is optimal since we need to examine each element

## Key Insights
- All numbers are positive, so expanding window always increases sum
- Once sum >= target, we can try to shrink window to find minimum size
- Sliding window allows O(1) sum updates when sliding

## Approach Details

### 1. Brute Force
Check all possible subarrays for sum >= target.

### 2. Sliding Window (Optimal)
Use sliding window to find minimum size subarray with sum >= target.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
