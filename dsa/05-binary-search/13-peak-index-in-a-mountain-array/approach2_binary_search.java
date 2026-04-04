/**
 * Binary Search Approach - Peak Index in a Mountain Array (OPTIMAL)
 * 
 * Logic:
 * - Use binary search with left and right pointers
 * - Compare mid with right neighbor
 * - If arr[mid] < arr[mid+1], peak is on right
 * - If arr[mid] > arr[mid+1], peak is on left
 * - When left == right, we found peak
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(log n) - each iteration eliminates half
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] < arr[mid + 1]) {
                // Peak is on the right side
                left = mid + 1;
            } else {
                // Peak is on the left side (including mid)
                right = mid;
            }
        }
        
        return left; // left == right at this point
    }
}

/*
Example Walkthrough:
arr = [0,1,0]

Initialize: left = 0, right = 2

Iteration 1:
  mid = 0 + (2-0)/2 = 1
  arr[1] = 1, arr[2] = 0
  arr[1] > arr[2] (1 > 0) → peak is on left (including mid)
  right = 1
  left = 0, right = 1

Iteration 2:
  mid = 0 + (1-0)/2 = 0
  arr[0] = 0, arr[1] = 1
  arr[0] < arr[1] (0 < 1) → peak is on right
  left = 1
  left = 1, right = 1

Loop ends → return left = 1

Result: 1

Another example:
arr = [0,2,1,0]

Initialize: left = 0, right = 3

Iteration 1:
  mid = 0 + (3-0)/2 = 1
  arr[1] = 2, arr[2] = 1
  arr[1] > arr[2] (2 > 1) → peak is on left (including mid)
  right = 1
  left = 0, right = 1

Loop ends → return left = 1

Result: 1

Another example:
arr = [1,3,5,4,2]

Initialize: left = 0, right = 4

Iteration 1:
  mid = 0 + (4-0)/2 = 2
  arr[2] = 5, arr[3] = 4
  arr[2] > arr[3] (5 > 4) → peak is on left (including mid)
  right = 2
  left = 0, right = 2

Iteration 2:
  mid = 0 + (2-0)/2 = 1
  arr[1] = 3, arr[2] = 5
  arr[1] < arr[2] (3 < 5) → peak is on right
  left = 2
  left = 2, right = 2

Loop ends → return left = 2

Result: 2

Why this works:
- If arr[mid] < arr[mid+1], there must be a peak on the right side
- If arr[mid] > arr[mid+1], there must be a peak on the left side
- Each iteration eliminates half of the remaining elements
- Time complexity is logarithmic: O(log n)
- Space complexity is constant: O(1)

Why this is optimal:
- Time: O(log n) - optimal for peak finding
- Space: O(1) - constant extra space
- Each element is examined at most once
- No redundant calculations

Key insights:
- Binary search can find peak without checking all elements
- Compare mid with right neighbor to determine search direction
- When left == right, we've found the peak
- Mountain array has exactly one peak

This is perfect solution!
*/
