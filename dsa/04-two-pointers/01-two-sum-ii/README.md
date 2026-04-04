# Two Sum II - Input Array Is Sorted - LeetCode #167

**Link:** https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

## Problem Description
Given a **1-indexed** array of integers `numbers` that is already **sorted in non-decreasing order**, find two numbers such that they add up to a specific `target` number. Let these two numbers be `numbers[index1]` and `numbers[index2]` where `1 <= index1 < index2 <= numbers.length`.

Return the indices of the two numbers, `index1` and `index2`, added by one as an integer array `[index1, index2]` of length 2.

**Example:**
- Input: numbers = [2,7,11,15], target = 9
- Output: [1,2]
- Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

**Constraints:**
- 2 <= numbers.length <= 3 * 10^4
- -1000 <= numbers[i] <= 1000
- numbers is sorted in non-decreasing order.
- -1000 <= target <= 1000
- The tests are generated such that there is exactly one solution.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n²) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Two Pointers (Optimal) | O(n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Two Pointers**
**Why:** This is the optimal O(n) solution that leverages the sorted property of the array.

**Interview Logic:**
1. "I'll use two pointers: left at start, right at end"
2. "Since array is sorted, I can adjust pointers based on sum"
3. "If sum < target, I need larger numbers, so move left pointer right"
4. "If sum > target, I need smaller numbers, so move right pointer left"
5. "When sum equals target, I've found the answer"
6. "This gives us O(n) time with O(1) space"

### Alternative Approaches to Mention:
- **Brute Force:** "The naive approach would check all pairs, but that's O(n²)"
- **HashMap:** "We could use HashMap, but that would be O(n) space and we lose the sorted advantage"

### Follow-up Questions to Prepare:
- "Why does sorting help?" → Allows us to make intelligent decisions about pointer movement
- "What if array wasn't sorted?" → We'd need HashMap approach with O(n) space
- "Can we optimize further?" → No, O(n) is optimal since we need to examine each element

## Key Insights
- Sorted array allows intelligent pointer movement
- Two pointers can find the solution in linear time
- No need for extra space since we leverage the sorted property
- Each element is examined at most once

## Approach Details

### 1. Brute Force
Check all possible pairs of indices to find the target sum.

### 2. Two Pointers (Optimal)
Use two pointers starting from opposite ends and adjust based on sum comparison.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
