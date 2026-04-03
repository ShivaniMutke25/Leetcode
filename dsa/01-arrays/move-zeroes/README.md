# Move Zeroes - LeetCode #283

**Link:** https://leetcode.com/problems/move-zeroes/

## Problem Description
Given an integer array `nums`, move all zeros to the end of it while maintaining the relative order of the non-zero elements. You must do this in-place without making a copy of the array.

**Example:**
- Input: nums = [0,1,0,3,12]
- Output: [1,3,12,0,0]
- Explanation: Zeros moved to end, non-zeros maintain order

**Constraints:**
- 1 <= nums.length <= 10^4
- -2^31 <= nums[i] <= 2^31 - 1

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Extra Space | O(n) | O(n) | Simpler code acceptable | In-place required |
| 2 | Two Pointers (Optimal) | O(n) | O(1) | Always - in-place solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Two Pointers**
**Why:** This is the optimal in-place solution that demonstrates understanding of the two-pointer technique.

**Interview Logic:**
1. "I'll use two pointers: i for current position, j for next non-zero position"
2. "When nums[i] is non-zero, I swap it with nums[j] if i != j"
3. "I increment j after placing each non-zero"
4. "This maintains relative order while moving zeros to the end"
5. "This gives us O(n) time with O(1) space"

### Alternative Approaches to Mention:
- **Extra Space:** "We could use a temporary array, but that uses O(n) space"
- **Count and Fill:** "We could count zeros, then shift non-zeros and fill zeros"

### Follow-up Questions to Prepare:
- "Why do we swap only when i != j?" → To avoid unnecessary swaps when element is already correct
- "Can we do this with one pass?" → Yes, the two-pointer approach is single pass
- "What if we need to move zeros to the beginning?" → Similar logic but work backwards

## Key Insights
- Use two pointers: one for current position, one for next non-zero position
- When we find a non-zero, swap it with the zero position
- Maintains relative order of non-zero elements

## Approach Details

### 1. Extra Space
Create a new array, copy non-zeros first, then fill with zeros.

### 2. Two Pointers (Optimal)
Use two pointers to track position for next non-zero element and swap when needed.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
