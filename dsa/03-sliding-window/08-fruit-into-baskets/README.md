# Fruit Into Baskets - LeetCode #904

**Link:** https://leetcode.com/problems/fruit-into-baskets/

## Problem Description
You are visiting a farm that has a single row of fruit trees. The trees are represented by an array `fruits` where `fruits[i]` is the type of fruit the `ith` tree produces. You have two baskets, and each basket can carry any quantity of a single fruit type. You need to collect the maximum amount of fruits, but you must follow these rules:
- Each basket can only carry one type of fruit
- Each tree must be picked from exactly one basket
- You must start from any tree of your choice, then move right picking fruits
- Once you start, you cannot skip a tree

Return the maximum number of fruits you can pick.

**Example:**
- Input: fruits = [1,2,1]
- Output: 3
- Explanation: We can pick from all 3 trees.

**Constraints:**
- 1 <= fruits.length <= 10^5
- 0 <= fruits[i] < fruits.length

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Brute Force | O(n²) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Sliding Window (Optimal) | O(n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Sliding Window**
**Why:** This is the optimal O(n) solution that demonstrates understanding of sliding window with at most K distinct elements pattern.

**Interview Logic:**
1. "I'll use a sliding window with two pointers: left and right"
2. "I'll maintain a frequency map of fruit types in current window"
3. "I'll ensure at most 2 distinct fruit types in window"
4. "When we have more than 2 types, I'll shrink from left"
5. "I'll track the maximum window size found"
6. "This gives us O(n) time with O(1) space since we have at most 3 fruit types"

### Alternative Approaches to Mention:
- **Brute Force:** "The naive approach would try all possible starting positions, but that's O(n²)"
- **Two Pointers with Fixed Size:** "We could use a different approach, but sliding window is most intuitive"

### Follow-up Questions to Prepare:
- "Why at most 2 fruit types?" → We only have 2 baskets, each can hold one type
- "What if we had K baskets?" → Same approach but track at most K distinct types
- "Can we optimize space further?" → No, O(1) is optimal since we track at most 3 types

## Key Insights
- This is "at most K distinct elements" problem with K=2
- Sliding window maintains at most 2 distinct fruit types
- When window has >2 types, shrink from left until valid
- Maximum window size is the answer

## Approach Details

### 1. Brute Force
Check all possible subarrays with at most 2 distinct fruit types.

### 2. Sliding Window (Optimal)
Use sliding window with frequency tracking to find longest subarray with at most 2 distinct elements.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
