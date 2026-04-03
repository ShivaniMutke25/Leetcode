# Isomorphic Strings - LeetCode #205

**Link:** https://leetcode.com/problems/isomorphic-strings/

## Problem Description
Given two strings `s` and `t`, determine if they are isomorphic. Two strings `s` and `t` are isomorphic if the characters in `s` can be replaced to get `t`. All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

**Example:**
- Input: s = "egg", t = "add"
- Output: true

**Constraints:**
- 1 <= s.length <= 5 * 10^4
- s and t consist of any valid ASCII characters.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n²) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | HashMap (Optimal) | O(n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **HashMap**
**Why:** This is the optimal O(n) solution that demonstrates understanding of character mapping and bijection.

**Interview Logic:**
1. "I'll use two HashMaps to track character mappings in both directions"
2. "One map maps characters from s to t, another from t to s"
3. "For each character pair, I check if mapping already exists"
4. "If mapping conflicts, strings are not isomorphic"
5. "This ensures one-to-one mapping between characters"
6. "This gives us O(n) time with O(1) space since alphabet size is fixed"

### Alternative Approaches to Mention:
- **Brute Force:** "The naive approach would check all possible character mappings"
- **Array Mapping:** "If only lowercase letters, we could use arrays instead of HashMaps"

### Follow-up Questions to Prepare:
- "Why two HashMaps?" → To ensure bijection (one-to-one and onto)
- "Can we optimize space?" → Use arrays if character set is known
- "What if Unicode characters?" → HashMap approach still works

## Key Insights
- Isomorphic strings require one-to-one character mapping
- Need to check mapping in both directions
- HashMap provides O(1) character mapping lookups

## Approach Details

### 1. Brute Force
Check all possible character mappings between strings.

### 2. HashMap (Optimal)
Use two HashMaps to ensure one-to-one character mapping.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
