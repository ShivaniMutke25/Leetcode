/**
 * Two Pointers Approach - Two Sum II (OPTIMAL)
 * 
 * Logic:
 * - Use two pointers: left at start (index 0), right at end (index n-1)
 * - Calculate sum of numbers[left] + numbers[right]
 * - If sum < target: move left pointer right to increase sum
 * - If sum > target: move right pointer left to decrease sum
 * - If sum == target: return 1-indexed positions
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - each element examined at most once
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            
            if (sum == target) {
                // Return 1-indexed positions
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                // Need larger sum, move left pointer right
                left++;
            } else {
                // sum > target, need smaller sum, move right pointer left
                right--;
            }
        }
        
        // According to constraints, this line should never be reached
        return new int[]{-1, -1};
    }
}

/*
Example Walkthrough:
numbers = [2,7,11,15], target = 9

Initialize: left = 0, right = 3

Iteration 1:
  sum = numbers[0] + numbers[3] = 2 + 15 = 17
  sum > target → right-- → right = 2

Iteration 2:
  sum = numbers[0] + numbers[2] = 2 + 11 = 13
  sum > target → right-- → right = 1

Iteration 3:
  sum = numbers[0] + numbers[1] = 2 + 7 = 9
  sum == target → return [1, 2]

Result: [1, 2]

Another example:
numbers = [1,2,3,4,4,9,56,90], target = 8

Initialize: left = 0, right = 7

Iteration 1:
  sum = numbers[0] + numbers[7] = 1 + 90 = 91
  sum > target → right-- → right = 6

Iteration 2:
  sum = numbers[0] + numbers[6] = 1 + 56 = 57
  sum > target → right-- → right = 5

Iteration 3:
  sum = numbers[0] + numbers[5] = 1 + 9 = 10
  sum > target → right-- → right = 4

Iteration 4:
  sum = numbers[0] + numbers[4] = 1 + 4 = 5
  sum < target → left++ → left = 1

Iteration 5:
  sum = numbers[1] + numbers[4] = 2 + 4 = 6
  sum < target → left++ → left = 2

Iteration 6:
  sum = numbers[2] + numbers[4] = 3 + 4 = 7
  sum < target → left++ → left = 3

Iteration 7:
  sum = numbers[3] + numbers[4] = 4 + 4 = 8
  sum == target → return [4, 5]

Result: [4, 5]

Why this works:
- Array is sorted, so we can make intelligent decisions
- If sum is too small, we need larger numbers → move left right
- If sum is too large, we need smaller numbers → move right left
- Each element is examined at most once
- No extra space needed

Why this is optimal:
- Time: O(n) - single pass, optimal
- Space: O(1) - constant extra space
- Leverages sorted property efficiently
- No redundant calculations

Key insights:
- Sorted array is the key constraint that enables two pointers
- Each pointer movement brings us closer to the solution
- We eliminate half of the remaining possibilities with each comparison
- No need for additional data structures

This is the perfect solution!
*/
