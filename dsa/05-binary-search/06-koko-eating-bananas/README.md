# Koko Eating Bananas - LeetCode #875

**Link:** https://leetcode.com/problems/koko-eating-bananas/

## Problem Description
Koko loves to eat bananas. There are `n` piles of bananas, the `i-th` pile has `piles[i]` bananas. The guards have gone and will come back in `h` hours. Koko can decide her bananas-per-hour eating speed of `k`. Each hour, she chooses some pile of bananas and eats `k` bananas from that pile. If the pile has less than `k` bananas, she eats all of them and won't eat any more bananas during this hour.

Return the minimum integer `k` such that she can eat all the bananas within `h` hours.

**Example:**
- Input: piles = [3,6,7,11], h = 8
- Output: 4
- Input: piles = [30,11,23,4,20], h = 5
- Output: 30

**Constraints:**
- 1 <= piles.length <= 10^4
- 1 <= piles[i] <= 10^9
- 1 <= h <= 10^9

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Linear Search | O(n * max) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | Binary Search (Optimal) | O(n log max) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Binary Search**
**Why:** This is optimal O(n log max) solution that finds minimum speed using binary search.

**Interview Logic:**
1. "I'll use binary search on possible eating speeds"
2. "For each speed, I'll check if Koko can eat all bananas in h hours"
3. "If possible, I'll try slower speeds"
4. "If not possible, I'll try faster speeds"
5. "This gives us O(n log max) time with O(1) space"

### Alternative Approaches to Mention:
- **Linear Search:** "The naive approach would try all speeds from 1 to max, but that's O(n * max)"
- **Mathematical:** "We could use some mathematical optimization, but binary search is more reliable"

### Follow-up Questions to Prepare:
- "Why binary search?" → O(n log max) vs O(n * max) linear search
- "What if h equals sum of piles?" → Speed must be max(piles)
- "Can we optimize further?" → No, O(n log max) is optimal for this problem
- "What about edge cases?" → Single pile, h = 1

## Key Insights
- Binary search on answer space (possible eating speeds)
- Need helper function to check if speed is feasible
- Time complexity is O(n log max) - log max for binary search, n for feasibility check
- Space complexity is constant: O(1)
- Need to find minimum feasible speed

## Approach Details

### 1. Linear Search
Try all possible speeds from 1 to max(piles) and find minimum feasible speed.

### 2. Binary Search (Optimal)
Use binary search on speed range to find minimum feasible eating speed.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
