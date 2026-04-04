# Number of Substrings Containing All Three Characters - LeetCode #1358

**Link:** https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

## Problem Description
Given a string `s` containing only `'a'`, `'b'`, and `'c'`, return the number of substrings that contain all three characters at least once.

**Example:**
- Input: s = "abcabc"
- Output: 10
- Explanation: The substrings containing "a", "b", and "c" at least once are:
  "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc", "abc"

**Constraints:**
- 3 <= s.length <= 5 * 10^4
- s consists of only 'a', 'b', and 'c'.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n³) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Sliding Window (Optimal) | O(n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Sliding Window**
**Why:** This is the optimal O(n) solution that demonstrates understanding of sliding window with character counting.

**Interview Logic:**
1. "I'll use a sliding window with two pointers: left and right"
2. "I'll maintain counts of 'a', 'b', 'c' in the current window"
3. "When the window contains all three characters, all substrings starting from left to right are valid"
4. "I'll add the count of valid substrings and move left pointer"
5. "I'll continue until the end of the string"
6. "This gives us O(n) time with O(1) space"

### Alternative Approaches to Mention:
- **Brute Force:** "The naive approach would check all substrings, but that's O(n³)"
- **Fixed Window:** "We could use fixed windows, but sliding window is more efficient"

### Follow-up Questions to Prepare:
- "Why add right-left+1 when window is valid?" → All substrings starting at left and ending anywhere between left and right are valid
- "What if string doesn't contain all three characters?" → Return 0
- "Can we optimize further?" → No, O(n) is optimal since we need to examine each character

## Key Insights
- Once window contains all three characters, expanding right keeps it valid
- All substrings starting from left to right are valid when window is valid
- We can count all valid substrings in O(1) when window becomes valid
- Fixed character set means O(1) space

## Approach Details

### 1. Brute Force
Check all possible substrings and verify they contain all three characters.

### 2. Sliding Window (Optimal)
Use sliding window with character counting to efficiently count valid substrings.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
