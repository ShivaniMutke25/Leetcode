/**
 * Sorting Approach - Contains Duplicate
 * 
 * Logic:
 * - Sort the array
 * - Check adjacent elements - if equal, duplicate found
 * 
 * When to use: When space is critical, or interviewer asks for sorting solution
 * When NOT to use: Optimal solution needed, original order matters
 * 
 * Time Complexity: O(n log n) - sorting dominates
 * Space Complexity: O(1) - if we can modify input, O(n) if we can't
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        
        return false;
    }
}

/*
Example Walkthrough:
nums = [1,2,3,1]

After sorting: [1,1,2,3]

Compare adjacent:
  - nums[0]=1, nums[1]=1 → EQUAL ✓
  - Return true

Time Analysis:
  - Sorting: O(n log n)
  - Linear scan: O(n)
  - Total: O(n log n) [sorting dominates]
*/