/**
 * Linear Search Approach - Koko Eating Bananas
 * 
 * Logic:
 * - Try all possible speeds from 1 to max(piles)
 * - For each speed, check if Koko can eat all bananas in h hours
 * - Return minimum feasible speed
 * 
 * When to use: Understanding problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(n * max) - try all speeds, check each speed
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed = 0;
        for (int pile : piles) {
            maxSpeed = Math.max(maxSpeed, pile);
        }
        
        for (int speed = 1; speed <= maxSpeed; speed++) {
            if (canEatAll(piles, h, speed)) {
                return speed;
            }
        }
        
        return maxSpeed;
    }
    
    private boolean canEatAll(int[] piles, int h, int speed) {
        int hoursNeeded = 0;
        
        for (int pile : piles) {
            hoursNeeded += (pile + speed - 1) / speed; // Ceiling division
        }
        
        return hoursNeeded <= h;
    }
}

/*
Example Walkthrough:
piles = [3,6,7,11], h = 8

maxSpeed = max(3,6,7,11) = 11

Try speed = 1:
  hoursNeeded = (3+1-1)/1 + (6+1-1)/1 + (7+1-1)/1 + (11+1-1)/1 = 3+6+7+11 = 27
  27 > 8 → not feasible

Try speed = 2:
  hoursNeeded = (3+2-1)/2 + (6+2-1)/2 + (7+2-1)/2 + (11+2-1)/2 = 2+3+4+6 = 15
  15 > 8 → not feasible

Try speed = 3:
  hoursNeeded = (3+3-1)/3 + (6+3-1)/3 + (7+3-1)/3 + (11+3-1)/3 = 1+2+3+4 = 10
  10 > 8 → not feasible

Try speed = 4:
  hoursNeeded = (3+4-1)/4 + (6+4-1)/4 + (7+4-1)/4 + (11+4-1)/4 = 1+2+2+3 = 8
  8 <= 8 ✓ → return 4

Result: 4

Another example:
piles = [30,11,23,4,20], h = 5

maxSpeed = max(30,11,23,4,20) = 30

Try speed = 1 to 29: All not feasible
Try speed = 30:
  hoursNeeded = (30+30-1)/30 + (11+30-1)/30 + (23+30-1)/30 + (4+30-1)/30 + (20+30-1)/30 = 1+1+1+1+1 = 5
  5 <= 5 ✓ → return 30

Result: 30

Why this is inefficient:
- Tries all possible speeds from 1 to max(piles)
- Time complexity is O(n * max) - very slow for large inputs
- For max=10^9, this is completely impractical
- Doesn't use binary search optimization

Key limitation: Doesn't use binary search to find minimum feasible speed
*/
