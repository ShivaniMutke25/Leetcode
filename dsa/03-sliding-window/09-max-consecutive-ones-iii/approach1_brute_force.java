/**
 * Brute Force Approach - Max Consecutive Ones III
 * 
 * Logic:
 * - Check all possible subarrays
 * - For each subarray, count zeros
 * - Track longest subarray with zeros <= k
 * 
 * When to use: Understanding the problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(n²) - O(n²) subarrays, each zero count O(n)
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLength = 0;
        
        // Check all possible starting positions
        for (int i = 0; i < nums.length; i++) {
            int zeroCount = 0;
            
            // Expand subarray from i
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    zeroCount++;
                }
                
                // If zeros exceed k, stop expanding
                if (zeroCount > k) {
                    break;
                }
                
                // Update maximum length
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        
        return maxLength;
    }
}

/*
Example Walkthrough:
nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2

i = 0:
  j = 0-2: nums = [1,1,1], zeroCount = 0 <= 2, maxLength = 3
  j = 3: nums[3] = 0, zeroCount = 1 <= 2, maxLength = 4
  j = 4: nums[4] = 0, zeroCount = 2 <= 2, maxLength = 5
  j = 5: nums[5] = 0, zeroCount = 3 > 2 → break

i = 1:
  j = 1-3: nums = [1,1,0], zeroCount = 1 <= 2, maxLength = 5
  j = 4: nums[4] = 0, zeroCount = 2 <= 2, maxLength = 5
  j = 5: nums[5] = 0, zeroCount = 3 > 2 → break

i = 2:
  j = 2-4: nums = [1,0,0], zeroCount = 2 <= 2, maxLength = 5
  j = 5: nums[5] = 0, zeroCount = 3 > 2 → break

i = 3:
  j = 3-5: nums = [0,0,0], zeroCount = 3 > 2 → break immediately

i = 4:
  j = 4-5: nums = [0,0], zeroCount = 2 <= 2, maxLength = 5
  j = 6: nums[6] = 1, zeroCount = 2 <= 2, maxLength = 5
  j = 7: nums[7] = 1, zeroCount = 2 <= 2, maxLength = 5
  j = 8: nums[8] = 1, zeroCount = 2 <= 2, maxLength = 5
  j = 9: nums[9] = 1, zeroCount = 2 <= 2, maxLength = 5
  j = 10: nums[10] = 0, zeroCount = 3 > 2 → break

i = 5:
  j = 5-10: nums = [0,1,1,1,1,0], zeroCount = 2 <= 2, maxLength = 6

Continue for all starting positions...

Result: 6

The optimal subarray is [1,1,1,1,1,1] after flipping the two zeros.

Why this is inefficient:
- Number of subarrays: n*(n+1)/2 = O(n²)
- For each subarray, zero counting: O(n) in worst case
- Total: O(n³) time complexity
- For n=100,000, this is completely impractical

Key limitation: No optimization to avoid redundant checking of overlapping subarrays
*/
