# Implement strStr() - LeetCode #28

**Link:** https://leetcode.com/problems/implement-strstr/

## Problem Description
Implement `strStr()` or `indexOf()`. Return the index of the first occurrence of needle in haystack, or `-1` if needle is not part of haystack.

**Example:**
- Input: haystack = "hello", needle = "ll"
- Output: 2

**Constraints:**
- 0 <= haystack.length, needle.length <= 10^4
- haystack and needle consist of only lowercase English letters.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(mn) | O(1) | Learning, simple implementation | Large inputs |
| 2 | KMP Algorithm (Optimal) | O(m+n) | O(n) | Always - optimal solution | Never |
| 3 | Rabin-Karp | O(m+n) | O(1) | Hash-based approach | Hash collisions |

## 🎯 Interview Strategy

### Most Appropriate Approach: **KMP Algorithm**
**Why:** This is the optimal O(m+n) solution that demonstrates understanding of string matching algorithms and preprocessing.

**Interview Logic:**
1. "I'll use the KMP algorithm which preprocesses the pattern to create a failure function"
2. "The failure function tells us where to continue matching after a mismatch"
3. "This avoids re-examining characters we already know match"
4. "I'll build the LPS (Longest Prefix Suffix) array for the pattern"
5. "Then use it to efficiently search through the text"
6. "This gives us O(m+n) time where m is haystack length, n is needle length"

### Alternative Approaches to Mention:
- **Brute Force:** "The naive approach would check every possible starting position, but that's O(mn)"
- **Rabin-Karp:** "We could use rolling hash for average O(m+n), but worst case O(mn)"

### Follow-up Questions to Prepare:
- "What is the LPS array?" → Longest proper prefix which is also suffix
- "Why is KMP better than brute force?" → Avoids re-examining matched characters
- "Can we implement this iteratively?" → Yes, KMP is typically iterative

## Key Insights
- KMP preprocesses pattern to create failure function
- LPS array helps skip unnecessary comparisons
- After mismatch, we know where to continue based on previous matches

## Approach Details

### 1. Brute Force
Check every possible starting position in haystack for needle match.

### 2. KMP Algorithm (Optimal)
Use KMP algorithm with LPS array for efficient pattern matching.

### 3. Rabin-Karp
Use rolling hash technique for pattern matching.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
