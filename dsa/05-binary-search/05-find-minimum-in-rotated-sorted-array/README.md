# Find Minimum in Rotated Sorted Array - LeetCode #153

**Link:** https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

## Problem Description
Given an array `nums` sorted in ascending order, and then rotated at an unknown pivot index. Find the minimum element in the array.

**Example:**
- Input: nums = [3,4,5,1,2]
- Output: 1
- Input: nums = [4,5,6,7,0,1,2]
- Output: 0

**Constraints:**
- 1 <= nums.length <= 5000
- -10^4 <= nums[i] <= 10^4
- All values are unique.
- nums is a rotated sorted array.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Linear Search | O(n) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Modified Binary Search (Optimal) | O(log n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Modified Binary Search**
**Why:** This is optimal O(log n) solution that finds minimum efficiently.

**Interview Logic:**
1. "I'll use modified binary search with left and right pointers"
2. "I'll compare mid with right element"
3. "If nums[mid] > nums[right], minimum is on right"
4. "If nums[mid] <= nums[right], minimum is on left"
5. "When left == right, we found minimum"
6. "This gives us O(log n) time with O(1) space"

### Alternative Approaches to Mention:
- **Linear Search:** "The naive approach would scan all elements, but that's O(n)"
- **Find Rotation Point:** "We could find rotation point, then return next element"

### Follow-up Questions to Prepare:
- "Why modified binary search?" → O(log n) vs O(n) linear search
- "What if array is not rotated?" → Minimum is first element
- "Can we optimize further?" → No, O(log n) is optimal for this problem
- "What about edge cases?" → Single element, no rotation

## Key Insights
- Rotated array has one sorted half and one unsorted half
- Compare mid with right element to determine search direction
- Time complexity is logarithmic: O(log n)
- Space complexity is constant: O(1)
- Need to handle non-rotated case

## Approach Details

### 1. Linear Search
Scan through array to find minimum element.

### 2. Modified Binary Search (Optimal)
Adapt binary search to find minimum element in rotated array.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
