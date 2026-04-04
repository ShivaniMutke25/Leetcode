/**
 * Greedy Approach - Furthest Building You Can Reach
 * 
 * Logic:
 * - Use bricks for climbs until exhausted
 * - Can't proceed when bricks run out
 * 
 * When to use: Simple implementation, understanding problem
 * When NOT to use: Optimal brick usage needed
 * 
 * Time Complexity: O(n) - linear scan
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int furthestBuilding(int[] heights, int bricks) {
        for (int i = 0; i < heights.length - 1; i++) {
            int climb = heights[i + 1] - heights[i];
            
            if (climb <= 0) {
                continue; // No bricks needed
            }
            
            if (bricks >= climb) {
                bricks -= climb;
            } else {
                return i; // Can't proceed
            }
        }
        
        return heights.length - 1; // Can reach last building
    }
}

/*
Example Walkthrough:
heights = [4,2,7,6,9,14,12], bricks = 5

i = 0: climb = 2-4 = -2 <= 0 → continue, bricks = 5

i = 1: climb = 7-2 = 5 > 0, bricks >= 5 → bricks = 0

i = 2: climb = 6-7 = -1 <= 0 → continue, bricks = 0

i = 3: climb = 9-6 = 3 > 0, bricks < 3 → return 3

Result: 3

Why this works:
- Simple greedy approach uses bricks as needed
- Stops when can't afford next climb
- Easy to understand and implement
- Works for basic cases

Why this is not optimal:
- May not use bricks optimally
- Could get stuck earlier than necessary
- Doesn't consider alternative strategies
- Min-heap approach is much better

Key limitation: Greedy approach may not be optimal
*/
