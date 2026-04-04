# Median of Two Sorted Arrays - LeetCode #4

**Link:** https://leetcode.com/problems/median-of-two-sorted-arrays/

## Problem Description
Given two sorted arrays `nums1` and `nums2` of size `m` and `n` respectively, return the median of the two sorted arrays. The overall run time complexity should be `O(log (m+n))`.

**Example:**
- Input: nums1 = [1,3], nums2 = [2]
- Output: 2.0
- Input: nums1 = [1,2], nums2 = [3,4]
- Output: 2.5

**Constraints:**
- 0 <= m <= 10^6
- 0 <= n <= 10^6
- 1 <= m + n <= 2 * 10^6

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Merge and Find | O(m+n) | O(m+n) | Learning, small inputs | Any realistic input |
| 2 | Binary Search (Optimal) | O(log (m+n)) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Binary Search**
**Why:** This is optimal O(log (m+n)) solution that finds median without full merge.

**Interview Logic:**
1. "I'll use binary search on the smaller array"
2. "I'll partition both arrays such that left half has same elements as right half"
3. "I'll find correct partition where max(left) <= min(right)"
4. "Then median is max(left) or min(right) depending on total length"
5. "This gives us O(log (m+n)) time with O(1) space"

### Alternative Approaches to Mention:
- **Merge and Find:** "The naive approach would merge both arrays, but that's O(m+n)"
- **Two Pointers:** "We could use two pointers to find median, but binary search is more efficient"

### Follow-up Questions to Prepare:
- "Why binary search?" → O(log (m+n)) vs O(m+n) merge approach
- "What if one array is empty?" → Median is middle element of other array
- "Can we optimize further?" → No, O(log (m+n)) is optimal for this problem
- "What about edge cases?" → Empty arrays, single elements

## Key Insights
- Binary search on partition point, not on values
- Need to partition both arrays correctly
- Time complexity is logarithmic: O(log (m+n))
- Space complexity is constant: O(1)
- Need to handle even/odd total length cases

## Approach Details

### 1. Merge and Find
Merge both arrays and find middle element.

### 2. Binary Search (Optimal)
Use binary search on smaller array to find correct partition.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
