# Remove Duplicates from Sorted Array II - LeetCode #80

**Link:** https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

## Problem Description
Given an integer array `nums` sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order should be kept the same.

Return `k` after placing the final result in the first `k` slots of `nums`.

**Example:**
- Input: nums = [1,1,1,2,2,3]
- Output: 5, nums = [1,1,2,2,3]
- Explanation: Your function returns length = 5, with the first five elements of nums being 1, 1, 2, 2, and 3 respectively.

**Constraints:**
- 1 <= nums.length <= 3 * 10^4
- -10^4 <= nums[i] <= 10^4
- nums is sorted in non-decreasing order.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n²) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Two Pointers (Optimal) | O(n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Two Pointers**
**Why:** This is the optimal O(n) solution that uses same-direction pointers to filter duplicates.

**Interview Logic:**
1. "I'll use two pointers: slow for building result, fast for scanning"
2. "Fast pointer scans all elements"
3. "Slow pointer only advances when we can keep the element"
4. "I'll allow at most 2 occurrences of each number"
5. "This gives us O(n) time with O(1) space"

### Alternative Approaches to Mention:
- **Brute Force:** "We could create new array, but that violates space constraint"
- **Counting:** "We could count occurrences first, but two pointers is more efficient"

### Follow-up Questions to Prepare:
- "Why two pointers?" → One to scan, one to build filtered result in-place
- "What about the count condition?" → We check if slow < 2 or current != nums[slow-2]
- "Can we optimize further?" → No, O(n) is optimal since we need to examine each element

## Key Insights
- Two pointers can filter array in-place with count constraints
- Fast pointer does scanning, slow pointer builds result
- Need to track count of each element to enforce "at most twice" rule
- Each element is examined exactly once

## Approach Details

### 1. Brute Force
Create new array with at most 2 occurrences of each element.

### 2. Two Pointers (Optimal)
Use slow-fast pointers to filter duplicates in-place with count constraint.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
