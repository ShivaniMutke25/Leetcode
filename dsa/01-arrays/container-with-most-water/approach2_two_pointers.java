/**
 * Two Pointers Approach - Container With Most Water (OPTIMAL)
 * 
 * Logic:
 * - Start with left pointer at start, right pointer at end
 * - Calculate area with current pair
 * - Move the pointer pointing to shorter line inward
 * - Reason: Moving the taller line can't increase height, only reduces width
 * 
 * Key insight: The optimal solution must include one of the current lines
 * 
 * When to use: Always - this is the optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - single pass with two pointers
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            // Current width and height
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int area = width * currentHeight;
            
            // Update maximum area
            maxArea = Math.max(maxArea, area);
            
            // Move the pointer pointing to shorter line
            // Why? Because only by moving the shorter line can we potentially
            // find a taller line that might give us more area
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}

/*
Example Walkthrough:
height = [1,8,6,2,5,4,8,3,7]

Initial: left=0(1), right=8(7)
  - width=8, height=min(1,7)=1, area=8
  - Move left (1 < 7)

left=1(8), right=8(7)
  - width=7, height=min(8,7)=7, area=49 ⭐ (BEST)
  - Move right (8 > 7)

left=1(8), right=7(3)
  - width=6, height=min(8,3)=3, area=18
  - Move right (8 > 3)

left=1(8), right=6(8)
  - width=5, height=min(8,8)=8, area=40
  - Move either (equal heights), let's move right

left=1(8), right=5(4)
  - width=4, height=min(8,4)=4, area=16
  - Move right (8 > 4)

left=1(8), right=4(5)
  - width=3, height=min(8,5)=5, area=15
  - Move right (8 > 5)

left=1(8), right=3(2)
  - width=2, height=min(8,2)=2, area=4
  - Move right (8 > 2)

left=1(8), right=2(6)
  - width=1, height=min(8,6)=6, area=6
  - Move right (8 > 6)

Now left >= right, done!

Result: maxArea = 49

Why this works:
- We eliminate impossible pairs systematically
- If we have lines A(left) and B(right) with A < B:
  * Any pair (A, C) where C is between A and B will have smaller width
  * Since A is the limiting height, we can't do better with A
  * So we move past A to find potentially better pairs
- This guarantees we consider all potentially optimal pairs

Efficiency: O(n) time, O(1) space - optimal!
*/
