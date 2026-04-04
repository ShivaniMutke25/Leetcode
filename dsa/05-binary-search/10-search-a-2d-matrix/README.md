# Search a 2D Matrix - LeetCode #74

**Link:** https://leetcode.com/problems/search-a-2d-matrix/

## Problem Description
Write an efficient algorithm that searches for a target value in an `m x n` integer matrix. This matrix has the following properties:
- Integers in each row are sorted from left to right.
- The first integer of each row is greater than the last integer of the previous row.

**Example:**
- Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
- Output: true

**Constraints:**
- m == matrix.length
- n == matrix[i].length
- 1 <= m, n <= 100
- -10^4 <= matrix[i][j] <= 10^4

## Approaches

| # | Approach | Time | Space | Use When | Avoid When |
|---|----------|------|-------|----------|-----------|
| 1 | Linear Search | O(m*n) | O(1) | Learning, tiny inputs | Any realistic input |
| 2 | 2D Binary Search (Optimal) | O(log m + log n) | O(1) | Always - optimal solution | Never |

## 🎯 Interview Strategy

### Most Appropriate Approach: **2D Binary Search**
**Why:** This is optimal O(log m + log n) solution that treats matrix as 1D sorted array.

**Interview Logic:**
1. "I'll treat the 2D matrix as a 1D sorted array"
2. "I'll use binary search on the virtual 1D array"
3. "I'll convert 1D index back to 2D coordinates"
4. "Compare matrix element with target"
5. "This gives us O(log m + log n) time with O(1) space"

### Alternative Approaches to Mention:
- **Linear Search:** "The naive approach would scan all elements, but that's O(m*n)"
- **Row-wise Binary Search:** "We could binary search each row, but that's O(m log n)"

### Follow-up Questions to Prepare:
- "Why 2D binary search?" → O(log m + log n) vs O(m*n) linear search
- "What if matrix is not sorted properly?" → Need to validate matrix properties
- "Can we optimize further?" → No, O(log m + log n) is optimal for this problem
- "What about edge cases?" → Empty matrix, single element

## Key Insights
- Matrix can be treated as 1D sorted array
- Need to convert between 1D and 2D indices
- Time complexity is logarithmic: O(log m + log n)
- Space complexity is constant: O(1)
- Need to handle empty matrix case

## Approach Details

### 1. Linear Search
Scan through all matrix elements to find target.

### 2. 2D Binary Search (Optimal)
Treat matrix as 1D sorted array and apply binary search.

---

*Each approach has detailed implementation in its respective Java file with comprehensive explanations and examples.*
