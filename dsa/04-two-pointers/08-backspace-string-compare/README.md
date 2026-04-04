# Backspace String Compare - LeetCode #844

**Link:** https://leetcode.com/problems/backspace-string-compare/

## Problem Description
Given two strings `s` and `t`, return true if they are equal when both are typed into empty text editors. `'#'` means a backspace character.

**Example:**
- Input: s = "ab#c", t = "ad#c"
- Output: true
- Explanation: Both s and t become "ac".

**Constraints:**
- 1 <= s.length, t.length <= 200
- s and t only contain lowercase letters and '#' characters.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n²) | O(n) | Learning, tiny inputs | Any realistic input |
| 2 | Two Pointers (Optimal) | O(n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Two Pointers**
**Why:** This is the optimal O(n) solution that processes both strings in reverse.

**Interview Logic:**
1. "I'll use two pointers starting from the end of both strings"
2. "I'll count backspaces in t and skip them in s"
3. "I'll compare characters while accounting for backspaces"
4. "If all characters match, return true"
5. "This gives us O(n) time with O(1) space"

### Alternative Approaches to Mention:
- **Brute Force:** "We could simulate typing both strings character by character, but that's O(n²)"
- **Stack:** "We could use stacks to build final strings, but two pointers is more efficient"

### Follow-up Questions to Prepare:
- "Why process from end?" → Backspaces affect previous characters, so reverse processing is natural
- "What about multiple backspaces?" → We count and skip accordingly
- "Can we optimize further?" → No, O(n) is optimal since we need to examine each character

## Key Insights
- Backspaces affect characters to their left, so reverse processing is natural
- Two pointers can efficiently handle backspace skipping
- Need to count backspaces in target string to match correctly
- Each character is processed exactly once

## Approach Details

### 1. Brute Force
Simulate typing both strings character by character with backspace handling.

### 2. Two Pointers (Optimal)
Process both strings from end using two pointers with backspace counting.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
