/**
 * Two Pointers Approach - Remove Duplicates from Sorted Array II (OPTIMAL)
 * 
 * Logic:
 * - Use two pointers: slow for building result, fast for scanning
 * - Fast pointer scans all elements
 * - Slow pointer only advances when we can keep the element
 * - Allow at most 2 occurrences: slow < 2 or nums[fast] != nums[slow-2]
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - each element examined once
 * Space Complexity: O(1) - constant extra space
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        
        int slow = 2; // Start from position 2 since first 2 elements are always kept
        
        // Fast pointer scans all elements
        for (int fast = 2; fast < nums.length; fast++) {
            // Check if we can keep nums[fast]
            if (slow < 2 || nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        
        return slow;
    }
}

/*
Example Walkthrough:
nums = [1,1,1,2,2,3]

Initialize: slow = 2

fast = 2, nums[2] = 1:
  slow < 2 (2 < 2)? No
  nums[2] != nums[0] (1 != 1)? No
  Skip this element

fast = 3, nums[3] = 2:
  slow < 2 (2 < 2)? No
  nums[3] != nums[1] (2 != 1)? Yes
  nums[2] = 2, slow = 3
  nums = [1,1,2,2,2,3]

fast = 4, nums[4] = 3:
  slow < 2 (3 < 2)? No
  nums[4] != nums[1] (3 != 1)? Yes
  nums[3] = 3, slow = 4
  nums = [1,1,2,2,3,3]

Result: k = 4, nums = [1,1,2,2,3,3]

Another example:
nums = [0,0,1,1,1,1,2,3,3]

Initialize: slow = 2

fast = 2, nums[2] = 1:
  slow < 2 (2 < 2)? No
  nums[2] != nums[0] (1 != 0)? Yes
  nums[2] = 1, slow = 3
  nums = [0,0,1,1,1,1,2,3,3]

fast = 3, nums[3] = 1:
  slow < 2 (3 < 2)? No
  nums[3] != nums[1] (1 != 1)? No
  Skip this element

fast = 4, nums[4] = 1:
  slow < 2 (3 < 2)? No
  nums[4] != nums[1] (1 != 1)? No
  Skip this element

fast = 5, nums[5] = 2:
  slow < 2 (3 < 2)? No
  nums[5] != nums[1] (2 != 1)? Yes
  nums[3] = 2, slow = 4
  nums = [0,0,1,1,2,1,2,3,3]

fast = 6, nums[6] = 3:
  slow < 2 (4 < 2)? No
  nums[6] != nums[2] (3 != 1)? Yes
  nums[4] = 3, slow = 5
  nums = [0,0,1,1,2,1,3,3,3]

Result: k = 5, nums = [0,0,1,1,2,3,3,3]

Why this works:
- First two elements are always kept (slow starts at 2)
- For each element, we check if we already have 2 occurrences
- nums[fast] != nums[slow-2] ensures we don't exceed 2 occurrences
- Slow pointer only advances when we keep an element

Why this is optimal:
- Time: O(n) - single pass, optimal
- Space: O(1) - constant extra space
- Truly in-place solution
- Handles sorted property efficiently

Key insights:
- Sorted array allows us to check just 2 positions back
- Two pointers enable in-place filtering with count constraints
- Slow pointer builds the filtered result
- Each element examined exactly once

This is the perfect solution!
*/
