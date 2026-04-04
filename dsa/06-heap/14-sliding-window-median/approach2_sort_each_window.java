/**
 * Sort Each Window Approach - Sliding Window Median
 * 
 * Logic:
 * - For each window, extract elements and sort
 * - Calculate median from sorted window
 * 
 * When to use: Simple implementation, very small n
 * When NOT to use: Large n, performance critical
 * 
 * Time Complexity: O(nk log k) - sorting each window
 * Space Complexity: O(k) - window elements
 */
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        
        for (int i = 0; i <= nums.length - k; i++) {
            int[] window = new int[k];
            System.arraycopy(nums, i, window, 0, k);
            Arrays.sort(window);
            
            if (k % 2 == 1) {
                result[i] = window[k / 2];
            } else {
                result[i] = (window[k / 2 - 1] + window[k / 2]) / 2.0;
            }
        }
        
        return result;
    }
}

/*
Example Walkthrough:
nums = [1,3,-1,-3,5,3,6,7], k = 3

Window 0: [1,3,-1]
Sort: [-1,1,3]
Median: window[1] = 1 → result[0] = 1

Window 1: [3,-1,-3]
Sort: [-3,-1,3]
Median: window[1] = -1 → result[1] = -1

Window 2: [-1,-3,5]
Sort: [-3,-1,5]
Median: window[1] = -1 → result[2] = -1

Continue similarly...

Result: [1,-1,-1,3,5,6]

Why this works:
- Sorting puts window elements in order
- Median is middle element(s) based on odd/even k
- Simple to implement and understand
- Works for any valid input

Why this is not optimal:
- Time complexity is O(nk log k) - very slow
- For n=10^5, k=10^4, this is impractical
- Sorting each window separately is expensive
- Doesn't leverage overlap between windows

Key limitation: Sorting each window independently
*/
