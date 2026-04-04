/**
 * Brute Force Approach - Capacity to Ship Packages Within D Days
 * 
 * Logic:
 * - Try all possible capacities from max(weights) to sum(weights)
 * - For each capacity, check if we can ship all packages in D days
 * - Return minimum feasible capacity
 * 
 * When to use: Understanding problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(n * max) - try all capacities, check each capacity
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int maxWeight = 0, totalWeight = 0;
        
        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }
        
        for (int capacity = maxWeight; capacity <= totalWeight; capacity++) {
            if (canShipInDays(weights, D, capacity)) {
                return capacity;
            }
        }
        
        return totalWeight;
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

maxWeight = 10, totalWeight = 55

Try capacity = 10:
  canShipInDays(5, 10):
    days = 1, currentWeight = 0
    weight = 1: currentWeight + 1 = 1 <= 10 → currentWeight = 1
    weight = 2: currentWeight + 2 = 3 <= 10 → currentWeight = 3
    weight = 3: currentWeight + 3 = 6 <= 10 → currentWeight = 6
    weight = 4: currentWeight + 4 = 10 <= 10 → currentWeight = 10
    weight = 5: currentWeight + 5 = 15 > 10 → days = 2, currentWeight = 5
    weight = 6: currentWeight + 6 = 11 > 10 → days = 3, currentWeight = 6
    weight = 7: currentWeight + 7 = 13 > 10 → days = 4, currentWeight = 7
    weight = 8: currentWeight + 8 = 15 > 10 → days = 5, currentWeight = 8
    weight = 9: currentWeight + 9 = 17 > 10 → days = 6, currentWeight = 9
    weight = 10: currentWeight + 10 = 19 > 10 → days = 7, currentWeight = 10
    days = 7 > D=5 → return false

Try capacity = 15:
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

Result: 15

Why this is inefficient:
- Tries all possible capacities from max to total weight
- Time complexity is O(n * max) - very slow for large inputs
- For max=500, total=250000, this is completely impractical
- Doesn't use binary search optimization

Key limitation: Doesn't use binary search to find optimal capacity
*/
