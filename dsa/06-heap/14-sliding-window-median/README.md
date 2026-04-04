# Sliding Window Median - LeetCode #480

**Link:** https://leetcode.com/problems/sliding-window-median/

## Problem Description
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.

You are given an integer array `nums` and an integer `k`. There is a sliding window of size `k` moving from the very left of the array to the very right. Each time the sliding window moves right by one position.

Return the median array for each window in the original array.

**Example:**
- Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
- Output: [1,-1,-1,3,5,6]

**Constraints:**
- 1 <= k <= nums.length <= 10^5
- -10^4 <= nums[i] <= 10^4

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Sort Each Window | O(nk log k) | O(k) | Simple implementation | Large n |
| 2 | Two Heaps (Optimal) | O(n log k) | O(k) | Large n, performance critical | Memory constraints |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Two Heaps**
**Why:** This is optimal O(n log k) solution that maintains median efficiently.

**Interview Logic:**
1. "I'll use two heaps: max-heap for lower half, min-heap for upper half"
2. "I'll maintain balance and handle window sliding"
3. "For each window, I'll calculate median from heap tops"
4. "I'll use lazy deletion for efficient sliding"
5. "This gives us O(n log k) time with O(k) space"

### Alternative Approaches to Mention:
- **Multiset:** "We could use balanced BST but heaps are more efficient"
- **Sort Each Window:** "We could sort each window but that's O(nk log k)"

### Follow-up Questions to Prepare:
- "Why two heaps instead of one?" → Need to access middle elements
- "How to handle sliding?" → Lazy deletion with hash map
- "What about duplicates?" → Handled by heaps and lazy deletion
- "Can we optimize further?" → O(n log k) is optimal for this problem

## Key Insights
- Two heaps maintain lower and upper halves separately
- Lazy deletion handles efficient window sliding
- Balance ensures median is always accessible
- Time complexity is O(n log k) - optimal for sliding window
- Space complexity is O(k) - window size

## Approach Details

### 1. Sort Each Window
Sort each window and calculate median.

### 2. Two Heaps (Optimal)
Use two heaps with lazy deletion for sliding window.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
