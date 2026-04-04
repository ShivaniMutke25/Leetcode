/**
 * Brute Force Approach - Minimum Days to Make m Bouquets
 * 
 * Logic:
 * - Try all possible days from min(bloomDay) to max(bloomDay)
 * - For each day, check if we can make m bouquets
 * - Return minimum feasible day
 * 
 * When to use: Understanding problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(n * max) - try all days, check each day
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }
        
        int minDay = Integer.MAX_VALUE, maxDay = Integer.MIN_VALUE;
        
        for (int day : bloomDay) {
            minDay = Math.min(minDay, day);
            maxDay = Math.max(maxDay, day);
        }
        
        for (int day = minDay; day <= maxDay; day++) {
            if (canMakeBouquets(bloomDay, m, k, day)) {
                return day;
            }
        }
        
        return -1;
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

minDay = 1, maxDay = 10

Try day = 1:
  canMakeBouquets(3, 1, 1):
    bouquets = 0, consecutive = 0
    i = 0, bloomDay[0] = 1 <= 1 → consecutive = 1, bouquets = 1, consecutive = 0
    i = 1, bloomDay[1] = 10 > 1 → consecutive = 0
    i = 2, bloomDay[2] = 3 > 1 → consecutive = 0
    i = 3, bloomDay[3] = 10 > 1 → consecutive = 0
    i = 4, bloomDay[4] = 2 > 1 → consecutive = 0
    bouquets = 1 < m=3 → return false

Try day = 2:
  canMakeBouquets(3, 1, 2):
    bouquets = 0, consecutive = 0
    i = 0, bloomDay[0] = 1 <= 2 → consecutive = 1, bouquets = 1, consecutive = 0
    i = 1, bloomDay[1] = 10 > 2 → consecutive = 0
    i = 2, bloomDay[2] = 3 > 2 → consecutive = 0
    i = 3, bloomDay[3] = 10 > 2 → consecutive = 0
    i = 4, bloomDay[4] = 2 <= 2 → consecutive = 1, bouquets = 2, consecutive = 0
    bouquets = 2 < m=3 → return false

Try day = 3:
  canMakeBouquets(3, 1, 3):
    bouquets = 0, consecutive = 0
    i = 0, bloomDay[0] = 1 <= 3 → consecutive = 1, bouquets = 1, consecutive = 0
    i = 1, bloomDay[1] = 10 > 3 → consecutive = 0
    i = 2, bloomDay[2] = 3 <= 3 → consecutive = 1, bouquets = 2, consecutive = 0
    i = 3, bloomDay[3] = 10 > 3 → consecutive = 0
    i = 4, bloomDay[4] = 2 <= 3 → consecutive = 1, bouquets = 3, consecutive = 0
    bouquets = 3 >= m=3 → return true

Result: 3

Why this is inefficient:
- Tries all possible days from min to max
- Time complexity is O(n * max) - very slow for large inputs
- For max=10^9, this is completely impractical
- Doesn't use binary search optimization

Key limitation: Doesn't use binary search to find optimal day
*/
