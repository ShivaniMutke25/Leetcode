/**
 * Brute Force Approach - Binary Subarrays with Sum
 * 
 * Logic:
 * - Check all possible subarrays
 * - For each subarray, calculate sum
 * - Count subarrays where sum equals goal
 * 
 * When to use: Understanding the problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(n²) - O(n²) subarrays, each sum calculation O(n)
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        
        // Check all possible starting positions
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            
            // Expand subarray from i
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                
                if (currentSum == goal) {
                    count++;
                }
                
                // Early termination if sum exceeds goal (for positive goal)
                if (goal > 0 && currentSum > goal) {
                    break;
                }
            }
        }
        
        return count;
    }
}

/*
Example Walkthrough:
nums = [1,0,1,0,1], goal = 2

i = 0:
  j = 0: sum = 1 < 2
  j = 1: sum = 1 + 0 = 1 < 2
  j = 2: sum = 1 + 0 + 1 = 2 → count = 1
  j = 3: sum = 2 + 0 = 2 → count = 2
  j = 4: sum = 2 + 1 = 3 > 2 → break

i = 1:
  j = 1: sum = 0 < 2
  j = 2: sum = 0 + 1 = 1 < 2
  j = 3: sum = 1 + 0 = 1 < 2
  j = 4: sum = 1 + 1 = 2 → count = 3

i = 2:
  j = 2: sum = 1 < 2
  j = 3: sum = 1 + 0 = 1 < 2
  j = 4: sum = 1 + 1 = 2 → count = 4

i = 3:
  j = 3: sum = 0 < 2
  j = 4: sum = 0 + 1 = 1 < 2

i = 4:
  j = 4: sum = 1 < 2

Result: 4

The 4 subarrays are:
1. nums[0:2] = [1,0,1] → sum = 2
2. nums[0:3] = [1,0,1,0] → sum = 2
3. nums[1:4] = [0,1,0,1] → sum = 2
4. nums[2:4] = [1,0,1] → sum = 2

Why this is inefficient:
- Number of subarrays: n*(n+1)/2 = O(n²)
- For each subarray, sum calculation: O(n) in worst case
- Total: O(n³) time complexity
- For n=30,000, this is completely impractical

Key limitation: No optimization to reuse computations from overlapping subarrays
*/
