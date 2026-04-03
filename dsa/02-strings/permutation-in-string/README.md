# Permutation in String - LeetCode #567

**Link:** https://leetcode.com/problems/permutation-in-string/

## Problem Description
Given two strings `s1` and `s2`, write a function to return true if `s2` contains the permutation of `s1`. In other words, return true if one of `s1`'s permutations is the substring of `s2`.

**Example:**
- Input: s1 = "ab", s2 = "eidbaooo"
- Output: true
- Explanation: s2 contains one of s1's permutations ("ba").

**Constraints:**
- 1 <= s1.length, s2.length <= 10^4
- s1 and s2 consist of lowercase English letters.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(mn) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Sliding Window (Optimal) | O(m+n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Sliding Window**
**Why:** This is the optimal O(m+n) solution that demonstrates understanding of sliding window with frequency counting.

**Interview Logic:**
1. "I'll use a sliding window of size len(s1) over s2"
2. "I'll maintain character frequency counts for the window and s1"
3. "I'll slide the window one character at a time, updating frequencies"
4. "When frequencies match, I've found a permutation"
5. "This gives us O(m+n) time with O(1) space since alphabet size is fixed"

### Alternative Approaches to Mention:
- **Brute Force:** "The naive approach would generate all permutations of s1 and check each against s2, but that's O(m!)"
- **Sorting:** "We could sort both strings and compare, but that would be O(mn log n)"

### Follow-up Questions to Prepare:
- "Why is space O(1)?" → Fixed alphabet size (26 lowercase letters)
- "What if characters can be Unicode?" → Space would be O(k) where k is unique chars
- "Can we optimize further?" → No, O(m+n) is optimal since we need to examine each character

## Key Insights
- Permutations have same character frequency counts
- Sliding window allows O(1) frequency updates when sliding
- Fixed alphabet size means O(1) space for frequency arrays

## Approach Details

### 1. Brute Force
Generate all permutations of s1 and check if any exists in s2.

### 2. Sliding Window (Optimal)
Use sliding window with frequency counting to find permutation efficiently.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
