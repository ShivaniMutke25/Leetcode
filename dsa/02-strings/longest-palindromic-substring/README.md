# Longest Palindromic Substring - LeetCode #5

**Link:** https://leetcode.com/problems/longest-palindromic-substring/

## Problem Description
Given a string `s`, return the longest palindromic substring in `s`.

**Example:**
- Input: s = "babad"
- Output: "bab"
- Explanation: "aba" is also a valid answer.

**Constraints:**
- 1 <= s.length <= 1000
- s consists of only lowercase English letters.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n³) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Center Expansion (Optimal) | O(n²) | O(1) | Always - optimal solution | Never |
| 3 | Dynamic Programming | O(n²) | O(n²) | When DP pattern is preferred | Memory constraints tight |
| 4 | Manacher's Algorithm | O(n) | O(n) | When optimal time is critical | Complex implementation |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Center Expansion**
**Why:** This is the optimal O(n²) solution that's simple to implement and demonstrates understanding of palindrome properties.

**Interview Logic:**
1. "I'll expand around each possible center (both odd and even length)"
2. "For each center, I'll expand left and right while characters match"
3. "I'll keep track of the longest palindrome found"
4. "This handles both odd and even length palindromes"
5. "This gives us O(n²) time with O(1) space"

### Alternative Approaches to Mention:
- **Dynamic Programming:** "We could use DP table to store palindrome results, but that uses O(n²) space"
- **Manacher's Algorithm:** "For optimal O(n) time, we could use Manacher's algorithm, but it's complex"
- **Brute Force:** "The naive approach would check all substrings, but that's O(n³)"

### Follow-up Questions to Prepare:
- "Why expand around centers?" → Every palindrome has a center
- "How do you handle even length palindromes?" → Consider centers between characters
- "Can we optimize further?" → Manacher's algorithm for O(n), but center expansion is usually sufficient

## Key Insights
- Every palindrome has a center (character or between characters)
- Expanding from center finds maximal palindrome for that center
- Need to check both odd and even length palindromes

## Approach Details

### 1. Brute Force
Check all possible substrings for palindrome property.

### 2. Center Expansion (Optimal)
Expand around each possible center to find palindromes.

### 3. Dynamic Programming
Use DP table to store palindrome results for subproblems.

### 4. Manacher's Algorithm
Linear time algorithm for longest palindromic substring.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
