/**
 * 2D Binary Search Approach - Search a 2D Matrix (OPTIMAL)
 * 
 * Logic:
 * - Treat 2D matrix as 1D sorted array
 * - Use binary search on virtual 1D array
 * - Convert 1D index back to 2D coordinates
 * - Compare matrix element with target
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(log m + log n) - binary search on virtual 1D array
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / n;
            int col = mid % n;
            
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }
}

/*
Example Walkthrough:
matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3

m = 3, n = 4
left = 0, right = 3*4-1 = 11

Iteration 1:
  mid = 0 + (11-0)/2 = 5
  row = 5/4 = 1, col = 5%4 = 1
  matrix[1][1] = 11
  11 > 3 → right = 4
  left = 0, right = 4

Iteration 2:
  mid = 0 + (4-0)/2 = 2
  row = 2/4 = 0, col = 2%4 = 2
  matrix[0][2] = 5
  5 > 3 → right = 1
  left = 0, right = 1

Iteration 3:
  mid = 0 + (1-0)/2 = 0
  row = 0/4 = 0, col = 0%4 = 0
  matrix[0][0] = 1
  1 < 3 → left = 1
  left = 1, right = 1

Iteration 4:
  mid = 1 + (1-1)/2 = 1
  row = 1/4 = 0, col = 1%4 = 1
  matrix[0][1] = 3
  3 == 3 ✓ → return true

Result: true

Another example:
matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13

m = 3, n = 4
left = 0, right = 11

Iteration 1:
  mid = 5, row = 1, col = 1, matrix[1][1] = 11
  11 < 13 → left = 6
  left = 6, right = 11

Iteration 2:
  mid = 6 + (11-6)/2 = 8
  row = 8/4 = 2, col = 8%4 = 0
  matrix[2][0] = 23
  23 > 13 → right = 7
  left = 6, right = 7

Iteration 3:
  mid = 6 + (7-6)/2 = 6
  row = 6/4 = 1, col = 6%4 = 2
  matrix[1][2] = 16
  16 > 13 → right = 5
  left = 6, right = 5

Loop ends → return false

Result: false

Why this works:
- Matrix can be treated as 1D sorted array due to its properties
- Each row sorted left-to-right and first element > last of previous row
- Convert 1D index to 2D: row = index/n, col = index%n
- Each iteration eliminates half of remaining elements
- Time complexity is O(log(m*n)) = O(log m + log n)
- Space complexity is constant: O(1)

Why this is optimal:
- Time: O(log m + log n) - optimal for search in sorted matrix
- Space: O(1) - constant extra space
- Each element is examined at most once
- No redundant calculations

Key insights:
- Matrix properties allow treating as 1D sorted array
- Index conversion: row = mid/n, col = mid%n
- Standard binary search applies to virtual 1D array
- Need to handle empty matrix case

This is perfect solution!
*/
