/**
 * Two Binary Searches Approach - Find First and Last Position (OPTIMAL)
 * 
 * Logic:
 * - Use two separate binary searches
 * - First search finds leftmost occurrence of target
 * - Second search finds rightmost occurrence of target
 * - Return positions or [-1,-1] if not found
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(log n) - each search is O(log n)
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        
        return new int[]{first, last};
    }
    
    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                result = mid;
                right = mid - 1; // Search left half for first occurrence
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                result = mid;
                left = mid + 1; // Search right half for last occurrence
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
}

/*
Example Walkthrough:
nums = [5,7,7,8,8,10], target = 8

First search (findFirst):
Initialize: left = 0, right = 5, result = -1

Iteration 1:
  mid = 0 + (5-0)/2 = 2
  nums[2] = 7 < 8 → search right half
  left = 3, right = 5

Iteration 2:
  mid = 3 + (5-3)/2 = 4
  nums[4] = 8 == 8 ✓ → result = 4, right = 3
  left = 3, right = 3

Iteration 3:
  mid = 3 + (3-3)/2 = 3
  nums[3] = 8 == 8 ✓ → result = 3, right = 2
  left = 3, right = 2

Loop ends → return result = 3

Last search (findLast):
Initialize: left = 0, right = 5, result = -1

Iteration 1:
  mid = 0 + (5-0)/2 = 2
  nums[2] = 7 < 8 → search right half
  left = 3, right = 5

Iteration 2:
  mid = 3 + (5-3)/2 = 4
  nums[4] = 8 == 8 ✓ → result = 4, left = 5
  left = 5, right = 5

Iteration 3:
  mid = 5 + (5-5)/2 = 5
  nums[5] = 10 > 8 → search left half
  left = 5, right = 4

Loop ends → return result = 4

Result: [3,4]

Another example:
nums = [5,7,7,8,8,10], target = 6

First search (findFirst):
Initialize: left = 0, right = 5, result = -1

Iteration 1:
  mid = 0 + (5-0)/2 = 2
  nums[2] = 7 > 6 → search left half
  left = 0, right = 1

Iteration 2:
  mid = 0 + (1-0)/2 = 0
  nums[0] = 5 < 6 → search right half
  left = 1, right = 1

Iteration 3:
  mid = 1 + (1-1)/2 = 1
  nums[1] = 7 > 6 → search left half
  left = 1, right = 0

Loop ends → return result = -1

Last search (findLast):
Similar to first search, will also return -1

Result: [-1,-1]

Another example:
nums = [2,2,2,2], target = 2

First search (findFirst):
Initialize: left = 0, right = 3, result = -1

Iteration 1:
  mid = 0 + (3-0)/2 = 1
  nums[1] = 2 == 2 ✓ → result = 1, right = 0
  left = 0, right = 0

Iteration 2:
  mid = 0 + (0-0)/2 = 0
  nums[0] = 2 == 2 ✓ → result = 0, right = -1
  left = 0, right = -1

Loop ends → return result = 0

Last search (findLast):
Initialize: left = 0, right = 3, result = -1

Iteration 1:
  mid = 0 + (3-0)/2 = 1
  nums[1] = 2 == 2 ✓ → result = 1, left = 2
  left = 2, right = 3

Iteration 2:
  mid = 2 + (3-2)/2 = 2
  nums[2] = 2 == 2 ✓ → result = 2, left = 3
  left = 3, right = 3

Iteration 3:
  mid = 3 + (3-3)/2 = 3
  nums[3] = 2 == 2 ✓ → result = 3, left = 4
  left = 4, right = 3

Loop ends → return result = 3

Result: [0,3]

Why this works:
- First binary search finds leftmost occurrence by moving left when target found
- Second binary search finds rightmost occurrence by moving right when target found
- Each search is O(log n), total is O(log n)
- Leverages sorted property of array
- Space complexity is constant: O(1)

Why this is optimal:
- Time: O(log n) - optimal for search in sorted array
- Space: O(1) - constant extra space
- Each element is examined at most once per search
- No redundant calculations

Key insights:
- Two binary searches find both boundaries efficiently
- First search uses <= condition for left boundary
- Second search uses >= condition for right boundary
- When target not found, both searches return -1
- Need to handle empty array case

This is perfect solution!
*/
