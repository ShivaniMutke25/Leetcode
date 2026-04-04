/**
 * Modified Binary Search Approach - Search in Rotated Sorted Array (OPTIMAL)
 * 
 * Logic:
 * - Use modified binary search with left and right pointers
 * - Check if left half is sorted
 * - If target is in sorted left half, search there
 * - Otherwise, search in right half
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(log n) - each iteration eliminates half
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            // Check if left half is sorted
            if (nums[left] <= nums[mid]) {
                // Left half is sorted
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // Right half is sorted
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return -1;
    }
}

/*
Example Walkthrough:
nums = [4,5,6,7,0,1,2], target = 0

Initialize: left = 0, right = 5

Iteration 1:
  mid = 0 + (5-0)/2 = 2
  nums[2] = 6
  nums[left] = 4 <= nums[mid] = 6 → left half [4,5,6] is sorted
  target = 0 is NOT in [4,6] → search right half
  left = 3, right = 5

Iteration 2:
  mid = 3 + (5-3)/2 = 4
  nums[4] = 1
  nums[left] = 7 > nums[mid] = 1 → right half [7,0,1,2] is sorted
  target = 0 is IN [0,2] → search right half
  left = 3, right = 3

Iteration 3:
  mid = 3 + (3-3)/2 = 3
  nums[3] = 0 == target ✓ → return 3

Result: 3

Another example:
nums = [4,5,6,7,0,1,2], target = 3

Initialize: left = 0, right = 5

Iteration 1:
  mid = 0 + (5-0)/2 = 2
  nums[2] = 6
  nums[left] = 4 <= nums[mid] = 6 → left half [4,5,6] is sorted
  target = 3 is NOT in [4,6] → search right half
  left = 3, right = 5

Iteration 2:
  mid = 3 + (5-3)/2 = 4
  nums[4] = 1
  nums[left] = 7 > nums[mid] = 1 → right half [7,0,1,2] is sorted
  target = 3 is NOT in [0,2] → search left half
  left = 3, right = 3

Iteration 3:
  mid = 3 + (3-3)/2 = 3
  nums[3] = 7
  nums[left] = 7 <= nums[mid] = 7 → left half [7] is sorted
  target = 3 is NOT in [7,7] → search right half
  left = 4, right = 3

Loop ends → return -1

Result: -1

Why this works:
- Each iteration eliminates half of the remaining elements
- Checks which half is sorted to determine search direction
- Time complexity is logarithmic: O(log n)
- Leverages rotated sorted property of array
- Space complexity is constant: O(1)

Why this is optimal:
- Time: O(log n) - optimal for search in sorted array
- Space: O(1) - constant extra space
- Each element is examined at most once
- No redundant calculations

Key insights:
- Rotated array has one sorted half and one unsorted half
- Modified binary search checks which half is sorted
- Need to compare target with boundaries correctly
- Mid calculation: left + (right - left) / 2 prevents overflow

This is perfect solution!
*/
