# Find K Closest Elements - LeetCode #658

**Link:** https://leetcode.com/problems/find-k-closest-elements/

## Problem Description
Given a sorted integer array `arr`, two integers `k` and `x`, return the `k` closest integers to `x` in the array. The result should also be sorted in ascending order.

An integer `a` is closer to `x` than an integer `b` if:
- |a - x| < |b - x|, or
- |a - x| == |b - x| and a < b

**Example:**
- Input: arr = [1,2,3,4,5], k = 4, x = 3
- Output: [1,2,3,4]
- Input: arr = [1,2,3,4,5], k = 4, x = -1
- Output: [1,2,3,4]

**Constraints:**
- 1 <= k <= arr.length
- 1 <= arr.length <= 10^4
- arr is sorted in ascending order.
- -10^4 <= arr[i], x <= 10^4

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Two Pointers | O(n) | O(1) | Simple implementation | Multiple queries |
| 2 | Min-Heap (Optimal) | O(n log k) | O(k) | Multiple queries, large n | Very small k |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Two Pointers**
**Why:** This is optimal O(n) solution that leverages sorted array property.

**Interview Logic:**
1. "I'll use two pointers starting from x's position"
2. "I'll expand outward comparing distances"
3. "I'll collect k closest elements"
4. "Finally, I'll sort the result"
5. "This gives us O(n) time with O(1) space"

### Alternative Approaches to Mention:
- **Binary Search + Sliding Window:** "We could find optimal window using binary search"
- **Min-Heap:** "We could use heap but two pointers is more efficient"

### Follow-up Questions to Prepare:
- "Why two pointers instead of binary search?" → Simpler and optimal for this case
- "What if array is not sorted?" → Would need different approach
- "Can we optimize further?" → O(n) is optimal for this problem
- "What about ties?" → Prefer smaller elements per problem statement

## Key Insights
- Two pointers leverage sorted array property
- Expand outward from x's position
- Time complexity is O(n) - optimal for this problem
- Space complexity is O(1) - constant extra space
- Need to sort result at the end

## Approach Details

### 1. Two Pointers
Use two pointers to expand from x's position.

### 2. Min-Heap
Use min-heap to find k closest elements.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
