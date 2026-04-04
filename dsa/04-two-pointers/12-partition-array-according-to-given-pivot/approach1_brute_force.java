/**
 * Brute Force Approach - Partition Array According to Given Pivot
 * 
 * Logic:
 * - Create new array with elements < pivot first, then >= pivot
 * - Copy elements from original array to new array
 * - Return new array
 * 
 * When to use: Understanding problem, very small inputs
 * When NOT to use: Any realistic input - violates space constraint
 * 
 * Time Complexity: O(n²) - O(n) to copy + O(n) to partition
 * Space Complexity: O(n) - new array
 */
class Solution {
    public int[] partition(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        int index = 0;
        
        // First pass: elements < pivot
        for (int num : nums) {
            if (num < pivot) {
                result[index++] = num;
            }
        }
        
        // Second pass: elements >= pivot
        for (int num : nums) {
            if (num >= pivot) {
                result[index++] = num;
            }
        }
        
        return result;
    }
}

/*
Example Walkthrough:
nums = [9,12,5,10,14,3,10], pivot = 10

result = [0,0,0,0,0,0,0,0], index = 0

First pass (elements < 10):
9 < 10 → result[0] = 9, index = 1
12 < 10? No
5 < 10 → result[1] = 5, index = 2
10 < 10? No
14 < 10? No
3 < 10 → result[2] = 3, index = 3
10 < 10? No

Second pass (elements >= 10):
9 >= 10? No
12 >= 10 → result[3] = 12, index = 4
5 >= 10? No
10 >= 10 → result[4] = 10, index = 5
14 >= 10 → result[5] = 14, index = 6
3 >= 10? No
10 >= 10 → result[6] = 10, index = 7

Result: [9,5,3,12,10,14,10]

Why this violates constraints:
- Uses O(n) extra space for result array
- Two passes through the array
- Not truly in-place
- Inefficient for large arrays

Key limitation: Doesn't meet space complexity requirement
*/
