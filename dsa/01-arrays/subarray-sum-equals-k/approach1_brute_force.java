/**
 * Brute Force Approach - Subarray Sum Equals K
 * 
 * Logic:
 * - Try every possible subarray (start to end)
 * - Calculate sum of each subarray
 * - Count subarrays with sum equal to k
 * 
 * When to use: Understanding the problem, very small inputs
 * When NOT to use: Any realistic input - will TLE for n > 1000
 * 
 * Time Complexity: O(n²) - nested loops for all subarrays
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        
        // Try every possible starting point
        for (int start = 0; start < n; start++) {
            int currentSum = 0;
            
            // Try every possible ending point
            for (int end = start; end < n; end++) {
                currentSum += nums[end];
                
                if (currentSum == k) {
                    count++;
                }
            }
        }
        
        return count;
    }
}

/*
Example Walkthrough:
nums = [1,1,1], k = 2

All subarrays and their sums:
Start at 0:
  [1]: sum = 1
  [1,1]: sum = 2 ✓ (count = 1)
  [1,1,1]: sum = 3

Start at 1:
  [1]: sum = 1
  [1,1]: sum = 2 ✓ (count = 2)

Start at 2:
  [1]: sum = 1

Result: count = 2

Another example:
nums = [1,2,3], k = 3

All subarrays:
Start at 0:
  [1]: sum = 1
  [1,2]: sum = 3 ✓ (count = 1)
  [1,2,3]: sum = 6

Start at 1:
  [2]: sum = 2
  [2,3]: sum = 5

Start at 2:
  [3]: sum = 3 ✓ (count = 2)

Result: count = 2

Why this is slow:
- For n elements, there are n*(n+1)/2 subarrays
- For n=20,000, that's ~200 million subarrays
- Each subarray sum calculation takes O(1) with running sum
- Total operations: O(n²)

Key limitation: No optimization to reuse previously computed sums
*/
