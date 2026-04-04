/**
 * Brute Force Approach - Remove Element
 * 
 * Logic:
 * - Create new array with elements not equal to val
 * - Copy elements from original array that don't equal val
 * - Return new array length
 * 
 * When to use: Understanding problem, very small inputs
 * When NOT to use: Any realistic input - violates space constraint
 * 
 * Time Complexity: O(n²) - O(n) to copy + O(n) to shift
 * Space Complexity: O(n) - new array
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int[] result = new int[nums.length];
        int resultIndex = 0;
        
        // Copy elements not equal to val
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                result[resultIndex++] = nums[i];
            }
        }
        
        // Copy back to original array
        for (int i = 0; i < resultIndex; i++) {
            nums[i] = result[i];
        }
        
        return resultIndex;
    }
}

/*
Example Walkthrough:
nums = [3,2,2,3], val = 3

result = [0,0,0], resultIndex = 0

i = 0, nums[0] = 3:
  nums[0] == val → skip

i = 1, nums[1] = 2:
  nums[1] != val → result[0] = 2, resultIndex = 1

i = 2, nums[2] = 2:
  nums[2] != val → result[1] = 2, resultIndex = 2

i = 3, nums[3] = 3:
  nums[3] == val → skip

Copy back:
nums[0] = result[0] = 2
nums[1] = result[1] = 2

Result: k = 2, nums = [2,2,3]

Why this violates constraints:
- Uses O(n) extra space for result array
- Problem requires O(1) extra space
- Copying back is inefficient
- Not truly in-place

Key limitation: Doesn't meet space complexity requirement
*/
