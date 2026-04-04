# Kth Largest Element in an Array - LeetCode #215

**Link:** https://leetcode.com/problems/kth-largest-element-in-an-array/

## Problem Description
Given an integer array `nums` and an integer `k`, return the `k-th` largest element in the array.

**Example:**
- Input: nums = [3,2,1,5,6,4], k = 2
- Output: 5
- Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
- Output: 4

**Constraints:**
- 1 <= k <= nums.length <= 10^4
- -10^4 <= nums[i] <= 10^4

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Sort | O(n log n) | O(1) | Simple implementation, one-time query | Multiple queries |
| 2 | Min-Heap (Optimal) | O(n log k) | O(k) | Multiple queries, streaming data | Very small k |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Min-Heap**
**Why:** This is optimal O(n log k) solution that maintains k largest elements.

**Interview Logic:**
1. "I'll use a min-heap of size k to maintain k largest elements"
2. "For each element, I'll add to heap and remove smallest if size exceeds k"
3. "The heap root will always be the kth largest element"
4. "This gives us O(n log k) time with O(k) space"
5. "For multiple queries, this is much better than sorting"

### Alternative Approaches to Mention:
- **QuickSelect:** "We could use QuickSelect for O(n) average time, but worst case is O(n²)"
- **Max-Heap:** "We could use max-heap and extract k times, but that's O(n + k log n)"

### Follow-up Questions to Prepare:
- "Why min-heap instead of max-heap?" → Min-heap keeps k largest, root is kth
- "What if we need to insert elements dynamically?" → Min-heap handles streaming
- "Can we optimize for small k?" → For k=1, just find max in O(n)
- "What about multiple kth queries?" → Sort once, answer all in O(1)

## Key Insights
- Min-heap of size k maintains k largest elements
- Heap root is always the kth largest element
- Time complexity is O(n log k) - better than sorting for small k
- Space complexity is O(k) - much better than O(n)
- Handles streaming data efficiently

## Approach Details

### 1. Sort
Sort array in descending order and return element at index k-1.

### 2. Min-Heap (Optimal)
Maintain min-heap of size k to keep track of k largest elements.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
