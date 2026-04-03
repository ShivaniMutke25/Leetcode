# Product of Array Except Self - LeetCode #238

**Link:** https://leetcode.com/problems/product-of-array-except-self/

## Problem Description
Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the product of all elements of `nums` except `nums[i]`. You must write an algorithm with O(n) time complexity and without using the division operation.

**Example:**
- Input: nums = [1,2,3,4]
- Output: [24,12,8,6]
- Explanation: [2×3×4, 1×3×4, 1×2×4, 1×2×3]

**Constraints:**
- 2 <= nums.length <= 10^5
- -30 <= nums[i] <= 30
- The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n²) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Division | O(n) | O(1) | When division is allowed | Division prohibited |
| 3 | Prefix/Suffix Products (Optimal) | O(n) | O(n) | Always - meets requirements | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Prefix/Suffix Products**
**Why:** This meets the O(n) time requirement without using division, which is the key constraint.

**Interview Logic:**
1. "I'll use two passes: first for prefix products, second for suffix"
2. "First pass: answer[i] stores product of all elements to the left of i"
3. "Second pass: multiply by suffix products while working backwards"
4. "This avoids division and gives us O(n) time with O(n) space"
5. "The answer array itself stores prefix products to save space"

### Alternative Approaches to Mention:
- **Division:** "If division was allowed, we could calculate total product and divide"
- **Brute Force:** "The naive approach would multiply all other elements for each position"

### Follow-up Questions to Prepare:
- "Why can't we use division?" → Problem constraint and handles zeros correctly
- "What if there are zeros?" → Prefix/suffix handles zeros naturally
- "Can we optimize space further?" → Only O(n) space is possible for this problem

## Key Insights
- For each position, we need product of all elements to the left and right
- Can compute prefix products (left to right) and suffix products (right to left)
- Combine prefix and suffix to get final result

## Approach Details

### 1. Brute Force
For each element, multiply all other elements.

### 2. Division
Calculate total product, then divide by each element.

### 3. Prefix/Suffix Products (Optimal)
Use two passes to compute prefix and suffix products separately.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
