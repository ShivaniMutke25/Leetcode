/**
 * Two Pointers Approach - Squares of a Sorted Array (OPTIMAL)
 * 
 * Logic:
 * - Use two pointers: left at start, right at end
 * - Compare absolute values to determine which square is smaller
 * - Fill result array from the end with the larger square
 * - Move the corresponding pointer and continue
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - each element examined at most once
 * Space Complexity: O(n) - for result array
 */
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;
        int index = n - 1; // Fill from the end
        
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            
            if (leftSquare > rightSquare) {
                result[index--] = leftSquare;
                left++;
            } else {
                result[index--] = rightSquare;
                right--;
            }
        }
        
        return result;
    }
}

/*
Example Walkthrough:
nums = [-4,-1,0,3,10]

Initialize: left = 0, right = 3, index = 3

Iteration 1:
  leftSquare = (-4)² = 16
  rightSquare = 10² = 100
  16 < 100 → result[3] = 100, right = 2
  result = [0,0,0,0,100]

Iteration 2:
  leftSquare = (-4)² = 16
  rightSquare = 3² = 9
  16 > 9 → result[2] = 16, left = 1
  result = [0,0,0,16,100]

Iteration 3:
  leftSquare = (-1)² = 1
  rightSquare = 3² = 9
  1 < 9 → result[1] = 9, right = 1
  result = [0,0,9,16,100]

Iteration 4:
  leftSquare = (-1)² = 1
  rightSquare = 0² = 0
  1 > 0 → result[0] = 1, left = 2
  result = [0,1,9,16,100]

Iteration 5:
  leftSquare = 0² = 0
  rightSquare = 0² = 0
  0 <= 0 → result[-1] = 0, right = 0 (index becomes -1, but we're done)
  result = [0,1,9,16,100]

Final result: [0,1,9,16,100]

Another example:
nums = [-7,-3,2,3,11]

Initialize: left = 0, right = 4, index = 4

Iteration 1:
  leftSquare = (-7)² = 49
  rightSquare = 11² = 121
  49 < 121 → result[4] = 121, right = 3

Iteration 2:
  leftSquare = (-7)² = 49
  rightSquare = 3² = 9
  49 > 9 → result[3] = 49, left = 1

Iteration 3:
  leftSquare = (-3)² = 9
  rightSquare = 3² = 9
  9 <= 9 → result[2] = 9, right = 2

Iteration 4:
  leftSquare = (-3)² = 9
  rightSquare = 2² = 4
  9 > 4 → result[1] = 9, left = 2

Iteration 5:
  leftSquare = 2² = 4
  rightSquare = 2² = 4
  4 <= 4 → result[0] = 4, right = 1

Final result: [4,9,9,49,121]

Why this works:
- Largest squares come from elements with largest absolute values
- These are at the array ends due to sorted property
- Two pointers can compare absolute values efficiently
- Filling from end ensures correct order

Why this is optimal:
- Time: O(n) - single pass, optimal
- Space: O(n) - needed for result array
- Leverages sorted property of input
- No need for explicit sorting

Key insights:
- Squaring preserves order for non-negative numbers
- Negative numbers become positive, so compare absolute values
- Two pointers work like merge sort but with squared values
- Each element is processed exactly once

This is the perfect solution!
*/
