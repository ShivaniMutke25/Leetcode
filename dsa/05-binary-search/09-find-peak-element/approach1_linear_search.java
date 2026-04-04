/**
 * Linear Search Approach - Find Peak Element
 * 
 * Logic:
 * - Scan through array sequentially
 * - Find element greater than both neighbors
 * - Return index of peak element
 * 
 * When to use: Understanding problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(n) - scan through all elements
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean leftGreater = i == 0 || nums[i] > nums[i-1];
            boolean rightGreater = i == nums.length-1 || nums[i] > nums[i+1];
            
            if (leftGreater && rightGreater) {
                return i;
            }
        }
        
        return -1; // Should not reach here for valid input
    }
}

/*
Example Walkthrough:
nums = [1,2,3,1]

i = 0, nums[0] = 1:
  leftGreater = true (i == 0)
  rightGreater = 1 > 2? false
  leftGreater && rightGreater = false

i = 1, nums[1] = 2:
  leftGreater = 2 > 1? true
  rightGreater = 2 > 3? false
  leftGreater && rightGreater = false

i = 2, nums[2] = 3:
  leftGreater = 3 > 2? true
  rightGreater = true (i == 2 == nums.length-1)
  leftGreater && rightGreater = true ✓ → return 2

Result: 2

Another example:
nums = [1,2,1,3,5,6,4]

i = 0, nums[0] = 1: leftGreater=true, rightGreater=1>2?false → false
i = 1, nums[1] = 2: leftGreater=2>1?true, rightGreater=2>1?true → true ✓ → return 1

Result: 1

Why this is inefficient:
- Scans through all elements sequentially
- Time complexity is linear: O(n)
- For n=10,000, this is impractical
- Doesn't leverage properties of peak elements

Key limitation: Doesn't use binary search optimization
*/
