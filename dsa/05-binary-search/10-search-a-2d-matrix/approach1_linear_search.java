/**
 * Linear Search Approach - Search a 2D Matrix
 * 
 * Logic:
 * - Scan through all matrix elements
 * - Compare each element with target
 * - Return true if found, false otherwise
 * 
 * When to use: Understanding problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(m*n) - scan through all elements
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        
        return false;
    }
}

/*
Example Walkthrough:
matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3

i = 0, row = [1,3,5,7]:
  j = 0, matrix[0][0] = 1: 1 != 3
  j = 1, matrix[0][1] = 3: 3 == 3 ✓ → return true

Result: true

Another example:
matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13

i = 0, row = [1,3,5,7]:
  j = 0, matrix[0][0] = 1: 1 != 13
  j = 1, matrix[0][1] = 3: 3 != 13
  j = 2, matrix[0][2] = 5: 5 != 13
  j = 3, matrix[0][3] = 7: 7 != 13

i = 1, row = [10,11,16,20]:
  j = 0, matrix[1][0] = 10: 10 != 13
  j = 1, matrix[1][1] = 11: 11 != 13
  j = 2, matrix[1][2] = 16: 16 != 13
  j = 3, matrix[1][3] = 20: 20 != 13

i = 2, row = [23,30,34,60]:
  j = 0, matrix[2][0] = 23: 23 != 13
  j = 1, matrix[2][1] = 30: 30 != 13
  j = 2, matrix[2][2] = 34: 34 != 13
  j = 3, matrix[2][3] = 60: 60 != 13

Loop ends → return false

Result: false

Why this is inefficient:
- Scans through all elements sequentially
- Time complexity is O(m*n) - very slow for large matrices
- For m=n=100, this is 10,000 comparisons
- Doesn't leverage sorted property of matrix

Key limitation: Doesn't use matrix sorting properties
*/
