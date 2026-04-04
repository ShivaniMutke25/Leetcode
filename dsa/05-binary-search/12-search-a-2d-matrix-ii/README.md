# Search a 2D Matrix II - LeetCode #240

**Link:** https://leetcode.com/problems/search-a-2d-matrix-ii/

## Problem Description
Write an efficient algorithm that searches for a target value in an `m x n` integer matrix. This matrix has the following properties:
- Integers in each row are sorted in ascending from left to right.
- Integers in each column are sorted in ascending from top to bottom.

**Example:**
- Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
- Output: true

**Constraints:**
- m == matrix.length
- n == matrix[i].length
- 1 <= m, n <= 300
- -10^9 <= matrix[i][j] <= 10^9

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Linear Search | O(m*n) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | 2D Binary Search (Optimal) | O(m + n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **2D Binary Search**
**Why:** This is optimal O(m + n) solution that starts from top-right corner.

**Interview Logic:**
1. "I'll start from the top-right corner of the matrix"
2. "If current element equals target, return true"
3. "If current element > target, move left (smaller values)"
4. "If current element < target, move down (larger values)"
5. "Continue until we find target or go out of bounds"
6. "This gives us O(m + n) time with O(1) space"

### Alternative Approaches to Mention:
- **Linear Search:** "The naive approach would scan all elements, but that's O(m*n)"
- **Row-wise Binary Search:** "We could binary search each row, but that's O(m log n)"

### Follow-up Questions to Prepare:
- "Why start from top-right?" → Can eliminate row or column in each step
- "What if matrix is not sorted properly?" → Need to validate matrix properties
- "Can we optimize further?" → O(m + n) is optimal for this problem
- "What about edge cases?" → Empty matrix, single element

## Key Insights
- Starting from top-right allows elimination of row or column
- Each step eliminates either a row or column
- Time complexity is linear: O(m + n)
- Space complexity is constant: O(1)
- Need to handle empty matrix case

## Approach Details

### 1. Linear Search
Scan through all matrix elements to find target.

### 2. 2D Binary Search (Optimal)
Start from top-right corner and move intelligently.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
