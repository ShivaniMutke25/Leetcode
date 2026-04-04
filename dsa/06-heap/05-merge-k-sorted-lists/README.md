# Merge K Sorted Lists - LeetCode #23

**Link:** https://leetcode.com/problems/merge-k-sorted-lists/

## Problem Description
You are given an array of `k` linked-lists `lists`, each linked-list is sorted in ascending order. Merge all the linked-lists into one sorted linked-list and return it.

**Example:**
- Input: lists = [[1,4,5],[1,3,4],[2,6]]
- Output: [1,1,2,3,4,4,5,6]

**Constraints:**
- k == lists.length
- 0 <= k <= 10^4
- 0 <= lists[i].length <= 500
- -10^4 <= lists[i][j] <= 10^4
- lists[i] is sorted in ascending order.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Merge One by One | O(kn) | O(1) | Small k, simple implementation | Large k |
| 2 | Min-Heap (Optimal) | O(n log k) | O(k) | Large k, many lists | Very small k |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Min-Heap**
**Why:** This is optimal O(n log k) solution that efficiently merges all lists.

**Interview Logic:**
1. "I'll use a min-heap to always pick the smallest available element"
2. "I'll add the first node of each list to the heap"
3. "I'll repeatedly extract the smallest and add its next node to heap"
4. "This gives us O(n log k) time where n is total nodes"
5. "Space is O(k) for the heap plus O(n) for result"

### Alternative Approaches to Mention:
- **Divide and Conquer:** "We could recursively merge pairs, O(n log k)"
- **Merge Sort Style:** "We could merge lists in pairs iteratively"

### Follow-up Questions to Prepare:
- "Why min-heap instead of max-heap?" → We need smallest elements first
- "What if lists have different lengths?" → Heap handles this automatically
- "Can we optimize space?" → Need O(n) for result, O(k) for heap
- "What about empty lists?" → Handle null/empty lists in initialization

## Key Insights
- Min-heap always contains the smallest available node from each list
- Each extraction gives the next element in merged order
- Time complexity is O(n log k) - optimal for k-way merge
- Space complexity is O(k) for heap plus O(n) for result
- Perfect for merging multiple sorted data streams

## Approach Details

### 1. Merge One by One
Iteratively merge lists one by one using standard merge.

### 2. Min-Heap (Optimal)
Use min-heap to always pick smallest available node.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
