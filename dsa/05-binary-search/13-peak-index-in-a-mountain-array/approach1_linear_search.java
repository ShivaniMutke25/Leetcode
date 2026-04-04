/**
 * Linear Search Approach - Peak Index in a Mountain Array
 * 
 * Logic:
 * - Scan through array sequentially
 * - Find element greater than both neighbors
 * - Return index of peak element
 * 
 * When to use: Understanding problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(n) - scan through all elements
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return i;
            }
        }
        
        return -1; // Should not reach here for valid input
    }
}

/*
Example Walkthrough:
arr = [0,1,0]

i = 1, arr[1] = 1:
  arr[1] > arr[0] (1 > 0) ✓ AND arr[1] > arr[2] (1 > 0) ✓
  Return 1

Result: 1

Another example:
arr = [0,2,1,0]

i = 1, arr[1] = 2:
  arr[1] > arr[0] (2 > 0) ✓ AND arr[1] > arr[2] (2 > 1) ✓
  Return 1

Result: 1

Another example:
arr = [1,3,5,4,2]

i = 1, arr[1] = 3:
  arr[1] > arr[0] (3 > 1) ✓ BUT arr[1] > arr[2] (3 > 5) ✗
i = 2, arr[2] = 5:
  arr[2] > arr[1] (5 > 3) ✓ AND arr[2] > arr[3] (5 > 4) ✓
  Return 2

Result: 2

Why this is inefficient:
- Scans through all elements sequentially
- Time complexity is linear: O(n)
- For n=10,000, this is acceptable but not optimal
- Doesn't leverage mountain array property

Key limitation: Doesn't use binary search optimization
*/
