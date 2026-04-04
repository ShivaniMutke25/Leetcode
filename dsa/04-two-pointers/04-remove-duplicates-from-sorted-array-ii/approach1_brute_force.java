/**
 * Brute Force Approach - Remove Duplicates from Sorted Array II
 * 
 * Logic:
 * - Create new array with at most 2 occurrences of each element
 * - Count occurrences while iterating
 * - Copy element if count <= 2
 * - Return new array length
 * 
 * When to use: Understanding problem, very small inputs
 * When NOT to use: Any realistic input - violates space constraint
 * 
 * Time Complexity: O(n²) - O(n) to iterate + O(n) to copy back
 * Space Complexity: O(n) - new array
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int[] result = new int[nums.length];
        int resultIndex = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // Count occurrences of nums[i] in result so far
            int count = 0;
            for (int j = 0; j < resultIndex; j++) {
                if (result[j] == nums[i]) {
                    count++;
                }
            }
            
            // Keep element if we have less than 2 occurrences
            if (count < 2) {
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
nums = [1,1,1,2,2,3]

result = [0,0,0,0,0], resultIndex = 0

i = 0, nums[0] = 1:
  count = 0 (empty result so far) < 2 → result[0] = 1, resultIndex = 1

i = 1, nums[1] = 1:
  count = 1 (result[0] = 1) < 2 → result[1] = 1, resultIndex = 2

i = 2, nums[2] = 1:
  count = 2 (result[0] = 1, result[1] = 1) >= 2 → skip

i = 3, nums[3] = 2:
  count = 0 (no 2 in result yet) < 2 → result[2] = 2, resultIndex = 3

i = 4, nums[4] = 3:
  count = 0 (no 3 in result yet) < 2 → result[3] = 3, resultIndex = 4

Copy back:
nums[0] = result[0] = 1
nums[1] = result[1] = 1
nums[2] = result[2] = 2
nums[3] = result[3] = 3

Result: k = 4, nums = [1,1,2,3,2]

Why this violates constraints:
- Uses O(n) extra space for result array
- Counting occurrences is O(n²) in worst case
- Not truly in-place
- Inefficient for large arrays

Key limitation: Doesn't meet space complexity requirement
*/
