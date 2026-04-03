/**
 * Sorting Approach - Longest Consecutive Sequence
 * 
 * Logic:
 * - Sort the array to bring consecutive numbers together
 * - Iterate through sorted array counting consecutive sequences
 * - Skip duplicates to avoid counting them as breaks
 * 
 * When to use: When O(n log n) is acceptable, simpler to implement
 * When NOT to use: When O(n) time is strictly required
 * 
 * Time Complexity: O(n log n) - sorting dominates
 * Space Complexity: O(1) or O(n) - depends on sort implementation
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        
        // Sort the array
        Arrays.sort(nums);
        
        int maxLength = 1;
        int currentLength = 1;
        
        // Iterate through sorted array
        for (int i = 1; i < nums.length; i++) {
            // Skip duplicates
            if (nums[i] == nums[i-1]) {
                continue;
            }
            
            // Check if current number is consecutive to previous
            if (nums[i] == nums[i-1] + 1) {
                currentLength++;
            } else {
                // Start new sequence
                currentLength = 1;
            }
            
            maxLength = Math.max(maxLength, currentLength);
        }
        
        return maxLength;
    }
}

/*
Example Walkthrough:
nums = [100,4,200,1,3,2]

After sorting: [1,2,3,4,100,200]

i=1: nums[1]=2, nums[0]=1
  - 2 == 1+1 ✓ (consecutive)
  - currentLength = 2
  - maxLength = 2

i=2: nums[2]=3, nums[1]=2
  - 3 == 2+1 ✓ (consecutive)
  - currentLength = 3
  - maxLength = 3

i=3: nums[3]=4, nums[2]=3
  - 4 == 3+1 ✓ (consecutive)
  - currentLength = 4
  - maxLength = 4 ⭐

i=4: nums[4]=100, nums[3]=4
  - 100 != 4+1 (not consecutive)
  - currentLength = 1 (reset)

i=5: nums[5]=200, nums[4]=100
  - 200 != 100+1 (not consecutive)
  - currentLength = 1 (reset)

Result: maxLength = 4

Why this works better than brute force:
- Sorting groups consecutive numbers together
- Single pass through sorted array
- No repeated searching for the same numbers

Trade-offs:
- Time: O(n log n) vs O(n²) - much better
- Space: Depends on sort, usually O(1) for in-place sort
- Still not O(n) as required by problem

When this is acceptable:
- Interviewer allows O(n log n) solution
- Code simplicity is prioritized
- Memory constraints are tight (no HashSet)
*/
