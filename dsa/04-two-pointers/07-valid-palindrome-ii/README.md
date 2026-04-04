# Valid Palindrome II - LeetCode #680

**Link:** https://leetcode.com/problems/valid-palindrome-ii/

## Problem Description
Given a string `s`, you can delete at most one character from it. Return the longest palindrome you can get.

**Example:**
- Input: s = "abca"
- Output: 3
- Explanation: The longest palindrome after deleting one character is "aba" or "aca".

**Constraints:**
- 1 <= s.length <= 10^5
- s consists of lowercase English letters.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n³) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Two Pointers (Optimal) | O(n²) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Two Pointers**
**Why:** This is the optimal O(n²) solution that uses two pointers to check palindromes efficiently.

**Interview Logic:**
1. "I'll use two pointers: left and right to check palindromes"
2. "For each center, I'll expand both directions to find palindrome"
3. "I'll allow at most one mismatch that can be fixed by deletion"
4. "I'll track the maximum palindrome length found"
5. "This gives us O(n²) time with O(1) space"

### Alternative Approaches to Mention:
- **Brute Force:** "We could try all possible deletions and check palindromes, but that's O(n³)"
- **Dynamic Programming:** "We could use DP, but two pointers is more intuitive"

### Follow-up Questions to Prepare:
- "Why two pointers?" → Efficient palindrome checking by expanding from center
- "What about even length palindromes?" → Handle both single and double character centers
- "Can we optimize further?" → No, O(n²) is optimal for this problem

## Key Insights
- Two pointers can efficiently check if substring is palindrome
- Expanding from center handles both odd and even length palindromes
- Allow at most one mismatch during palindrome check
- Each character can be center of potential palindrome

## Approach Details

### 1. Brute Force
Try deleting each character and check if remaining string is palindrome.

### 2. Two Pointers (Optimal)
Use two pointers to expand from each center and allow one deletion.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
