# Find All Anagrams in String - LeetCode #438

**Link:** https://leetcode.com/problems/find-all-anagrams-in-a-string/

## Problem Description
Given two strings `s` and `p`, return an array of all start indices of `p`'s anagrams in `s`. You may return the answer in any order. An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

**Example:**
- Input: s = "cbaebabacd", p = "abc"
- Output: [0,6]
- Explanation: The substring starting at index 0 is "cba", and the substring starting at index 6 is "bac".

**Constraints:**
- 1 <= s.length, p.length <= 10^4
- s and p consist of lowercase English letters.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n²m) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Sliding Window (Optimal) | O(n+m) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Sliding Window**
**Why:** This is the optimal O(n+m) solution that demonstrates understanding of sliding window technique and frequency counting.

**Interview Logic:**
1. "I'll use a sliding window of size len(p) over string s"
2. "I'll maintain frequency counts for current window and pattern p"
3. "I'll slide the window one character at a time, updating frequencies"
4. "When frequencies match, I've found an anagram"
5. "This gives us O(n+m) time with O(1) space since alphabet size is fixed"

### Alternative Approaches to Mention:
- **Brute Force:** "The naive approach would check every substring of size m, but that's O(n²m)"
- **Sorting:** "We could sort each substring and compare, but that's O(nm log m)"

### Follow-up Questions to Prepare:
- "Why is space O(1)?" → Fixed alphabet size (26 lowercase letters)
- "What if characters can be Unicode?" → Space would be O(k) where k is unique chars
- "Can we optimize further?" → No, O(n+m) is optimal since we need to examine each character

## Key Insights
- Anagrams have same character frequency counts
- Sliding window allows O(1) frequency updates when sliding
- Fixed alphabet size means O(1) space for frequency arrays

## Approach Details

### 1. Brute Force
Check every possible substring of length m for anagram.

### 2. Sliding Window (Optimal)
Use sliding window with frequency counting to find anagrams efficiently.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
