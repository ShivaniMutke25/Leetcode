/**
 * 2D Binary Search Approach - Search a 2D Matrix II (OPTIMAL)
 * 
 * Logic:
 * - Start from top-right corner of matrix
 * - If current element equals target, return true
 * - If current element > target, move left (smaller values)
 * - If current element < target, move down (larger values)
 * - Continue until we find target or go out of bounds
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(m + n) - eliminate row or column each step
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1; // Start from top-right corner
        
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--; // Move left (smaller values)
            } else {
                row++; // Move down (larger values)
            }
        }
        
        return false;
    }
}

/*
Example Walkthrough:
matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5

m = 5, n = 5
Start: row = 0, col = 4 (matrix[0][4] = 15)

Step 1:
  matrix[0][4] = 15 > target = 5 → col = 3
  row = 0, col = 3 (matrix[0][3] = 11)

Step 2:
  matrix[0][3] = 11 > target = 5 → col = 2
  row = 0, col = 2 (matrix[0][2] = 7)

Step 3:
  matrix[0][2] = 7 > target = 5 → col = 1
  row = 0, col = 1 (matrix[0][1] = 4)

Step 4:
  matrix[0][1] = 4 < target = 5 → row = 1
  row = 1, col = 1 (matrix[1][1] = 5)

Step 5:
  matrix[1][1] = 5 == target = 5 ✓ → return true

Result: true

Another example:
matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20

Start: row = 0, col = 4 (matrix[0][4] = 15)

Step 1:
  matrix[0][4] = 15 < target = 20 → row = 1
  row = 1, col = 4 (matrix[1][4] = 19)

Step 2:
  matrix[1][4] = 19 < target = 20 → row = 2
  row = 2, col = 4 (matrix[2][4] = 22)

Step 3:
  matrix[2][4] = 22 > target = 20 → col = 3
  row = 2, col = 3 (matrix[2][3] = 16)

Step 4:
  matrix[2][3] = 16 < target = 20 → row = 3
  row = 3, col = 3 (matrix[3][3] = 17)

Step 5:
  matrix[3][3] = 17 < target = 20 → row = 4
  row = 4, col = 3 (matrix[4][3] = 26)

Step 6:
  matrix[4][3] = 26 > target = 20 → col = 2
  row = 4, col = 2 (matrix[4][2] = 23)

Step 7:
  matrix[4][2] = 23 > target = 20 → col = 1
  row = 4, col = 1 (matrix[4][1] = 21)

Step 8:
  matrix[4][1] = 21 > target = 20 → col = 0
  row = 4, col = 0 (matrix[4][0] = 18)

Step 9:
  matrix[4][0] = 18 < target = 20 → row = 5
  row = 5, col = 0 (row >= m, loop ends)

Loop ends → return false

Result: false

Why this works:
- Starting from top-right allows elimination of row or column each step
- If current element > target, all elements below are larger, so move left
- If current element < target, all elements to left are smaller, so move down
- Each step eliminates either a row or column
- Time complexity is O(m + n) - optimal for this problem
- Space complexity is O(1) - constant extra space

Why this is optimal:
- Time: O(m + n) - optimal for search in sorted matrix
- Space: O(1) - constant extra space
- Each element is examined at most once
- No redundant calculations

Key insights:
- Top-right corner is key starting point
- Each comparison eliminates entire row or column
- Matrix properties (row-wise and column-wise sorting) enable this optimization
- Need to handle empty matrix case

This is perfect solution!
*/
