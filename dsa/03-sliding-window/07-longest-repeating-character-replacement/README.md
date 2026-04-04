# Longest Repeating Character Replacement - LeetCode #424

**Link:** https://leetcode.com/problems/longest-repeating-character-replacement/

## Problem Description
You are given a string `s` and an integer `k`. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most `k` times. Return the length of the longest substring containing the same letter after such operations have been performed.

**Example:**
- Input: s = "ABAB", k = 2
- Output: 4
- Explanation: Replace the two 'A's with two 'B's or vice versa.

**Constraints:**
- 1 <= s.length <= 10^5
- s consists of only uppercase English letters.
- 0 <= k <= s.length

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n²) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Sliding Window (Optimal) | O(n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Sliding Window**
**Why:** This is the optimal O(n) solution that demonstrates understanding of sliding window with character frequency tracking.

**Interview Logic:**
1. "I'll use a sliding window with two pointers: left and right"
2. "I'll maintain character frequencies in the current window"
3. "I'll track the most frequent character in the window"
4. "If window size - maxFreq > k, I'll shrink the window"
5. "The maximum window size found is the answer"
6. "This gives us O(n) time with O(1) space since alphabet size is fixed"

### Alternative Approaches to Mention:
- **Brute Force:** "The naive approach would try all possible substrings, but that's O(n²)"
- **Binary Search:** "We could binary search on answer length, but sliding window is simpler"

### Follow-up Questions to Prepare:
- "Why window size - maxFreq?" → This represents minimum changes needed
- "Can we optimize space further?" → No, O(1) is optimal due to fixed alphabet
- "What if k is very large?" → Answer would be entire string length

## Key Insights
- Window size - maxFreq represents minimum changes needed
- If changes needed > k, window is invalid
- We only need to track max frequency, not all frequencies
- Fixed alphabet size means O(1) space

## Approach Details

### 1. Brute Force
Check all possible substrings and calculate changes needed.

### 2. Sliding Window (Optimal)
Use sliding window with character frequency tracking to find longest valid window.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
