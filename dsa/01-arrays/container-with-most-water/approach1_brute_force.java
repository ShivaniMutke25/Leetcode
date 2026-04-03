/**
 * Brute Force Approach - Container With Most Water
 * 
 * Logic:
 * - Try every possible pair of lines
 * - Calculate area for each pair: width × min(height[left], height[right])
 * - Track maximum area found
 * 
 * When to use: Educational purposes, understanding the problem
 * When NOT to use: Any realistic input - will TLE for n > 1000
 * 
 * Time Complexity: O(n²) - nested loops checking all pairs
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int n = height.length;
        
        // Try every possible pair of lines
        for (int left = 0; left < n; left++) {
            for (int right = left + 1; right < n; right++) {
                // Width is distance between lines
                int width = right - left;
                // Height is limited by shorter line
                int currentHeight = Math.min(height[left], height[right]);
                // Calculate area
                int area = width * currentHeight;
                // Update maximum
                maxArea = Math.max(maxArea, area);
            }
        }
        
        return maxArea;
    }
}

/*
Example Walkthrough:
height = [1,8,6,2,5,4,8,3,7]

Pairs and their areas:
(0,1): width=1, height=min(1,8)=1, area=1
(0,2): width=2, height=min(1,6)=1, area=2
(0,3): width=3, height=min(1,2)=1, area=3
...
(1,8): width=7, height=min(8,7)=7, area=49 ⭐ (BEST)
(2,8): width=6, height=min(6,7)=6, area=36
(3,8): width=5, height=min(2,7)=2, area=10
...

After checking all 36 pairs, maxArea = 49

Why this is slow:
- For n=100,000, we check ~5 billion pairs
- Each operation is simple, but the count is too high
- This approach doesn't use any problem insights

Key limitation: Doesn't realize that most pairs can't be optimal
*/
