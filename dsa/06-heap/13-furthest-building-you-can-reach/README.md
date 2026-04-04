# Furthest Building You Can Reach - LeetCode #1642

**Link:** https://leetcode.com/problems/furthest-building-you-can-reach/

## Problem Description
You are given an integer array `heights` where `heights[i]` is the height of the `i-th` building, and a `bricks` integer representing the number of bricks you have.

You start at building `0` and want to reach the last building. You can either use a brick to move from building `i` to building `i+1` if `heights[i] < heights[i+1]`, or use a ladder to move if `heights[i] >= heights[i+1]`.

Return the furthest building index you can reach if you use the given `bricks` optimally.

**Example:**
- Input: heights = [4,2,7,6,9,14,12], bricks = 5
- Output: 4

**Constraints:**
- 1 <= heights.length <= 10^5
- 1 <= heights[i] <= 10^6
- 0 <= bricks <= 10^5

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Greedy | O(n) | O(1) | Simple implementation | Optimal brick usage |
| 2 | Min-Heap (Optimal) | O(n log n) | O(n) | Optimal brick usage | Memory constraints |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Min-Heap**
**Why:** This is optimal solution that uses bricks for largest jumps.

**Interview Logic:**
1. "I'll use min-heap to track brick usage for climbs"
2. "For each climb, I'll use bricks and add to heap"
3. "If bricks run out, I'll replace smallest brick usage with ladder"
4. "This ensures optimal brick usage for largest climbs"
5. "This gives us O(n log n) time with O(n) space"

### Alternative Approaches to Mention:
- **Greedy:** "We could use bricks for first climbs but may not be optimal"
- **Binary Search:** "We could binary search on answer"

### Follow-up Questions to Prepare:
- "Why min-heap?" → Replace smallest brick usage with ladder
- "What if no bricks?" → Can only use ladders
- "Can we optimize further?" → O(n) with greedy but may not be optimal
- "What about equal heights?" → No brick needed

## Key Insights
- Min-heap tracks brick usage for climbs
- Replace smallest brick usage with ladder when needed
- Ensures optimal brick usage for largest climbs
- Time complexity is O(n log n) - optimal for this problem
- Space complexity is O(n) - heap for brick usage

## Approach Details

### 1. Greedy
Use bricks for first climbs until exhausted.

### 2. Min-Heap (Optimal)
Use min-heap for optimal brick usage.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
