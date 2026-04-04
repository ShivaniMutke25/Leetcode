/**
 * Brute Force Approach - Two Sum II
 * 
 * Logic:
 * - Check all possible pairs of indices
 * - For each pair, check if sum equals target
 * - Return the 1-indexed positions when found
 * 
 * When to use: Understanding the problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(n²) - O(n²) pairs, each sum calculation O(1)
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        
        // Check all possible pairs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] + numbers[j] == target) {
                    // Return 1-indexed positions
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        
        // According to constraints, this line should never be reached
        return new int[]{-1, -1};
    }
}

/*
Example Walkthrough:
numbers = [2,7,11,15], target = 9

i = 0, numbers[0] = 2:
  j = 1, numbers[1] = 7: 2 + 7 = 9 ✓ → return [1, 2]

Another example:
numbers = [1,2,3,4,4,9,56,90], target = 8

i = 0, numbers[0] = 1:
  j = 1, numbers[1] = 2: 1 + 2 = 3 < 8
  j = 2, numbers[2] = 3: 1 + 3 = 4 < 8
  j = 3, numbers[3] = 4: 1 + 4 = 5 < 8
  j = 4, numbers[4] = 4: 1 + 4 = 5 < 8
  j = 5, numbers[5] = 9: 1 + 9 = 10 > 8
  j = 6, numbers[6] = 56: 1 + 56 = 57 > 8
  j = 7, numbers[7] = 90: 1 + 90 = 91 > 8

i = 1, numbers[1] = 2:
  j = 2, numbers[2] = 3: 2 + 3 = 5 < 8
  j = 3, numbers[3] = 4: 2 + 4 = 6 < 8
  j = 4, numbers[4] = 4: 2 + 4 = 6 < 8
  j = 5, numbers[5] = 9: 2 + 9 = 11 > 8
  j = 6, numbers[6] = 56: 2 + 56 = 58 > 8
  j = 7, numbers[7] = 90: 2 + 90 = 92 > 8

i = 2, numbers[2] = 3:
  j = 3, numbers[3] = 4: 3 + 4 = 7 < 8
  j = 4, numbers[4] = 4: 3 + 4 = 7 < 8
  j = 5, numbers[5] = 9: 3 + 9 = 12 > 8
  j = 6, numbers[6] = 56: 3 + 56 = 59 > 8
  j = 7, numbers[7] = 90: 3 + 90 = 93 > 8

i = 3, numbers[3] = 4:
  j = 4, numbers[4] = 4: 4 + 4 = 8 ✓ → return [4, 5]

Result: [4, 5]

Why this is inefficient:
- Number of pairs: n*(n-1)/2 = O(n²)
- For each pair, sum calculation: O(1)
- Total: O(n²) time complexity
- For n=30,000, this is completely impractical

Key limitation: Doesn't leverage the sorted property of the array
*/
