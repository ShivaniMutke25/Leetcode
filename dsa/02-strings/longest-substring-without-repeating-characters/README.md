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
| 1 | Brute Force | O(n²) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Sliding Window (Optimal) | O(n) | O(min(m,n)) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Sliding Window**
**Why:** This is the optimal O(n) solution that demonstrates understanding of the sliding window technique.

**Interview Logic:**
1. "I'll use a sliding window with two pointers: left and right"
2. "I'll use a HashMap to track the last seen position of each character"
3. "When I encounter a repeating character, I move left pointer past its previous occurrence"
4. "I keep track of the maximum window size seen so far"
5. "This gives us O(n) time with O(min(m,n)) space where m is character set size"

### Alternative Approaches to Mention:
- **Brute Force:** "The naive approach would check all substrings, but that's O(n²)"
- **Array instead of HashMap:** "If we know the character set, we could use an array instead"

### Follow-up Questions to Prepare:
- "Why move left to max(left, prevPos + 1)?" → To handle cases where previous occurrence is outside current window
- "What if we need the actual substring?" → Keep track of start index when we find maximum
- "Can we optimize space?" → Use array if character set is small and known

## Key Insights
- Sliding window maintains current substring without repeats
- HashMap tracks last seen positions for O(1) lookups
- When repeat found, slide left pointer past previous occurrence

## Approach Details

### 1. Brute Force
Check all possible substrings for uniqueness.

### 2. Sliding Window (Optimal)
Use sliding window with character position tracking.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
