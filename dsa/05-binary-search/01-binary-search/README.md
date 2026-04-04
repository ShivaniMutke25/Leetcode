# Binary Search - LeetCode #704

**Link:** https://leetcode.com/problems/binary-search/

## Problem Description
Given an array of integers `nums` which is sorted in ascending order, and an integer `target`, write a function to search `target` in `nums`. If `target` exists, then return its index. Otherwise, return `-1`.

**Example:**
- Input: nums = [-1,0,3,5,9,12], target = 9
- Output: 4
- Explanation: 9 exists in nums and its index is 4

**Constraints:**
- 1 <= nums.length <= 10^4
- -10^4 <= nums[i] <= 10^4
- All values are unique.
- nums is sorted in ascending order.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Linear Search | O(n) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Binary Search (Optimal) | O(log n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Binary Search**
**Why:** This is the optimal O(log n) solution that leverages the sorted property of the array.

**Interview Logic:**
1. "I'll use binary search with left and right pointers"
2. "I'll calculate mid and compare with target"
3. "If nums[mid] equals target, I've found the answer"
4. "If nums[mid] is less than target, I search right half"
5. "If nums[mid] is greater than target, I search left half"
6. "This gives us O(log n) time with O(1) space"

### Alternative Approaches to Mention:
- **Linear Search:** "The naive approach would scan all elements, but that's O(n)"
- **Built-in Methods:** "We could use Arrays.binarySearch(), but interviewer wants algorithmic understanding"

### Follow-up Questions to Prepare:
- "Why binary search?" → O(log n) vs O(n) linear search
- "What if array is not sorted?" → Sort first, then apply binary search
- "Can we optimize further?" → No, O(log n) is optimal for search problems
- "What about duplicates?" → Need to handle carefully in binary search logic

## Key Insights
- Binary search requires sorted array
- Each iteration eliminates half of the remaining elements
- Time complexity is logarithmic: O(log n)
- Space complexity is constant: O(1)
- Need to handle integer overflow in mid calculation

## Approach Details

### 1. Linear Search
Scan through array sequentially to find target.

### 2. Binary Search (Optimal)
Use divide and conquer to efficiently locate target.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
