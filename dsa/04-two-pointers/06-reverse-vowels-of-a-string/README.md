# Reverse Vowels of a String - LeetCode #345

**Link:** https://leetcode.com/problems/reverse-vowels-of-a-string/

## Problem Description
Given a string `s`, reverse only all the vowels in the string, then return the resulting string.

**Example:**
- Input: s = "hello"
- Output: "holle"
- Explanation: The vowels are 'e' and 'o', which are reversed to 'o' and 'e'.

**Constraints:**
- 1 <= s.length <= 3 * 10^5
- s consists of printable ASCII characters.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n²) | O(n) | Learning, tiny inputs | Any realistic input |
| 2 | Two Pointers (Optimal) | O(n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Two Pointers**
**Why:** This is the optimal O(n) solution that uses opposite-direction pointers to swap only vowels.

**Interview Logic:**
1. "I'll use two pointers: left at start, right at end"
2. "I'll move left pointer forward until finding a vowel"
3. "I'll move right pointer backward until finding a vowel"
4. "I'll swap the vowels and continue until pointers meet"
5. "This gives us O(n) time with O(1) space"

### Alternative Approaches to Mention:
- **Brute Force:** "We could extract vowels, reverse them, and reconstruct string, but that's O(n²)"
- **Stack:** "We could use a stack to collect vowels, but two pointers is more efficient"

### Follow-up Questions to Prepare:
- "Why two pointers?" → Allows in-place vowel reversal without extra space
- "How do we identify vowels?" → Use a set or helper function
- "Can we optimize further?" → No, O(n) is optimal since we need to examine each character

## Key Insights
- Two pointers can reverse only vowels in-place without extra space
- Need to identify vowels efficiently during traversal
- Each vowel is swapped exactly once
- Non-vowel characters remain in their original positions

## Approach Details

### 1. Brute Force
Extract all vowels, reverse them, and reconstruct the string.

### 2. Two Pointers (Optimal)
Use opposite-direction pointers to find and swap vowels in-place.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
