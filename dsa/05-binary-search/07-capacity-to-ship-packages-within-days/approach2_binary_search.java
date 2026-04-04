/**
 * Binary Search Approach - Capacity to Ship Packages Within D Days (OPTIMAL)
 * 
 * Logic:
 * - Use binary search on possible ship capacities
 * - For each capacity, check if we can ship all packages in D days
 * - If possible, try smaller capacities
 * - If not possible, try larger capacities
 * - Return minimum feasible capacity
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n log max) - log max for binary search, n for feasibility check
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        
        // Calculate bounds
        for (int weight : weights) {
            left = Math.max(left, weight); // Minimum capacity
            right += weight; // Maximum capacity
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canShipInDays(weights, D, mid)) {
                right = mid; // Try smaller capacities
            } else {
                left = mid + 1; // Try larger capacities
            }
        }
        
        return left;
    }
    
    private boolean canShipInDays(int[] weights, int D, int capacity) {
        int days = 1, currentWeight = 0;
        
        for (int weight : weights) {
            if (currentWeight + weight > capacity) {
                days++;
                currentWeight = weight;
            } else {
                currentWeight += weight;
            }
        }
        
        return days <= D;
    }
}

/*
Example Walkthrough:
weights = [1,2,3,4,5,6,7,8,9,10], D = 5

Initialize: left = 10 (max weight), right = 55 (total weight)

Iteration 1:
  mid = 10 + (55-10)/2 = 32
  canShipInDays(5, 32):
    days = 1, currentWeight = 0
    weight = 1: currentWeight + 1 = 1 <= 32 → currentWeight = 1
    weight = 2: currentWeight + 2 = 3 <= 32 → currentWeight = 3
    weight = 3: currentWeight + 3 = 6 <= 32 → currentWeight = 6
    weight = 4: currentWeight + 4 = 10 <= 32 → currentWeight = 10
    weight = 5: currentWeight + 5 = 15 <= 32 → currentWeight = 15
    weight = 6: currentWeight + 6 = 21 <= 32 → currentWeight = 21
    weight = 7: currentWeight + 7 = 28 <= 32 → currentWeight = 28
    weight = 8: currentWeight + 8 = 36 > 32 → days = 2, currentWeight = 8
    weight = 9: currentWeight + 9 = 17 <= 32 → currentWeight = 17
    weight = 10: currentWeight + 10 = 27 <= 32 → currentWeight = 27
    days = 2 <= D=5 → return true
  Feasible → right = 32
  left = 10, right = 32

Iteration 2:
  mid = 10 + (32-10)/2 = 21
  canShipInDays(5, 21):
    days = 1, currentWeight = 0
    weight = 1: currentWeight + 1 = 1 <= 21 → currentWeight = 1
    weight = 2: currentWeight + 2 = 3 <= 21 → currentWeight = 3
    weight = 3: currentWeight + 3 = 6 <= 21 → currentWeight = 6
    weight = 4: currentWeight + 4 = 10 <= 21 → currentWeight = 10
    weight = 5: currentWeight + 5 = 15 <= 21 → currentWeight = 15
    weight = 6: currentWeight + 6 = 21 <= 21 → currentWeight = 21
    weight = 7: currentWeight + 7 = 28 > 21 → days = 2, currentWeight = 7
    weight = 8: currentWeight + 8 = 15 <= 21 → currentWeight = 15
    weight = 9: currentWeight + 9 = 24 > 21 → days = 3, currentWeight = 9
    weight = 10: currentWeight + 10 = 19 <= 21 → currentWeight = 19
    days = 3 <= D=5 → return true
  Feasible → right = 21
  left = 10, right = 21

Iteration 3:
  mid = 10 + (21-10)/2 = 15
  canShipInDays(5, 15):
    days = 1, currentWeight = 0
    weight = 1: currentWeight + 1 = 1 <= 15 → currentWeight = 1
    weight = 2: currentWeight + 2 = 3 <= 15 → currentWeight = 3
    weight = 3: currentWeight + 3 = 6 <= 15 → currentWeight = 6
    weight = 4: currentWeight + 4 = 10 <= 15 → currentWeight = 10
    weight = 5: currentWeight + 5 = 15 <= 15 → currentWeight = 15
    weight = 6: currentWeight + 6 = 21 > 15 → days = 2, currentWeight = 6
    weight = 7: currentWeight + 7 = 13 <= 15 → currentWeight = 13
    weight = 8: currentWeight + 8 = 21 > 15 → days = 3, currentWeight = 8
    weight = 9: currentWeight + 9 = 17 > 15 → days = 4, currentWeight = 9
    weight = 10: currentWeight + 10 = 19 > 15 → days = 5, currentWeight = 10
    days = 5 <= D=5 → return true
  Feasible → right = 15
  left = 10, right = 15

Iteration 4:
  mid = 10 + (15-10)/2 = 12
  canShipInDays(5, 12):
    days = 1, currentWeight = 0
    weight = 1: currentWeight + 1 = 1 <= 12 → currentWeight = 1
    weight = 2: currentWeight + 2 = 3 <= 12 → currentWeight = 3
    weight = 3: currentWeight + 3 = 6 <= 12 → currentWeight = 6
    weight = 4: currentWeight + 4 = 10 <= 12 → currentWeight = 10
    weight = 5: currentWeight + 5 = 15 > 12 → days = 2, currentWeight = 5
    weight = 6: currentWeight + 6 = 11 <= 12 → currentWeight = 11
    weight = 7: currentWeight + 7 = 18 > 12 → days = 3, currentWeight = 7
    weight = 8: currentWeight + 8 = 15 > 12 → days = 4, currentWeight = 8
    weight = 9: currentWeight + 9 = 17 > 12 → days = 5, currentWeight = 9
    weight = 10: currentWeight + 10 = 19 > 12 → days = 6, currentWeight = 10
    days = 6 > D=5 → return false
  Not feasible → left = 13
  left = 13, right = 15

Iteration 5:
  mid = 13 + (15-13)/2 = 14
  canShipInDays(5, 14):
    days = 6 > D=5 → return false
  Not feasible → left = 15
  left = 15, right = 15

Loop ends → return left = 15

Result: 15

Why this works:
- Binary search on answer space (possible ship capacities)
- Helper function checks if capacity is feasible
- Greedy approach: if currentWeight + weight > capacity, start new day
- Each iteration eliminates half of remaining capacities
- Time complexity is O(n log max) - optimal for this problem
- Space complexity is O(1) - constant extra space

Why this is optimal:
- Time: O(n log max) - optimal for constrained optimization problems
- Space: O(1) - constant extra space
- Each capacity is checked at most once
- No redundant calculations

Key insights:
- Binary search on answer space is common pattern
- Need helper function to check feasibility
- Greedy approach works for this problem
- When capacity is feasible, try smaller capacities
- When capacity is not feasible, try larger capacities

This is perfect solution!
*/
