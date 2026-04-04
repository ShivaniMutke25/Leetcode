# Squares of a Sorted Array - LeetCode #977

**Link:** https://leetcode.com/problems/squares-of-a-sorted-array/

## Problem Description
Given an integer array `nums` sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

**Example:**
- Input: nums = [-4,-1,0,3,10]
- Output: [0,1,9,16,100]
- Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

**Constraints:**
- 1 <= nums.length <= 10^4
- -10^4 <= nums[i] <= 10^4
- nums is sorted in non-decreasing order.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n log n) | O(n) | Learning, tiny inputs | Any realistic input |
| 2 | Two Pointers (Optimal) | O(n) | O(n) | Always - optimal solution | Memory constraints tight |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Two Pointers**
**Why:** This is the optimal O(n) solution that leverages sorted property to fill result array from both ends.

**Interview Logic:**
1. "I'll use two pointers: left at start, right at end"
2. "I'll compare absolute values to determine which square is smaller"
3. "I'll fill result array from the end with the larger square"
4. "I'll move the corresponding pointer and continue"
5. "This gives us O(n) time with O(n) space for result"

### Alternative Approaches to Mention:
- **Brute Force:** "We could square all elements and sort, but that's O(n log n)"
- **Merge Sort:** "We could use merge sort on squared values, but two pointers is more efficient"

### Follow-up Questions to Prepare:
- "Why two pointers?" → Largest squares come from ends, we can compare absolute values
- "What about negative numbers?" → Square makes them positive, but we need to compare absolute values
- "Can we optimize space?" → No, O(n) is needed for result array

## Key Insights
- Squaring preserves order for non-negative numbers
- Negative numbers become positive, so largest squares come from array ends
- Two pointers can fill result from largest to smallest
- Need to compare absolute values, not original values

## Approach Details

### 1. Brute Force
Square all elements and sort the result.

### 2. Two Pointers (Optimal)
Use two pointers to fill result array from both ends based on absolute values.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
