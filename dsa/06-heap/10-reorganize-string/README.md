# Reorganize String - LeetCode #767

**Link:** https://leetcode.com/problems/reorganize-string/

## Problem Description
Given a string `s`, rearrange the characters of `s` so that any two adjacent characters are not the same.

Return any possible rearrangement of `s` or return `""` if it is not possible.

**Example:**
- Input: s = "aab"
- Output: "aba"
- Input: s = "aaab"
- Output: ""

**Constraints:**
- 1 <= s.length <= 500
- s consists of lowercase English letters.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Greedy with Array | O(n) | O(1) | Simple implementation | Multiple queries |
| 2 | Max-Heap (Optimal) | O(n log n) | O(1) | Large n, performance critical | Very small n |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Max-Heap**
**Why:** This is optimal O(n log n) solution that efficiently reorganizes characters.

**Interview Logic:**
1. "I'll count character frequencies and use max-heap"
2. "I'll repeatedly pick most frequent character that's not previous"
3. "I'll store previous character to reuse later"
4. "If no valid character exists, return empty string"
5. "This gives us O(n log n) time with O(1) space"

### Alternative Approaches to Mention:
- **Greedy with Array:** "We could use array for frequencies and greedy selection"
- **Counting Sort:** "We could use counting sort approach"

### Follow-up Questions to Prepare:
- "Why max-heap instead of array?" → Heap gives O(log n) selection
- "What if impossible?" → Most frequent > (n+1)/2
- "Can we optimize further?" → O(n) with array but heap is cleaner
- "What about multiple solutions?" → Any valid arrangement acceptable

## Key Insights
- Max-heap prioritizes most frequent characters
- Previous character must be stored to avoid adjacency
- Impossible if most frequent > (n+1)/2
- Time complexity is O(n log n) - optimal for this problem
- Space complexity is O(1) - fixed alphabet size

## Approach Details

### 1. Greedy with Array
Use frequency array and greedy selection.

### 2. Max-Heap (Optimal)
Use max-heap for efficient character selection.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
