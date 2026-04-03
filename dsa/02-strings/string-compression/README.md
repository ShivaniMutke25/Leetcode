# String Compression - LeetCode #443

**Link:** https://leetcode.com/problems/string-compression/

## Problem Description
Given an array of characters `chars`, compress it in-place. The length after compression must always be less than or equal to the original array. After you are done modifying the input array in-place, return the new length of the array.

**Example:**
- Input: chars = ["a","a","b","b","c","c","c"]
- Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

**Constraints:**
- 1 <= chars.length <= 2000
- chars[i] is a lowercase English letter.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Extra Space | O(n) | O(n) | Simpler logic acceptable | In-place required |
| 2 | Two Pointers (Optimal) | O(n) | O(1) | Always - in-place solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Two Pointers**
**Why:** This is the optimal O(n) solution with O(1) space that demonstrates understanding of in-place string manipulation.

**Interview Logic:**
1. "I'll use two pointers: one for reading, one for writing"
2. "I'll count consecutive characters and write the character plus count"
3. "I'll handle single characters by only writing the character"
4. "I'll modify the array in-place and return the write pointer position"
5. "This gives us O(n) time with O(1) space"

### Alternative Approaches to Mention:
- **Extra Space:** "We could use a StringBuilder, but that uses O(n) space"
- **Recursion:** "We could use recursion, but it's less efficient for this problem"

### Follow-up Questions to Prepare:
- "Why two pointers?" → One reads original, one writes compressed result
- "How do you handle single characters?" → Only write character, no count
- "What if count is multiple digits?" → Write each digit separately

## Key Insights
- Two pointers allow in-place compression
- Need to handle single characters differently from repeated characters
- Counts may be multiple digits, need to handle digit by digit

## Approach Details

### 1. Extra Space
Use StringBuilder to build compressed string, then copy back.

### 2. Two Pointers (Optimal)
Use two pointers to compress in-place.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
