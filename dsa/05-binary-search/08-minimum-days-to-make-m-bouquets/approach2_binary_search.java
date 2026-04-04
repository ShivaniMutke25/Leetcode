/**
 * Binary Search Approach - Minimum Days to Make m Bouquets (OPTIMAL)
 * 
 * Logic:
 * - Use binary search on possible days
 * - For each day, check if we can make m bouquets
 * - If possible, try fewer days
 * - If not possible, try more days
 * - Return minimum feasible day
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n log max) - log max for binary search, n for feasibility check
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }
        
        int left = 0, right = 0;
        
        // Calculate bounds
        for (int day : bloomDay) {
            left = Math.min(left, day); // Minimum day
            right = Math.max(right, day); // Maximum day
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canMakeBouquets(bloomDay, m, k, mid)) {
                right = mid; // Try fewer days
            } else {
                left = mid + 1; // Try more days
            }
        }
        
        return left;
    }
    
    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0, consecutive = 0;
        
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                consecutive++;
                if (consecutive == k) {
                    bouquets++;
                    consecutive = 0;
                }
            } else {
                consecutive = 0;
            }
        }
        
        return bouquets >= m;
    }
}

/*
Example Walkthrough:
bloomDay = [1,10,3,10,2], m = 3, k = 1

Initialize: left = 1 (min day), right = 10 (max day)

Iteration 1:
  mid = 1 + (10-1)/2 = 5
  canMakeBouquets(3, 1, 5):
    bouquets = 0, consecutive = 0
    i = 0, bloomDay[0] = 1 <= 5 → consecutive = 1, bouquets = 1, consecutive = 0
    i = 1, bloomDay[1] = 10 > 5 → consecutive = 0
    i = 2, bloomDay[2] = 3 <= 5 → consecutive = 1, bouquets = 2, consecutive = 0
    i = 3, bloomDay[3] = 10 > 5 → consecutive = 0
    i = 4, bloomDay[4] = 2 <= 5 → consecutive = 1, bouquets = 3, consecutive = 0
    bouquets = 3 >= m=3 → return true
  Feasible → right = 5
  left = 1, right = 5

Iteration 2:
  mid = 1 + (5-1)/2 = 3
  canMakeBouquets(3, 1, 3):
    bouquets = 0, consecutive = 0
    i = 0, bloomDay[0] = 1 <= 3 → consecutive = 1, bouquets = 1, consecutive = 0
    i = 1, bloomDay[1] = 10 > 3 → consecutive = 0
    i = 2, bloomDay[2] = 3 <= 3 → consecutive = 1, bouquets = 2, consecutive = 0
    i = 3, bloomDay[3] = 10 > 3 → consecutive = 0
    i = 4, bloomDay[4] = 2 <= 3 → consecutive = 1, bouquets = 3, consecutive = 0
    bouquets = 3 >= m=3 → return true
  Feasible → right = 3
  left = 1, right = 3

Iteration 3:
  mid = 1 + (3-1)/2 = 2
  canMakeBouquets(3, 1, 2):
    bouquets = 0, consecutive = 0
    i = 0, bloomDay[0] = 1 <= 2 → consecutive = 1, bouquets = 1, consecutive = 0
    i = 1, bloomDay[1] = 10 > 2 → consecutive = 0
    i = 2, bloomDay[2] = 3 > 2 → consecutive = 0
    i = 3, bloomDay[3] = 10 > 2 → consecutive = 0
    i = 4, bloomDay[4] = 2 <= 2 → consecutive = 1, bouquets = 2, consecutive = 0
    bouquets = 2 < m=3 → return false
  Not feasible → left = 3
  left = 3, right = 3

Loop ends → return left = 3

Result: 3

Why this works:
- Binary search on answer space (possible days)
- Helper function checks if m bouquets can be made
- Greedy approach: count consecutive bloomed flowers
- Each iteration eliminates half of remaining days
- Time complexity is O(n log max) - optimal for this problem
- Space complexity is O(1) - constant extra space

Why this is optimal:
- Time: O(n log max) - optimal for constrained optimization problems
- Space: O(1) - constant extra space
- Each day is checked at most once
- No redundant calculations

Key insights:
- Binary search on answer space is common pattern
- Need helper function to check feasibility
- Greedy approach works for this problem
- When day is feasible, try fewer days
- When day is not feasible, try more days

This is perfect solution!
*/
