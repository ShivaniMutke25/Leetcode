# Find K Pairs with Smallest Sums - LeetCode #373

**Link:** https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

## Problem Description
You are given two integer arrays `nums1` and `nums2` sorted in ascending order and an integer `k`.

Define a pair `(u, v)` which consists of one element from the first array and one element from the second array.

Return the `k` pairs with the smallest sums.

**Example:**
- Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
- Output: [[1,2],[1,4],[1,6]]

**Constraints:**
- 1 <= nums1.length, nums2.length <= 10^5
- -10^9 <= nums1[i], nums2[i] <= 10^9
- 1 <= k <= 10^4

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(mn log mn) | O(mn) | Very small inputs | Any realistic input |
| 2 | Min-Heap (Optimal) | O(k log k) | O(k) | Large inputs, performance critical | Very small k |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Min-Heap**
**Why:** This is optimal O(k log k) solution that efficiently finds smallest pairs.

**Interview Logic:**
1. "I'll use min-heap to track smallest pair sums"
2. "I'll initialize heap with pairs from first k elements of nums1"
3. "I'll extract smallest pair and add next pair from same row"
4. "I'll continue until k pairs are found"
5. "This gives us O(k log k) time with O(k) space"

### Alternative Approaches to Mention:
- **Brute Force:** "We could generate all pairs and sort, but that's O(mn log mn)"
- **Binary Search:** "We could use binary search on sum value"

### Follow-up Questions to Prepare:
- "Why min-heap?" → Always gives smallest available pair
- "What about duplicate pairs?" → Handled automatically by heap
- "Can we optimize further?" → O(k log k) is optimal for this problem
- "What if k > total pairs?" → Return all possible pairs

## Key Insights
- Min-heap always provides smallest available pair sum
- Each extraction generates next candidate from same row
- Time complexity is O(k log k) - optimal for k pairs
- Space complexity is O(k) - heap of size k
- Leverages sorted property of input arrays

## Approach Details

### 1. Brute Force
Generate all possible pairs, sort by sum, return first k.

### 2. Min-Heap (Optimal)
Use min-heap to efficiently find k smallest pairs.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
