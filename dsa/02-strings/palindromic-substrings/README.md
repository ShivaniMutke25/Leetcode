# Palindromic Substrings - LeetCode #647

**Link:** https://leetcode.com/problems/palindromic-substrings/

## Problem Description
Given a string `s`, return the number of palindromic substrings in it. A string is a palindrome when it reads the same backward as forward.

**Example:**
- Input: s = "abc"
- Output: 3
- Explanation: Three palindromic substrings: "a", "b", "c".

**Constraints:**
- 1 <= s.length <= 1000
- s consists of lowercase English letters.

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
1. "I'll expand around each possible center (both odd and even)"
2. "For each center, I'll expand left and right while characters match"
3. "Each successful expansion represents one palindromic substring"
4. "I'll count all palindromes found"
5. "This gives us O(n²) time with O(1) space"

### Alternative Approaches to Mention:
- **Dynamic Programming:** "We could use DP table to store palindrome results, but that uses O(n²) space"
- **Manacher's Algorithm:** "For optimal O(n) time, we could use Manacher's algorithm, but it's complex"
- **Brute Force:** "The naive approach would check all substrings, but that's O(n³)"

### Follow-up Questions to Prepare:
- "Why expand around centers?" → Every palindrome has a center
- "How do you handle even length palindromes?" → Consider centers between characters
- "What's the difference from longest palindrome problem?" → Here we count all, don't track longest

## Key Insights
- Every palindrome has a center (character or between characters)
- Expanding from center finds all palindromes with that center
- Need to check both odd and even length palindromes
- Count all palindromes, not just find the longest

## Approach Details

### 1. Brute Force
Check all possible substrings for palindrome property.

### 2. Center Expansion (Optimal)
Expand around each possible center to count palindromes.

### 3. Dynamic Programming
Use DP table to store palindrome results for subproblems.

### 4. Manacher's Algorithm
Linear time algorithm for counting palindromic substrings.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
