# Longest Common Prefix - LeetCode #14

**Link:** https://leetcode.com/problems/longest-common-prefix/

## Problem Description
Write a function to find the longest common prefix string amongst an array of strings. If there is no common prefix, return an empty string `""`.

**Example:**
- Input: strs = ["flower","flow","flight"]
- Output: "fl"

**Constraints:**
- 1 <= strs.length <= 200
- 0 <= strs[i].length <= 200
- strs[i] consists of only lowercase English letters.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(mn) | O(1) | Learning, simple logic | Large datasets |
| 2 | Vertical Scan | O(mn) | O(1) | All cases - optimal solution | Never |
| 3 | Horizontal Scan | O(mn) | O(1) | When string count is small | Many strings |
| 4 | Sorting | O(mn log n) | O(1) | When sorting is acceptable | O(mn) required |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Vertical Scan**
**Why:** This is the intuitive and optimal solution that demonstrates systematic thinking.

**Interview Logic:**
1. "I'll scan character by character vertically across all strings"
2. "For each position, I check if all strings have the same character"
3. "If any string is too short or character differs, I stop"
4. "The prefix up to that point is the longest common prefix"
5. "This gives us O(mn) time where m is min string length, n is number of strings"

### Alternative Approaches to Mention:
- **Horizontal Scan:** "We could compare prefix with each string iteratively"
- **Sorting:** "If we sort strings, the common prefix of first and last is the answer"
- **Binary Search:** "We could binary search on prefix length, but vertical scan is simpler"

### Follow-up Questions to Prepare:
- "What if there's only one string?" → Return that string
- "What if strings are empty?" → Return empty string
- "Can we optimize further?" → No, O(mn) is optimal since we need to examine characters

## Key Insights
- Common prefix can't be longer than the shortest string
- Vertical scan checks each position across all strings
- Early termination when mismatch found

## Approach Details

### 1. Brute Force
Compare all possible prefixes with all strings.

### 2. Vertical Scan (Optimal)
Scan character by character across all strings.

### 3. Horizontal Scan
Iteratively compare prefix with each string.

### 4. Sorting
Sort strings and compare first and last.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
