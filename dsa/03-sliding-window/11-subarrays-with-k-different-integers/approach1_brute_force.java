/**
 * Brute Force Approach - Subarrays with K Different Integers
 * 
 * Logic:
 * - Check all possible subarrays
 * - For each subarray, count distinct integers
 * - Count subarrays where distinct count equals K
 * 
 * When to use: Understanding the problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(n²) - O(n²) subarrays, each distinct count O(n)
 * Space Complexity: O(n) - for storing subarray elements
 */
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int count = 0;
        
        // Check all possible starting positions
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> distinct = new HashSet<>();
            
            // Expand subarray from i
            for (int j = i; j < nums.length; j++) {
                distinct.add(nums[j]);
                
                if (distinct.size() == k) {
                    count++;
                } else if (distinct.size() > k) {
                    break; // No need to expand further
                }
            }
        }
        
        return count;
    }
}

/*
Example Walkthrough:
nums = [1,2,1,2,3], k = 2

i = 0:
  j = 0: subarray = [1], distinct = {1}, size = 1 < 2
  j = 1: subarray = [1,2], distinct = {1,2}, size = 2 → count = 1
  j = 2: subarray = [1,2,1], distinct = {1,2}, size = 2 → count = 2
  j = 3: subarray = [1,2,1,2], distinct = {1,2}, size = 2 → count = 3
  j = 4: subarray = [1,2,1,2,3], distinct = {1,2,3}, size = 3 > 2 → break

i = 1:
  j = 1: subarray = [2], distinct = {2}, size = 1 < 2
  j = 2: subarray = [2,1], distinct = {1,2}, size = 2 → count = 4
  j = 3: subarray = [2,1,2], distinct = {1,2}, size = 2 → count = 5
  j = 4: subarray = [2,1,2,3], distinct = {1,2,3}, size = 3 > 2 → break

i = 2:
  j = 2: subarray = [1], distinct = {1}, size = 1 < 2
  j = 3: subarray = [1,2], distinct = {1,2}, size = 2 → count = 6
  j = 4: subarray = [1,2,3], distinct = {1,2,3}, size = 3 > 2 → break

i = 3:
  j = 3: subarray = [2], distinct = {2}, size = 1 < 2
  j = 4: subarray = [2,3], distinct = {2,3}, size = 2 → count = 7

i = 4:
  j = 4: subarray = [3], distinct = {3}, size = 1 < 2

Result: 7

The 7 subarrays are:
1. [1,2]
2. [1,2,1]
3. [1,2,1,2]
4. [2,1]
5. [2,1,2]
6. [1,2]
7. [2,3]

Why this is inefficient:
- Number of subarrays: n*(n+1)/2 = O(n²)
- For each subarray, distinct counting: O(n) in worst case
- Total: O(n³) time complexity
- For n=20,000, this is completely impractical

Key limitation: No optimization to avoid redundant checking of overlapping subarrays
*/
