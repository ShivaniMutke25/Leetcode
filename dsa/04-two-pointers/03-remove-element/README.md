# Remove Element - LeetCode #27

**Link:** https://leetcode.com/problems/remove-element/

## Problem Description
Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in `nums` in-place. The order of the elements may be changed. Do not allocate extra space for another array, modify the input array in-place with O(1) extra memory.

**Example:**
- Input: nums = [3,2,2,3], val = 3
- Output: 2, nums = [2,2,_,_]
- Explanation: Your function should return k = 2, with the first two elements of nums being 2.

**Constraints:**
- 0 <= nums.length <= 100
- 0 <= nums[i] <= 50
- 0 <= val <= 100

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n²) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Two Pointers (Optimal) | O(n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Two Pointers**
**Why:** This is the optimal O(n) solution that uses same-direction pointers to filter elements.

**Interview Logic:**
1. "I'll use two pointers: slow for building result, fast for scanning"
2. "Fast pointer scans all elements, slow pointer only keeps non-val elements"
3. "When fast finds non-val element, I copy it to slow position"
4. "Slow pointer only advances when we keep an element"
5. "This gives us O(n) time with O(1) space"

### Alternative Approaches to Mention:
- **Brute Force:** "The naive approach would create new array, but that violates space constraint"
- **In-place Removal:** "We could shift elements, but two pointers is more efficient"

### Follow-up Questions to Prepare:
- "Why two pointers?" → One to scan, one to build result in-place
- "What about element order?" → Order can change, which simplifies solution
- "Can we optimize further?" → No, O(n) is optimal since we need to examine each element

## Key Insights
- Two pointers can filter array in-place without extra space
- Fast pointer scans all elements, slow pointer builds filtered result
- Order doesn't matter, which allows efficient in-place filtering
- Each element is examined exactly once

## Approach Details

### 1. Brute Force
Create new array with elements not equal to val.

### 2. Two Pointers (Optimal)
Use slow-fast pointers to filter array in-place.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
