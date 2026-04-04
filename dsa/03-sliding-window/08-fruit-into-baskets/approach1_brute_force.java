/**
 * Brute Force Approach - Fruit Into Baskets
 * 
 * Logic:
 * - Check all possible starting positions
 * - For each start, expand while maintaining at most 2 fruit types
 * - Track maximum length found
 * 
 * When to use: Understanding the problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(n²) - O(n²) starting positions, each expansion O(n)
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int totalFruit(int[] fruits) {
        int maxLength = 0;
        
        // Check all possible starting positions
        for (int i = 0; i < fruits.length; i++) {
            Set<Integer> fruitTypes = new HashSet<>();
            int currentLength = 0;
            
            // Expand from starting position i
            for (int j = i; j < fruits.length; j++) {
                fruitTypes.add(fruits[j]);
                
                // If more than 2 fruit types, stop expanding
                if (fruitTypes.size() > 2) {
                    break;
                }
                
                currentLength++;
            }
            
            maxLength = Math.max(maxLength, currentLength);
        }
        
        return maxLength;
    }
}

/*
Example Walkthrough:
fruits = [1,2,1]

i = 0:
  j = 0: fruitTypes = {1}, size = 1 <= 2, currentLength = 1
  j = 1: fruitTypes = {1,2}, size = 2 <= 2, currentLength = 2
  j = 2: fruitTypes = {1,2}, size = 2 <= 2, currentLength = 3
  maxLength = max(0, 3) = 3

i = 1:
  j = 1: fruitTypes = {2}, size = 1 <= 2, currentLength = 1
  j = 2: fruitTypes = {2,1}, size = 2 <= 2, currentLength = 2
  maxLength = max(3, 2) = 3

i = 2:
  j = 2: fruitTypes = {1}, size = 1 <= 2, currentLength = 1
  maxLength = max(3, 1) = 3

Result: 3

Another example:
fruits = [0,1,2,2]

i = 0:
  j = 0: fruitTypes = {0}, size = 1 <= 2, currentLength = 1
  j = 1: fruitTypes = {0,1}, size = 2 <= 2, currentLength = 2
  j = 2: fruitTypes = {0,1,2}, size = 3 > 2 → break
  maxLength = 2

i = 1:
  j = 1: fruitTypes = {1}, size = 1 <= 2, currentLength = 1
  j = 2: fruitTypes = {1,2}, size = 2 <= 2, currentLength = 2
  j = 3: fruitTypes = {1,2}, size = 2 <= 2, currentLength = 3
  maxLength = 3

i = 2:
  j = 2: fruitTypes = {2}, size = 1 <= 2, currentLength = 1
  j = 3: fruitTypes = {2}, size = 1 <= 2, currentLength = 2
  maxLength = 3

i = 3:
  j = 3: fruitTypes = {2}, size = 1 <= 2, currentLength = 1
  maxLength = 3

Result: 3

Why this is inefficient:
- For each starting position, we potentially scan to the end
- Number of starting positions: O(n)
- Each expansion: O(n) in worst case
- Total: O(n²) time complexity
- For n=100,000, this is completely impractical

Key limitation: No optimization to avoid redundant checking of overlapping subarrays
*/
