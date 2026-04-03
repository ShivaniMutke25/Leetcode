/**
 * Extra Space Approach - Move Zeroes
 * 
 * Logic:
 * - Create a temporary array to store result
 * - Copy all non-zero elements to temp array in order
 * - Fill remaining positions with zeros
 * - Copy temp array back to original array
 * 
 * When to use: When simplicity is preferred over space optimization
 * When NOT to use: When in-place modification is required
 * 
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(n) - temporary array for result
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int index = 0;
        
        // Copy non-zero elements to result array
        for (int num : nums) {
            if (num != 0) {
                result[index++] = num;
            }
        }
        
        // Fill remaining positions with zeros
        while (index < n) {
            result[index++] = 0;
        }
        
        // Copy result back to original array
        for (int i = 0; i < n; i++) {
            nums[i] = result[i];
        }
    }
}

/*
Example Walkthrough:
nums = [0,1,0,3,12]

Initialize: result = [0,0,0,0,0], index = 0

Process nums:
num = 0: skip (zero)
num = 1: result[0] = 1, index = 1
num = 0: skip (zero)
num = 3: result[1] = 3, index = 2
num = 12: result[2] = 12, index = 3

result = [1,3,12,0,0]
Fill remaining with zeros: already zeros

Copy back to nums:
nums = [1,3,12,0,0]

Result: All zeros moved to end, non-zeros maintain order

Why this works:
- Collects all non-zero elements in their original order
- Fills remaining space with zeros
- Simple and intuitive approach

Trade-offs:
- Time: O(n) - optimal
- Space: O(n) - uses extra memory
- Simplicity: Very straightforward implementation

When this is acceptable:
- Memory constraints are not tight
- Code clarity is prioritized
- You want the most intuitive solution
- Learning the problem concept

Limitations:
- Doesn't meet the "in-place" requirement
- Uses additional memory unnecessarily
*/
