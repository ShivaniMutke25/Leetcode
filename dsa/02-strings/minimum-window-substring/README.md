# Minimum Window Substring - LeetCode #76

**Link:** https://leetcode.com/problems/minimum-window-substring/

## Problem Description
Given two strings `s` and `t`, return the minimum window substring of `s` such that every character in `t` (including duplicates) is included in the window. If there is no such substring, return the empty string `""`.

**Example:**
- Input: s = "ADOBECODEBANC", t = "ABC"
- Output: "BANC"

**Constraints:**
- 1 <= m, n <= 10^5
- s and t consist of uppercase and lowercase English letters.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(m²n) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Sliding Window (Optimal) | O(m+n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Sliding Window**
**Why:** This is the optimal O(m+n) solution that demonstrates understanding of sliding window with frequency counting.

**Interview Logic:**
1. "I'll use a sliding window with two pointers to find the minimum window"
2. "I'll maintain a frequency count of characters needed from t"
3. "I'll expand the window to include all required characters"
4. "Then contract the window to find the minimum valid window"
5. "I'll track the best window found and return it"
6. "This gives us O(m+n) time with O(1) space since alphabet size is fixed"

### Alternative Approaches to Mention:
- **Brute Force:** "The naive approach would check all possible windows, but that's O(m²n)"
- **Two-pass approach:** "We could first find valid windows, then minimize them"

### Follow-up Questions to Prepare:
- "Why use formed variable?" → To efficiently check if window contains all required characters
- "Can we optimize space further?" → No, O(1) is optimal due to fixed alphabet
- "What if t is empty?" → Return empty string

## Key Insights
- Sliding window can efficiently find minimum substring
- Frequency counting tracks which characters are needed
- Need to track when window becomes valid (contains all required characters)

## Approach Details

### 1. Brute Force
Check all possible windows for containing all characters of t.

### 2. Sliding Window (Optimal)
Use sliding window with character frequency counting.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
