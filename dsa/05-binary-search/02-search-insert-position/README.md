# Search Insert Position - LeetCode #35

**Link:** https://leetcode.com/problems/search-insert-position/

## Problem Description
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if inserted in order.

**Example:**
- Input: nums = [1,3,5,6], target = 5
- Output: 2
- Input: nums = [1,3,5,6], target = 7
- Output: 4

**Constraints:**
- 1 <= nums.length <= 10^4
- -10^4 <= nums[i] <= 10^4
- All values are unique and sorted in ascending order.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Linear Search | O(n) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Binary Search (Optimal) | O(log n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Binary Search**
**Why:** This is optimal O(log n) solution that leverages sorted property.

**Interview Logic:**
1. "I'll use binary search with left and right pointers"
2. "I'll calculate mid and compare with target"
3. "If nums[mid] equals target, return mid"
4. "If nums[mid] < target, search right half"
5. "If nums[mid] > target, search left half"
6. "When loop ends, left will be insertion position"

### Alternative Approaches to Mention:
- **Linear Search:** "The naive approach would scan all elements, but that's O(n)"
- **Built-in Methods:** "We could use Arrays.binarySearch(), but interviewer wants algorithmic understanding"

### Follow-up Questions to Prepare:
- "Why binary search?" → O(log n) vs O(n) linear search
- "What if array is not sorted?" → Sort first, then apply binary search
- "Can we optimize further?" → No, O(log n) is optimal for search problems
- "What about duplicates?" → Need to handle carefully in binary search logic

## Key Insights
- Binary search finds insertion position when target not found
- When loop ends, left points to correct insertion position
- Time complexity is logarithmic: O(log n)
- Space complexity is constant: O(1)
- Need to handle integer overflow in mid calculation

## Approach Details

### 1. Linear Search
Scan through array sequentially to find target or insertion position.

### 2. Binary Search (Optimal)
Use divide and conquer to efficiently locate target or insertion position.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
