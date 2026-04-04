# Longest Substring Without Repeating Characters - LeetCode #3

**Link:** https://leetcode.com/problems/longest-substring-without-repeating-characters/

## Problem Description
Given a string `s`, find the length of the longest substring without repeating characters.

**Example:**
- Input: s = "abcabcbb"
- Output: 3
- Explanation: The answer is "abc", with the length of 3.

**Constraints:**
- 0 <= s.length <= 5 * 10^4
- s consists of English letters, digits, symbols and spaces.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n³) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Sliding Window with Array (Optimal) | O(n) | O(1) | Lowercase letters only | Large/Unicode character sets |
| 3 | Sliding Window with HashMap | O(n) | O(min(m,n)) | Large/Unicode character sets | Fixed small alphabet |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Sliding Window with Array**
**Why:** This is the optimal O(n) solution with O(1) space for lowercase letters, demonstrating efficient sliding window technique.

**Interview Logic:**
1. "I'll use a sliding window with two pointers: left and right"
2. "I'll use an array to track the last seen position of each character"
3. "When I encounter a repeating character, I move left pointer past its previous occurrence"
4. "I'll keep track of the maximum window size seen so far"
5. "This gives us O(n) time with O(1) space since alphabet size is fixed"

### Alternative Approaches to Mention:
- **HashMap Sliding Window:** "If we need to handle Unicode characters, we could use HashMap instead of array"
- **Brute Force:** "The naive approach would check all substrings, but that's O(n³)"

### Follow-up Questions to Prepare:
- "Why move left to max(left, prevPos + 1)?" → To handle cases where previous occurrence is outside current window
- "What if we need the actual substring?" → Keep track of start index when we find maximum
- "Can we optimize space?" → Use array if character set is small and known

## Key Insights
- Sliding window maintains current substring without repeats
- Array/HashMap tracks last seen positions for O(1) lookups
- When repeat found, slide left pointer past previous occurrence

## Approach Details

### 1. Brute Force
Check all possible substrings for uniqueness.

### 2. Sliding Window with Array (Optimal)
Use sliding window with character position tracking using array.

### 3. Sliding Window with HashMap
Use sliding window with character position tracking using HashMap for larger character sets.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
