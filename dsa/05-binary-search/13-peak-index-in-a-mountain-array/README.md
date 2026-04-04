# Peak Index in a Mountain Array - LeetCode #851

**Link:** https://leetcode.com/problems/peak-index-in-a-mountain-array/

## Problem Description
Let's call an array `arr` a mountain if the following properties hold:
- `arr.length >= 3`
- There exists some `i` with `0 < i < arr.length - 1` such that:
  - `arr[0] < arr[1] < ... < arr[i - 1] < arr[i]`
  - `arr[i] > arr[i + 1] > ... > arr[arr.length - 1]`

Given a mountain array `arr`, return the index `i` such that you are at the peak of the mountain.

**Example:**
- Input: arr = [0,1,0]
- Output: 1
- Input: arr = [0,2,1,0]
- Output: 1

**Constraints:**
- 3 <= arr.length <= 10^4
- 0 <= arr[i] <= 10^6
- There is guaranteed to be exactly one peak.

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
3. "If arr[mid] < arr[mid+1], peak is on right"
4. "If arr[mid] > arr[mid+1], peak is on left"
5. "When left == right, we found peak"
6. "This gives us O(log n) time with O(1) space"

### Alternative Approaches to Mention:
- **Linear Search:** "The naive approach would scan all elements, but that's O(n)"
- **Divide and Conquer:** "We could recursively find peak, but binary search is more efficient"

### Follow-up Questions to Prepare:
- "Why binary search?" → O(log n) vs O(n) linear search
- "What if array has multiple peaks?" → Problem guarantees exactly one peak
- "Can we optimize further?" → No, O(log n) is optimal for this problem
- "What about edge cases?" → Minimum length 3, guaranteed peak

## Key Insights
- Binary search can find peak without checking all elements
- Compare mid with right neighbor to determine search direction
- Time complexity is logarithmic: O(log n)
- Space complexity is constant: O(1)
- Mountain array has exactly one peak

## Approach Details

### 1. Linear Search
Scan through array to find element greater than both neighbors.

### 2. Binary Search (Optimal)
Use binary search to efficiently locate peak element.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
