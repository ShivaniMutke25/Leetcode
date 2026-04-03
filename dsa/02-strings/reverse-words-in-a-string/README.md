# Reverse Words in a String - LeetCode #151

**Link:** https://leetcode.com/problems/reverse-words-in-a-string/

## Problem Description
Given an input string `s`, reverse the order of the words. A word is defined as a sequence of non-space characters. The words in `s` will be separated by at least one space. Return a string of the words in reverse order concatenated by a single space.

**Example:**
- Input: s = "the sky is blue"
- Output: "blue is sky the"

**Constraints:**
- 1 <= s.length <= 10^4
- s contains English letters (upper-case and lower-case), digits, and spaces ' '.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Built-in Methods | O(n) | O(n) | Quick solution, language features allowed | Manual implementation required |
| 2 | Two Pointers (Optimal) | O(n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Two Pointers**
**Why:** This is the optimal O(n) solution with O(1) space that demonstrates understanding of in-place string manipulation.

**Interview Logic:**
1. "I'll use two pointers to process the string from end to beginning"
2. "I'll skip spaces, then extract each word"
3. "I'll build the result by appending words in reverse order"
4. "I'll handle multiple spaces and edge cases properly"
5. "This gives us O(n) time with O(1) space"

### Alternative Approaches to Mention:
- **Built-in Methods:** "We could split and reverse using built-in methods, but that uses extra space"
- **Stack:** "We could use a stack to reverse words, but that's less efficient"

### Follow-up Questions to Prepare:
- "Why process from end to beginning?" → To build result in correct order without extra reversal
- "How do you handle multiple spaces?" → Skip consecutive spaces
- "What if string is all spaces?" → Return empty string

## Key Insights
- Processing from end to beginning builds result in correct order
- Need to handle multiple consecutive spaces
- Two pointers can extract words efficiently

## Approach Details

### 1. Built-in Methods
Use split() and reverse() methods for quick solution.

### 2. Two Pointers (Optimal)
Use two pointers to process string from end to beginning.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
