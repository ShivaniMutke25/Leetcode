# Group Anagrams - LeetCode #49

**Link:** https://leetcode.com/problems/group-anagrams/

## Problem Description
Given an array of strings `strs`, group the anagrams together. You can return the answer in any order. An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

**Example:**
- Input: strs = ["eat","tea","tan","ate","nat","bat"]
- Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

**Constraints:**
- 1 <= strs.length <= 10^4
- 1 <= strs[i].length <= 100
- strs[i] consists of lowercase English letters.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n²m log m) | O(nm) | Learning, tiny inputs | Any realistic input |
| 2 | HashMap with Sorted Key (Optimal) | O(nklogk) | O(nk) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **HashMap with Sorted Key**
**Why:** This is the optimal solution that demonstrates understanding of hashing and anagram properties.

**Interview Logic:**
1. "I'll use a HashMap to group anagrams by their sorted character signature"
2. "For each string, I'll sort its characters to create a canonical key"
3. "Strings with the same sorted key are anagrams of each other"
4. "I'll add each string to its corresponding group in the HashMap"
5. "Finally, I'll return all the grouped values"
6. "This gives us O(nklogk) time where k is average string length"

### Alternative Approaches to Mention:
- **Brute Force:** "The naive approach would compare every pair of strings, but that's O(n²)"
- **Frequency Count Key:** "We could use character frequency as key instead of sorting"

### Follow-up Questions to Prepare:
- "Why sort each string?" → Sorted version is unique identifier for anagram group
- "Can we optimize the sorting?" → Use counting sort for O(k) instead of O(klogk)
- "What if strings are very long?" → Frequency count approach would be better

## Key Insights
- Anagrams have same sorted character sequence
- HashMap can group strings by their anagram signature
- Sorting each string creates canonical representation

## Approach Details

### 1. Brute Force
Compare every pair of strings to check if they're anagrams.

### 2. HashMap with Sorted Key (Optimal)
Use HashMap with sorted string as key to group anagrams.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
