# Merge Sorted Array - LeetCode #88

**Link:** https://leetcode.com/problems/merge-sorted-array/

## Problem Description
You are given two integer arrays `nums1` and `nums2`, sorted in non-decreasing order, and two integers `m` and `n`, representing the number of elements in `nums1` and `nums2` respectively. Merge `nums2` into `nums1` so that the merged array is also sorted in non-decreasing order.

**Example:**
- Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
- Output: [1,2,2,3,5,6]
- Explanation: The arrays are merged into a sorted array

**Constraints:**
- nums1.length == m + n
- nums2.length == n
- 0 <= m, n <= 200
- 1 <= m + n <= 200

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Extra Space | O(m+n) | O(m+n) | Simpler code acceptable | In-place required |
| 2 | Two Pointers (Optimal) | O(m+n) | O(1) | Always - in-place solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Two Pointers**
**Why:** This is the optimal in-place solution that demonstrates understanding of the two-pointer technique and working backwards.

**Interview Logic:**
1. "I'll use three pointers: i for nums1's valid end, j for nums2's end, k for merge position"
2. "I'll work from the end to avoid overwriting unprocessed elements"
3. "At each step, I place the larger element at position k"
4. "If nums2 has remaining elements, I copy them (nums1 elements are already in place)"
5. "This gives us O(m+n) time with O(1) space"

### Alternative Approaches to Mention:
- **Extra Space:** "We could use a temporary array, but that uses O(m+n) space"
- **Forward Merge:** "We could merge forward, but we'd need extra space to avoid overwriting"

### Follow-up Questions to Prepare:
- "Why work backwards?" → To avoid overwriting unprocessed nums1 elements
- "What if nums1 has no extra space?" → We'd need to use a temporary array
- "Can we do this in-place with no extra space?" → Only because nums1 has space for n elements

## Key Insights
- nums1 has extra space at the end to accommodate nums2
- Work from the end to avoid overwriting unprocessed elements
- Three pointers: i for nums1's end, j for nums2's end, k for merge position

## Approach Details

### 1. Extra Space
Create a new array, merge both arrays into it, then copy back to nums1.

### 2. Two Pointers (Optimal)
Use three pointers working from the end to merge in-place.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
