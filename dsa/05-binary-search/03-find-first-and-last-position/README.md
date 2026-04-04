# Find First and Last Position - LeetCode #34

**Link:** https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

## Problem Description
Given an array of integers `nums` sorted in non-decreasing order, find the starting and ending position of a given `target` value. If target is not found in the array, return `[-1, -1]`.

**Example:**
- Input: nums = [5,7,7,8,8,10], target = 8
- Output: [3,4]
- Input: nums = [5,7,7,8,8,10], target = 6
- Output: [-1,-1]

**Constraints:**
- 0 <= nums.length <= 10^5
- -10^9 <= nums[i] <= 10^9
- nums is a non-decreasing array.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Linear Search | O(n) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Two Binary Searches (Optimal) | O(log n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Two Binary Searches**
**Why:** This is optimal O(log n) solution that finds both boundaries efficiently.

**Interview Logic:**
1. "I'll use two separate binary searches"
2. "First search finds leftmost occurrence of target"
3. "Second search finds rightmost occurrence of target"
4. "If target not found, return [-1,-1]"
5. "This gives us O(log n) time with O(1) space"

### Alternative Approaches to Mention:
- **Linear Search:** "The naive approach would scan all elements, but that's O(n)"
- **Single Binary Search:** "We could find one occurrence, but need two searches for boundaries"

### Follow-up Questions to Prepare:
- "Why two binary searches?" → Need to find both left and right boundaries
- "What if array has no duplicates?" → Both searches return same position
- "Can we optimize further?" → No, O(log n) is optimal for search problems
- "What about edge cases?" → Empty array, single element, target not found

## Key Insights
- Two binary searches find leftmost and rightmost positions
- First search uses <= condition for left boundary
- Second search uses >= condition for right boundary
- Time complexity is logarithmic: O(log n)
- Space complexity is constant: O(1)
- Need to handle empty array and target not found cases

## Approach Details

### 1. Linear Search
Scan through array to find first and last occurrence of target.

### 2. Two Binary Searches (Optimal)
Use two separate binary searches to find left and right boundaries.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
