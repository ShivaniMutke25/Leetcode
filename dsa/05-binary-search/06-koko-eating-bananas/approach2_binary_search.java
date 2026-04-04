/**
 * Binary Search Approach - Koko Eating Bananas (OPTIMAL)
 * 
 * Logic:
 * - Use binary search on possible eating speeds
 * - For each speed, check if Koko can eat all bananas in h hours
 * - If possible, try slower speeds
 * - If not possible, try faster speeds
 * - Return minimum feasible speed
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n log max) - log max for binary search, n for feasibility check
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        
        // Find maximum pile size as upper bound
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canEatAll(piles, h, mid)) {
                right = mid; // Try slower speeds
            } else {
                left = mid + 1; // Try faster speeds
            }
        }
        
        return left;
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

Initialize: left = 1, right = 11

Iteration 1:
  mid = 1 + (11-1)/2 = 6
  canEatAll(8, 6):
    hoursNeeded = (3+6-1)/6 + (6+6-1)/6 + (7+6-1)/6 + (11+6-1)/6 = 1+1+2+2 = 6
    6 <= 8 ✓ → right = 6
  left = 1, right = 6

Iteration 2:
  mid = 1 + (6-1)/2 = 3
  canEatAll(8, 3):
    hoursNeeded = (3+3-1)/3 + (6+3-1)/3 + (7+3-1)/3 + (11+3-1)/3 = 1+2+3+4 = 10
    10 > 8 ✗ → left = 4
  left = 4, right = 6

Iteration 3:
  mid = 4 + (6-4)/2 = 5
  canEatAll(8, 5):
    hoursNeeded = (3+5-1)/5 + (6+5-1)/5 + (7+5-1)/5 + (11+5-1)/5 = 1+2+2+3 = 8
    8 <= 8 ✓ → right = 5
  left = 4, right = 5

Iteration 4:
  mid = 4 + (5-4)/2 = 4
  canEatAll(8, 4):
    hoursNeeded = (3+4-1)/4 + (6+4-1)/4 + (7+4-1)/4 + (11+4-1)/4 = 1+2+2+3 = 8
    8 <= 8 ✓ → right = 4
  left = 4, right = 4

Loop ends → return left = 4

Result: 4

Another example:
piles = [30,11,23,4,20], h = 5

Initialize: left = 1, right = 30

Iteration 1:
  mid = 1 + (30-1)/2 = 15
  canEatAll(5, 15):
    hoursNeeded = (30+15-1)/15 + (11+15-1)/15 + (23+15-1)/15 + (4+15-1)/15 + (20+15-1)/15 = 2+1+2+1+2 = 8
    8 > 5 ✗ → left = 16
  left = 16, right = 30

Iteration 2:
  mid = 16 + (30-16)/2 = 23
  canEatAll(5, 23):
    hoursNeeded = (30+23-1)/23 + (11+23-1)/23 + (23+23-1)/23 + (4+23-1)/23 + (20+23-1)/23 = 2+1+1+1+1 = 6
    6 > 5 ✗ → left = 24
  left = 24, right = 30

Iteration 3:
  mid = 24 + (30-24)/2 = 27
  canEatAll(5, 27):
    hoursNeeded = (30+27-1)/27 + (11+27-1)/27 + (23+27-1)/27 + (4+27-1)/27 + (20+27-1)/27 = 2+1+1+1+1 = 6
    6 > 5 ✗ → left = 28
  left = 28, right = 30

Iteration 4:
  mid = 28 + (30-28)/2 = 29
  canEatAll(5, 29):
    hoursNeeded = (30+29-1)/29 + (11+29-1)/29 + (23+29-1)/29 + (4+29-1)/29 + (20+29-1)/29 = 2+1+1+1+1 = 6
    6 > 5 ✗ → left = 30
  left = 30, right = 30

Loop ends → return left = 30

Result: 30

Why this works:
- Binary search on answer space (possible eating speeds)
- Helper function checks if speed is feasible
- Each iteration eliminates half of remaining speeds
- Time complexity is O(n log max) - optimal for this problem
- Space complexity is constant: O(1)

Why this is optimal:
- Time: O(n log max) - optimal for constrained optimization problems
- Space: O(1) - constant extra space
- Each speed is checked at most once
- No redundant calculations

Key insights:
- Binary search on answer space is common pattern
- Need helper function to check feasibility
- Ceiling division: (pile + speed - 1) / speed
- When speed is feasible, try slower speeds
- When speed is not feasible, try faster speeds

This is perfect solution!
*/
