# Find Peak Element - LeetCode #162

**Link:** https://leetcode.com/problems/find-peak-element/

## Problem Description
A peak element is an element that is strictly greater than its neighbors. Given an input array `nums`, find a peak element and return its index. The array may be unsorted.

**Example:**
- Input: nums = [1,2,3,1]
- Output: 2
- Explanation: 3 is a peak element, so return index 2.

**Constraints:**
- 1 <= nums.length <= 10^4
- -2^31 <= nums[i] <= 2^31 - 1
- nums[i] != nums[i+1] for any valid i.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Linear Search | O(n) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Binary Search (Optimal) | O(log n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Binary Search**
**Why:** This is optimal O(log n) solution that finds peak efficiently.

**Interview Logic:**
1. "I'll use binary search with left and right pointers"
2. "I'll calculate mid and compare with neighbors"
3. "If nums[mid] < nums[mid+1], peak is on the right"
4. "If nums[mid] > nums[mid+1], peak is on the left"
5. "When left == right, we found the peak"
6. "This gives us O(log n) time with O(1) space"

### Alternative Approaches to Mention:
- **Linear Search:** "The naive approach would scan all elements, but that's O(n)"
- **Divide and Conquer:** "We could recursively find peak, but binary search is more efficient"

### Follow-up Questions to Prepare:
- "Why binary search?" → O(log n) vs O(n) linear search
- "What if array has multiple peaks?" → Any peak is acceptable
- "Can we optimize further?" → No, O(log n) is optimal for this problem
- "What about edge cases?" → Single element, monotonic array

## Key Insights
- Binary search can find peak without checking all elements
- Compare mid with right neighbor to determine search direction
- Time complexity is logarithmic: O(log n)
- Space complexity is constant: O(1)
- Need to handle array boundaries carefully

## Approach Details

### 1. Linear Search
Scan through array to find element greater than both neighbors.

### 2. Binary Search (Optimal)
Use binary search to efficiently locate peak element.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
