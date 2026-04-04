/**
 * Linear Search Approach - Search a 2D Matrix II
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
matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5

i = 0, row = [1,4,7,11,15]:
  j = 0, matrix[0][0] = 1: 1 != 5
  j = 1, matrix[0][1] = 4: 4 != 5
  j = 2, matrix[0][2] = 7: 7 != 5
  j = 3, matrix[0][3] = 11: 11 != 5
  j = 4, matrix[0][4] = 15: 15 != 5

i = 1, row = [2,5,8,12,19]:
  j = 0, matrix[1][0] = 2: 2 != 5
  j = 1, matrix[1][1] = 5: 5 == 5 ✓ → return true

Result: true

Another example:
matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20

i = 0, row = [1,4,7,11,15]: all elements checked, none equal 20
i = 1, row = [2,5,8,12,19]: all elements checked, none equal 20
i = 2, row = [3,6,9,16,22]: all elements checked, none equal 20
i = 3, row = [10,13,14,17,24]: all elements checked, none equal 20
i = 4, row = [18,21,23,26,30]: all elements checked, none equal 20

Loop ends → return false

Result: false

Why this is inefficient:
- Scans through all elements sequentially
- Time complexity is O(m*n) - very slow for large matrices
- For m=n=300, this is 90,000 comparisons
- Doesn't leverage sorted property of matrix

Key limitation: Doesn't use matrix sorting properties
*/
