/**
 * Sort by Distance Approach - K Closest Points to Origin
 * 
 * Logic:
 * - Calculate distance for each point
 * - Sort points by distance
 * - Return first k points
 * 
 * When to use: Simple implementation, moderate input size
 * When NOT to use: Large n, multiple queries
 * 
 * Time Complexity: O(n log n) - sorting
 * Space Complexity: O(1) - in-place sorting
 */
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Sort points by distance from origin
        Arrays.sort(points, (a, b) -> {
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];
            return distA - distB;
        });
        
        // Return first k points
        return Arrays.copyOfRange(points, 0, k);
    }
}

/*
Example Walkthrough:
points = [[1,3],[-2,2]], k = 1

Calculate distances:
[1,3]: 1² + 3² = 1 + 9 = 10
[-2,2]: (-2)² + 2² = 4 + 4 = 8

Sort by distance: [[-2,2],[1,3]]

Return first 1: [[-2,2]]

Result: [[-2,2]]

Another example:
points = [[3,3],[5,-1],[-2,4]], k = 2

Calculate distances:
[3,3]: 3² + 3² = 9 + 9 = 18
[5,-1]: 5² + (-1)² = 25 + 1 = 26
[-2,4]: (-2)² + 4² = 4 + 16 = 20

Sort by distance: [[3,3],[-2,4],[5,-1]]

Return first 2: [[3,3],[-2,4]]

Result: [[3,3],[-2,4]]

Why this works:
- Sorting puts points in order by distance
- First k points are k closest to origin
- Using squared distance avoids sqrt calculation
- Simple to implement and understand

Why this is not optimal:
- Time complexity is O(n log n) - sorting all points
- For large n, sorting is expensive
- We only need k points, not full sort
- Space is O(1) but time is high

Key limitation: Sorting all points when we only need k closest
*/
