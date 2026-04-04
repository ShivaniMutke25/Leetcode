# Reverse String - LeetCode #344

**Link:** https://leetcode.com/problems/reverse-string/

## Problem Description
Write a function that reverses a string. The input string is given as an array of characters `s`.

**Example:**
- Input: s = ["h","e","l","l","o"]
- Output: ["o","l","l","e","h"]

**Constraints:**
- 1 <= s.length <= 10^5
- s[i] is a printable ASCII character.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n) | O(n) | Learning, tiny inputs | Any realistic input |
| 2 | Two Pointers (Optimal) | O(n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Two Pointers**
**Why:** This is the optimal O(n) solution that uses opposite-direction pointers to swap characters.

**Interview Logic:**
1. "I'll use two pointers: left at start, right at end"
2. "I'll swap characters at left and right positions"
3. "I'll move left pointer right and right pointer left"
4. "I'll continue until pointers meet or cross"
5. "This gives us O(n) time with O(1) space"

### Alternative Approaches to Mention:
- **Brute Force:** "We could create new array and copy in reverse, but that uses O(n) space"
- **Built-in Methods:** "We could use built-in reverse, but interviewer wants algorithmic understanding"

### Follow-up Questions to Prepare:
- "Why two pointers?" → Allows in-place reversal without extra space
- "What about odd length arrays?" → Middle element stays in place
- "Can we optimize further?" → No, O(n) is optimal since we need to touch each element

## Key Insights
- Two pointers can reverse array in-place without extra space
- Opposite direction pointers work perfectly for reversal
- Each element is swapped exactly once
- Middle element doesn't need to move in odd-length arrays

## Approach Details

### 1. Brute Force
Create new array and copy elements in reverse order.

### 2. Two Pointers (Optimal)
Use opposite-direction pointers to swap characters in-place.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
