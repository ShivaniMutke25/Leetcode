# Container With Most Water - LeetCode #11

**Link:** https://leetcode.com/problems/container-with-most-water/

## Problem Description
Given an array `height` where `height[i]` represents the height of a vertical line at position i, find two lines that, together with the x-axis, form a container that holds the most water. Return the maximum amount of water a container can store.

**Example:**
- Input: height = [1,8,6,2,5,4,8,3,7]
- Output: 49
- Explanation: The vertical lines are at index 1 (height 8) and index 8 (height 7), width = 8-1 = 7, height = min(8,7) = 7, area = 7*7 = 49

**Constraints:**
- 2 <= height.length <= 10^5
- 0 <= height[i] <= 10^4

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n²) | O(1) | Learning, very small inputs | Any realistic input size |
| 2 | Two Pointers (Optimal) | O(n) | O(1) | Always - this is the best solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Two Pointers**
**Why:** This is the classic optimal solution that demonstrates understanding of the two-pointer technique and problem insights.

**Interview Logic:**
1. "I'll use two pointers: left at start, right at end"
2. "At each step, I calculate area: (right-left) × min(height[left], height[right])"
3. "I move the pointer pointing to the shorter line inward"
4. "The insight is: moving the taller line can't increase height, only reduces width"
5. "This gives us O(n) time with O(1) space"

### Alternative Approaches to Mention:
- **Brute Force:** "The naive approach would check every pair, but that's O(n²)"
- **Stack-based:** "We could use a monotonic stack, but two pointers is simpler and more efficient"

### Follow-up Questions to Prepare:
- "Why do we move the shorter pointer?" → Because only moving shorter can potentially increase height
- "What if heights are equal?" → Move either pointer (conventionally move right)
- "Can we optimize further?" → No, O(n) is optimal since we need to examine each element

## Key Insights
- Area = width × height (where height = min(left, right))
- Two pointers work because moving the shorter line might find a taller line
- Moving the taller line would only reduce width without potentially increasing height

## Approach Details

### 1. Brute Force
Check every possible pair of lines and calculate the area.

### 2. Two Pointers (Optimal)
Start with pointers at both ends, always move the shorter line inward.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
