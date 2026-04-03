# Sort Colors - LeetCode #75

**Link:** https://leetcode.com/problems/sort-colors/

## Problem Description
Given an array `nums` with `n` objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue. We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

**Example:**
- Input: nums = [2,0,2,1,1,0]
- Output: [0,0,1,1,2,2]
- Explanation: Sorted in order red(0), white(1), blue(2)

**Constraints:**
- n == nums.length
- 1 <= n <= 300
- nums[i] is either 0, 1, or 2

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Counting Sort | O(n) | O(1) | Simpler logic acceptable | Multiple passes not ideal |
| 2 | Dutch National Flag (Optimal) | O(n) | O(1) | Always - single pass solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Dutch National Flag**
**Why:** This is the classic single-pass solution that demonstrates understanding of the three-way partitioning algorithm.

**Interview Logic:**
1. "I'll use three pointers: low for 0s boundary, mid for current, high for 2s boundary"
2. "I'll process elements with mid pointer: if 0, swap with low; if 1, just move; if 2, swap with high"
3. "This maintains three regions: 0s, 1s, and 2s in correct order"
4. "Single pass gives us O(n) time with O(1) space"
5. "This is the famous Dutch National Flag algorithm"

### Alternative Approaches to Mention:
- **Counting Sort:** "We could count each color and overwrite, but that needs two passes"
- **Brute Force:** "We could use sorting, but that's O(n log n) and overkill"

### Follow-up Questions to Prepare:
- "Why don't we increment mid after swapping with high?" → Need to process the swapped element
- "Can this be generalized?" → Yes, for any k-way partitioning problem
- "What if we have more than 3 colors?" → Use counting sort or generalize partitioning

## Key Insights
- Dutch National Flag algorithm uses three pointers for three regions
- Low pointer tracks boundary for 0s, high pointer tracks boundary for 2s
- Mid pointer processes elements, swapping with low or high as needed

## Approach Details

### 1. Counting Sort
Count occurrences of each color, then overwrite array in correct order.

### 2. Dutch National Flag (Optimal)
Use three pointers to partition array in a single pass.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
