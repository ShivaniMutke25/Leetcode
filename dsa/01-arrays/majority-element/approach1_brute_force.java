/**
 * Brute Force Approach - Majority Element
 * 
 * Logic:
 * - For each element, count its occurrences in the array
 * - If count > n/2, return it as majority element
 * 
 * When to use: Understanding the problem, very small inputs
 * When NOT to use: Any realistic input - will TLE for n > 1000
 * 
 * Time Complexity: O(n²) - nested loops for counting
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        
        // Check each element's count
        for (int i = 0; i < n; i++) {
            int count = 0;
            
            // Count occurrences of nums[i]
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }
            
            // If count exceeds n/2, we found majority
            if (count > n / 2) {
                return nums[i];
            }
        }
        
        // This line should never be reached given problem constraints
        return -1;
    }
}

/*
Example Walkthrough:
nums = [3,2,3]

i=0, nums[0]=3:
  - Count 3s: nums[0]=3(✓), nums[1]=2(✗), nums[2]=3(✓)
  - count = 2
  - 2 > 3/2 = 1.5 ✓
  - Return 3

Result: 3 (found after first element)

Another example:
nums = [2,2,1,1,1,2,2]

i=0, nums[0]=2:
  - Count 2s: positions 0,1,5,6 → count = 4
  - 4 > 7/2 = 3.5 ✓
  - Return 2

Why this is slow:
- For each element, we scan the entire array
- For n=50,000, worst case is ~2.5 billion operations
- We're counting the same elements repeatedly

Key limitation: No optimization to avoid redundant counting
*/
