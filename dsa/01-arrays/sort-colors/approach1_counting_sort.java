/**
 * Counting Sort Approach - Sort Colors
 * 
 * Logic:
 * - Count occurrences of each color (0, 1, 2)
 * - Overwrite array with correct number of each color in order
 * 
 * When to use: When simpler logic is preferred over single pass
 * When NOT to use: When single pass is required for optimal solution
 * 
 * Time Complexity: O(n) - two passes through array
 * Space Complexity: O(1) - constant space for counters
 */
class Solution {
    public void sortColors(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;
        
        // Count occurrences of each color
        for (int num : nums) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        }
        
        // Overwrite array with sorted colors
        int index = 0;
        
        // Fill with 0s (red)
        while (count0-- > 0) {
            nums[index++] = 0;
        }
        
        // Fill with 1s (white)
        while (count1-- > 0) {
            nums[index++] = 1;
        }
        
        // Fill with 2s (blue)
        while (count2-- > 0) {
            nums[index++] = 2;
        }
    }
}

/*
Example Walkthrough:
nums = [2,0,2,1,1,0]

Counting phase:
count0 = 2 (two 0s)
count1 = 2 (two 1s)
count2 = 2 (two 2s)

Overwrite phase:
Fill 0s: nums = [0,0,2,1,1,0], index = 2
Fill 1s: nums = [0,0,1,1,1,0], index = 4
Fill 2s: nums = [0,0,1,1,2,2], index = 6

Result: nums = [0,0,1,1,2,2]

Why this works:
- Counting phase captures exact distribution of colors
- Overwrite phase places colors in correct order
- Since we know there are only 3 possible values, counting is efficient

Trade-offs:
- Time: O(n) - optimal but requires two passes
- Space: O(1) - constant space for counters
- Simplicity: Very straightforward logic
- Limitations: Requires two passes through array

When this is acceptable:
- Code simplicity is prioritized
- Two passes are acceptable
- You want the most intuitive solution
- Learning the counting sort concept

Advantages:
- Easy to understand and implement
- Works correctly for all cases
- No complex pointer management
- Good for interview when you want to show counting sort knowledge

Disadvantages:
- Not single-pass optimal solution
- Requires storing counts separately
*/
