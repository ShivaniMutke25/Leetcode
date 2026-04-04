# Kth Largest Element in a Stream - LeetCode #703

**Link:** https://leetcode.com/problems/kth-largest-element-in-a-stream/

## Problem Description
Design a class to find the `k-th` largest element in a stream. Note that it is the `k-th` largest element in the sorted order, not the `k-th` distinct element.

Implement `KthLargest` class:
- `KthLargest(int k, int[] nums)` Initializes the object with integer `k` and the stream of numbers `nums`.
- `int add(int val)` Appends `val` to the stream and returns the element representing the `k-th` largest element.

**Example:**
- Input: ["KthLargest", "add", "add", "add", "add", "add"], [[3, [4,5,8,2]], [3], [5], [10], [9], [4]]
- Output: [null, 4, 5, 5, 8, 8]

**Constraints:**
- 1 <= k <= 10^4
- 0 <= nums.length <= 10^4
- -10^9 <= nums[i] <= 10^9
- -10^9 <= val <= 10^9
- At most 10^4 calls to add.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Sort on Each Add | O(n log n) | O(1) | Simple implementation | Many add operations |
| 2 | Min-Heap (Optimal) | O(log n) | O(k) | Streaming data, many adds | Very small k |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Min-Heap**
**Why:** This is optimal O(log n) solution that maintains k largest elements efficiently.

**Interview Logic:**
1. "I'll use a min-heap of size k to maintain k largest elements"
2. "In constructor, I'll initialize heap with initial numbers"
3. "For each add operation, I'll insert new element and maintain heap size"
4. "The heap root will always be the kth largest element"
5. "This gives us O(log n) per add operation with O(k) space"

### Alternative Approaches to Mention:
- **Max-Heap:** "We could use max-heap but would need to extract k times"
- **Balanced BST:** "We could use TreeSet but heap is more efficient"

### Follow-up Questions to Prepare:
- "Why min-heap instead of max-heap?" → Min-heap keeps k largest, root is kth
- "What if we need to remove elements?" → Would need additional data structure
- "Can we optimize for small k?" → For k=1, just track max
- "What about memory constraints?" → Heap uses minimal O(k) space

## Key Insights
- Min-heap of size k maintains k largest elements
- Heap root is always the kth largest element
- Time complexity is O(log n) per insertion - optimal for streaming
- Space complexity is O(k) - much better than O(n)
- Perfect for streaming data scenarios

## Approach Details

### 1. Sort on Each Add
Maintain array, sort on each add operation, return kth element.

### 2. Min-Heap (Optimal)
Maintain min-heap of size k to keep track of k largest elements.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
