# K Closest Points to Origin - LeetCode #973

**Link:** https://leetcode.com/problems/k-closest-points-to-origin/

## Problem Description
Given an array of `points` where `points[i] = [xi, yi]` represents a point on the X-Y plane and an integer `k`, return the `k` closest points to the origin `(0, 0)`.

The distance between two points on the X-Y plane is the Euclidean distance: `sqrt(x² + y²)`.

**Example:**
- Input: points = [[1,3],[-2,2]], k = 1
- Output: [[-2,2]]
- Input: points = [[3,3],[5,-1],[-2,4]], k = 2
- Output: [[3,3],[-2,4]]

**Constraints:**
- 1 <= k <= points.length <= 10^4
- -10^4 < xi, yi < 10^4

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Sort by Distance | O(n log n) | O(1) | Simple implementation | Large n |
| 2 | Max-Heap (Optimal) | O(n log k) | O(k) | Large n, small k | k close to n |

## 🎯 Interview Strategy

### Most Appropriate Approach: **Max-Heap**
**Why:** This is optimal O(n log k) solution that maintains k closest points.

**Interview Logic:**
1. "I'll use a max-heap of size k to maintain k closest points"
2. "For each point, I'll calculate distance and add to heap"
3. "If heap size exceeds k, I'll remove farthest point"
4. "The heap will contain k closest points"
5. "This gives us O(n log k) time with O(k) space"

### Alternative Approaches to Mention:
- **QuickSelect:** "We could use QuickSelect for O(n) average time"
- **Min-Heap:** "We could use min-heap but would need to extract k times"

### Follow-up Questions to Prepare:
- "Why max-heap instead of min-heap?" → Max-heap keeps k closest, root is farthest
- "Can we avoid sqrt calculation?" → Yes, compare squared distances
- "What about ties?" → Order doesn't matter for equal distances
- "Can we optimize for small k?" → For k=1, just track min distance

## Key Insights
- Max-heap of size k maintains k closest points
- Heap root is always the farthest among k closest
- Can compare squared distances to avoid sqrt
- Time complexity is O(n log k) - better than sorting for small k
- Space complexity is O(k) - much better than O(n)

## Approach Details

### 1. Sort by Distance
Calculate distances, sort, return first k points.

### 2. Max-Heap (Optimal)
Use max-heap to maintain k closest points.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
