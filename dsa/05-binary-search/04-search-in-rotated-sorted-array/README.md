# Search in Rotated Sorted Array - LeetCode #33

**Link:** https://leetcode.com/problems/search-in-rotated-sorted-array/

## Problem Description
There is an integer array `nums` sorted in ascending order, and then rotated at an unknown pivot index. Given the target value, return its index if it is present in the array, otherwise return `-1`.

**Example:**
- Input: nums = [4,5,6,7,0,1,2], target = 0
- Output: 4
- Input: nums = [4,5,6,7,0,1,2], target = 3
- Output: -1

**Constraints:**
- 1 <= nums.length <= 10^4
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
**Why:** This is optimal O(log n) solution that adapts binary search to rotated array.

**Interview Logic:**
1. "I'll use modified binary search with left and right pointers"
2. "I'll check if left half is sorted"
3. "If target is in sorted left half, search there"
4. "Otherwise, search in right half"
5. "This gives us O(log n) time with O(1) space"

### Alternative Approaches to Mention:
- **Linear Search:** "The naive approach would scan all elements, but that's O(n)"
- **Find Pivot First:** "We could find rotation point, then apply binary search on appropriate half"

### Follow-up Questions to Prepare:
- "Why modified binary search?" → Need to handle rotation point
- "What if array has duplicates?" → Need to handle carefully in modified binary search
- "Can we optimize further?" → No, O(log n) is optimal for search problems
- "What about edge cases?" → Empty array, single element, no rotation

## Key Insights
- Rotated array has one sorted half and one unsorted half
- Modified binary search checks which half is sorted
- Time complexity is logarithmic: O(log n)
- Space complexity is constant: O(1)
- Need to handle rotation point detection

## Approach Details

### 1. Linear Search
Scan through array sequentially to find target.

### 2. Modified Binary Search (Optimal)
Adapt binary search to handle rotation point by checking sorted halves.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
