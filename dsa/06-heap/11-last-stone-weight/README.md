# Last Stone Weight - LeetCode #1046

**Link:** https://leetcode.com/problems/last-stone-weight/

## Problem Description
You are given an array `stones` where `stones[i]` is the weight of the `i-th` stone.

We are playing a game with the stones. On each turn, we choose the two heaviest stones and smash them together. If they have the same weight, both stones are destroyed. If they have different weights, the heavier stone is destroyed and the lighter stone's weight becomes the difference.

Return the weight of the remaining stone. If no stones remain, return 0.

**Example:**
- Input: stones = [2,7,4,1,8,1]
- Output: 1

**Constraints:**
- 1 <= stones.length <= 30
- 1 <= stones[i] <= 1000

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Sort Each Time | O(n² log n) | O(1) | Simple implementation | Large n |
| 2 | Max-Heap (Optimal) | O(n log n) | O(n) | Large n, performance critical | Memory constraints |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Max-Heap**
**Why:** This is optimal O(n log n) solution that efficiently finds heaviest stones.

**Interview Logic:**
1. "I'll use max-heap to always access two heaviest stones"
2. "I'll extract two heaviest stones and smash them"
3. "If they're different, I'll put the difference back"
4. "I'll continue until at most one stone remains"
5. "This gives us O(n log n) time with O(n) space"

### Alternative Approaches to Mention:
- **Sort Each Time:** "We could sort array each iteration but that's O(n² log n)"
- **Bucket Sort:** "We could use counting sort for O(n) time"

### Follow-up Questions to Prepare:
- "Why max-heap instead of min-heap?" → Need heaviest stones first
- "What if all stones same weight?" → All destroyed, return 0
- "Can we optimize further?" → O(n) with counting sort but heap is cleaner
- "What about empty input?" → Return 0

## Key Insights
- Max-heap always provides two heaviest stones
- Each smash operation reduces stone count by at least 1
- Time complexity is O(n log n) - optimal for this problem
- Space complexity is O(n) - heap for stones
- Simple simulation of the game

## Approach Details

### 1. Sort Each Time
Sort array each iteration to find heaviest stones.

### 2. Max-Heap (Optimal)
Use max-heap for efficient stone selection.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
