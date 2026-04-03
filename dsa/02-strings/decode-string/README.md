# Decode String - LeetCode #394

**Link:** https://leetcode.com/problems/decode-string/

## Problem Description
Given an encoded string, return its decoded string. The encoding rule is: `k[encoded_string]`, where the `encoded_string` inside the square brackets is being repeated exactly `k` times. Note that `k` is guaranteed to be a positive integer.

**Example:**
- Input: s = "3[a]2[bc]"
- Output: "aaabcbc"

**Constraints:**
- 1 <= s.length <= 30
- s consists of lowercase English letters, digits, and square brackets.
- s is valid.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Recursive | O(n) | O(n) | Simple recursive logic | Very deep nesting |
| 2 | Stack (Optimal) | O(n) | O(n) | Always - handles nesting well | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Stack**
**Why:** This is the optimal solution that handles nested structures elegantly and demonstrates understanding of stack-based parsing.

**Interview Logic:**
1. "I'll use two stacks: one for numbers, one for strings"
2. "I'll also maintain current number and current string"
3. "When I see a digit, I build the number"
4. "When I see '[', I push current number and string to stacks"
5. "When I see ']', I pop and build the repeated string"
6. "This handles any level of nesting in O(n) time"

### Alternative Approaches to Mention:
- **Recursive:** "We could use recursion, but stack is more iterative and avoids stack overflow"
- **Queue-based:** "We could use a queue, but stack is more natural for nested structures"

### Follow-up Questions to Prepare:
- "What if there are spaces in the input?" → Skip them during processing
- "Can we do this in-place?" → No, we need extra space for the result
- "What if numbers can be multiple digits?" → Build the number digit by digit

## Key Insights
- Stack naturally handles nested structures like brackets
- Need separate stacks for numbers and strings
- Process digits to build multipliers, letters to build current string

## Approach Details

### 1. Recursive
Use recursion to handle nested brackets, returning decoded string for each level.

### 2. Stack (Optimal)
Use stacks to handle nested structures iteratively.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
