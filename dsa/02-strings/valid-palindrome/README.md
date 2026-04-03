# Valid Palindrome - LeetCode #125

**Link:** https://leetcode.com/problems/valid-palindrome/

## Problem Description
Given a string `s`, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

**Example:**
- Input: s = "A man, a plan, a canal: Panama"
- Output: true
- Explanation: "amanaplanacanalpanama" is a palindrome.

**Constraints:**
- 1 <= s.length <= 2 * 10^5
- s consists only of printable ASCII characters.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Built-in Methods | O(n) | O(n) | Quick solution, language features allowed | Manual implementation required |
| 2 | Two Pointers (Optimal) | O(n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Two Pointers**
**Why:** This is the optimal O(n) solution with O(1) space that demonstrates understanding of palindrome checking.

**Interview Logic:**
1. "I'll use two pointers: one at start, one at end"
2. "I'll move pointers inward, skipping non-alphanumeric characters"
3. "I'll compare characters case-insensitively"
4. "If all pairs match, it's a palindrome"
5. "This gives us O(n) time with O(1) space"

### Alternative Approaches to Mention:
- **Built-in Methods:** "We could filter and reverse the string, but that uses extra space"
- **Stack:** "We could use a stack to reverse the string, but that's less efficient"

### Follow-up Questions to Prepare:
- "Why skip non-alphanumeric characters?" → Problem requirement to ignore them
- "How do you handle case sensitivity?" → Convert to same case or use case-insensitive comparison
- "What is alphanumeric?" → Letters and numbers only

## Key Insights
- Two pointers efficiently check palindrome property
- Need to skip non-alphanumeric characters
- Case-insensitive comparison required
- Early termination when mismatch found

## Approach Details

### 1. Built-in Methods
Filter alphanumeric characters and compare with reversed version.

### 2. Two Pointers (Optimal)
Use two pointers to check palindrome from both ends.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
