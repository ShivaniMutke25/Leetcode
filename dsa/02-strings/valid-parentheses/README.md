# Valid Parentheses - LeetCode #20

**Link:** https://leetcode.com/problems/valid-parentheses/

## Problem Description
Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid. An input string is valid if:
1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.

**Example:**
- Input: s = "()"
- Output: true

**Constraints:**
- 1 <= s.length <= 10^4
- s consists of parentheses only '()[]{}'.

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n²) | O(n) | Learning, understanding logic | Any realistic input |
| 2 | Stack (Optimal) | O(n) | O(n) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Stack**
**Why:** This is the optimal O(n) solution that demonstrates understanding of stack data structure and bracket matching.

**Interview Logic:**
1. "I'll use a stack to track opening brackets"
2. "When I encounter an opening bracket, I push it to the stack"
3. "When I encounter a closing bracket, I check if it matches the top of the stack"
4. "If it matches, I pop; if not, or if stack is empty, it's invalid"
5. "At the end, the string is valid if the stack is empty"
6. "This gives us O(n) time with O(n) space"

### Alternative Approaches to Mention:
- **Brute Force:** "We could repeatedly remove matching pairs, but that's O(n²)"
- **Hardcoded Mapping:** "We could use hardcoded conditions, but stack is more elegant"
- **Two Pass:** "We could make multiple passes, but single pass is more efficient"

### Follow-up Questions to Prepare:
- "Why use stack?" → LIFO property ensures correct bracket matching order
- "What if we have invalid characters?" → Return false immediately
- "Can we optimize space?" → No, O(n) space is needed in worst case

## Key Insights
- Stack naturally handles nested bracket structures
- LIFO property ensures correct matching order
- Need to handle all three bracket types

## Approach Details

### 1. Brute Force
Repeatedly remove matching pairs of brackets until no more can be removed.

### 2. Stack (Optimal)
Use stack to track and match opening and closing brackets.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
