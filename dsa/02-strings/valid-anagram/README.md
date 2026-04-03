# Valid Anagram - LeetCode #242

**Link:** https://leetcode.com/problems/valid-anagram/

## Problem Description
Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise. An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

**Example:**
- Input: s = "anagram", t = "nagaram"
- Output: true

**Constraints:**
- 1 <= s.length, t.length <= 5 * 10^4
- s and t consist of lowercase English letters.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Sorting | O(n log n) | O(n) | Simpler implementation | O(n) time required |
| 2 | Counting Array (Optimal) | O(n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Counting Array**
**Why:** This is the optimal O(n) solution that demonstrates understanding of character frequency counting.

**Interview Logic:**
1. "I'll use a counting array of size 26 for lowercase letters"
2. "I'll increment counts for characters in s and decrement for t"
3. "If all counts end up as 0, the strings are anagrams"
4. "I'll also check lengths first for early termination"
5. "This gives us O(n) time with O(1) space"

### Alternative Approaches to Mention:
- **Sorting:** "We could sort both strings and compare, but that's O(n log n)"
- **HashMap:** "We could use HashMap for any character set, but array is faster for known alphabet"

### Follow-up Questions to Prepare:
- "Why counting array instead of HashMap?" → Faster for known character set, O(1) space
- "What if characters can be Unicode?" → Use HashMap instead of fixed array
- "Can we optimize further?" → No, O(n) is optimal

## Key Insights
- Anagrams have identical character frequency counts
- Counting array provides O(1) space for fixed alphabet
- Early termination if lengths differ

## Approach Details

### 1. Sorting
Sort both strings and compare character by character.

### 2. Counting Array (Optimal)
Use frequency array to count character occurrences.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
