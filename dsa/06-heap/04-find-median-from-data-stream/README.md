# Find Median from Data Stream - LeetCode #295

**Link:** https://leetcode.com/problems/find-median-from-data-stream/

## Problem Description
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.

Implement the `MedianFinder` class:
- `MedianFinder()` initializes the data structure.
- `addNum(int num)` adds the integer `num` from the data stream to the data structure.
- `double findMedian()` returns the median of all elements so far.

**Example:**
- Input: ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"], [[], [1], [2], [], [3], []]
- Output: [null, null, null, 1.5, null, 2.0]

**Constraints:**
- -10^5 <= num <= 10^5
- At most 5 * 10^4 calls to addNum and findMedian.
- There will be at least one element in the data structure before findMedian is called.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Sort on Each Query | O(n log n) | O(n) | Simple implementation | Many queries |
| 2 | Two Heaps (Optimal) | O(log n) | O(n) | Streaming data, many queries | Memory constraints |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Two Heaps**
**Why:** This is optimal O(log n) solution that maintains median efficiently.

**Interview Logic:**
1. "I'll use two heaps: max-heap for lower half, min-heap for upper half"
2. "I'll maintain balance so that size difference is at most 1"
3. "For each add, I'll insert into appropriate heap and rebalance"
4. "For median, I'll peek at heap tops based on total size"
5. "This gives us O(log n) per add with O(1) median retrieval"

### Alternative Approaches to Mention:
- **Insertion Sort:** "We could maintain sorted array but insertion is O(n)"
- **Balanced BST:** "We could use TreeSet but heap is more efficient"

### Follow-up Questions to Prepare:
- "Why two heaps instead of one?" → Need to access middle elements
- "How do you maintain balance?" → Rebalance after each insertion
- "What about even/odd size?" → Different median calculation
- "Can we optimize space?" → Need O(n) to store all elements

## Key Insights
- Two heaps maintain lower and upper halves separately
- Max-heap gives access to largest element in lower half
- Min-heap gives access to smallest element in upper half
- Balance ensures median is always accessible
- Time complexity is O(log n) per insertion - optimal for streaming

## Approach Details

### 1. Sort on Each Query
Maintain array, sort on each median query, return median.

### 2. Two Heaps (Optimal)
Use max-heap for lower half and min-heap for upper half.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
