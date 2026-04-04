/**
 * Two Pointers Approach - Remove Element (OPTIMAL)
 * 
 * Logic:
 * - Use two pointers: slow for building result, fast for scanning
 * - Fast pointer scans all elements
 * - Slow pointer only advances when we keep an element
 * - Copy non-val elements to slow position
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - each element examined once
 * Space Complexity: O(1) - constant extra space
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        
        // Fast pointer scans all elements
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                // Copy element to slow position
                nums[slow] = nums[fast];
                slow++;
            }
        }
        
        return slow;
    }
}

/*
Example Walkthrough:
nums = [3,2,2,3], val = 3

Initialize: slow = 0

fast = 0, nums[0] = 3:
  nums[0] == val → skip, slow remains 0

fast = 1, nums[1] = 2:
  nums[1] != val → nums[0] = 2, slow = 1
  nums = [2,2,2,3]

fast = 2, nums[2] = 2:
  nums[2] != val → nums[1] = 2, slow = 2
  nums = [2,2,2,3]

fast = 3, nums[3] = 3:
  nums[3] == val → skip, slow remains 2

Result: k = 2, nums = [2,2,2,3]

Another example:
nums = [0,1,2,2,3,0,4,2], val = 2

Initialize: slow = 0

fast = 0, nums[0] = 0:
  nums[0] != val → nums[0] = 0, slow = 1
  nums = [0,1,2,2,3,0,4,2]

fast = 1, nums[1] = 1:
  nums[1] != val → nums[1] = 1, slow = 2
  nums = [0,1,2,2,3,0,4,2]

fast = 2, nums[2] = 2:
  nums[2] == val → skip, slow remains 2

fast = 3, nums[3] = 2:
  nums[3] == val → skip, slow remains 2

fast = 4, nums[4] = 3:
  nums[4] != val → nums[2] = 3, slow = 3
  nums = [0,1,3,2,3,0,4,2]

fast = 5, nums[5] = 4:
  nums[5] != val → nums[3] = 4, slow = 4
  nums = [0,1,3,4,3,0,4,2]

fast = 6, nums[6] = 2:
  nums[6] == val → skip, slow remains 4

Result: k = 4, nums = [0,1,3,4,3,0,4,2]

Why this works:
- Fast pointer scans all elements exactly once
- Slow pointer only advances when we keep an element
- Overwrites in-place without extra space
- Order can change, which allows efficient filtering

Why this is optimal:
- Time: O(n) - single pass, optimal
- Space: O(1) - constant extra space
- Truly in-place solution
- Each element examined exactly once

Key insights:
- Two pointers enable in-place filtering
- Fast pointer does the scanning work
- Slow pointer builds the filtered result
- Order doesn't matter, which simplifies the solution

This is the perfect solution!
*/
