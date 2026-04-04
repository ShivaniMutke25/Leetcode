/**
 * Sliding Window Approach - Fruit Into Baskets (OPTIMAL)
 * 
 * Logic:
 * - Use sliding window with two pointers: left and right
 * - Maintain frequency map of fruit types in current window
 * - Ensure at most 2 distinct fruit types in window
 * - When window has >2 types, shrink from left until valid
 * - Track maximum window size found
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(1) - constant space (at most 3 fruit types)
 */
class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> fruitCount = new HashMap<>();
        int left = 0, maxLength = 0;
        
        for (int right = 0; right < fruits.length; right++) {
            // Add current fruit to window
            fruitCount.put(fruits[right], fruitCount.getOrDefault(fruits[right], 0) + 1);
            
            // Shrink window while we have more than 2 fruit types
            while (fruitCount.size() > 2) {
                int leftFruit = fruits[left];
                fruitCount.put(leftFruit, fruitCount.get(leftFruit) - 1);
                
                if (fruitCount.get(leftFruit) == 0) {
                    fruitCount.remove(leftFruit);
                }
                
                left++;
            }
            
            // Update maximum window size
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}

/*
Example Walkthrough:
fruits = [1,2,1]

Initialize: fruitCount = {}, left = 0, maxLength = 0

right = 0, fruits[0] = 1:
  fruitCount = {1:1}
  fruitCount.size() = 1 <= 2 ✓
  maxLength = max(0, 0-0+1) = 1

right = 1, fruits[1] = 2:
  fruitCount = {1:1, 2:1}
  fruitCount.size() = 2 <= 2 ✓
  maxLength = max(1, 1-0+1) = 2

right = 2, fruits[2] = 1:
  fruitCount = {1:2, 2:1}
  fruitCount.size() = 2 <= 2 ✓
  maxLength = max(2, 2-0+1) = 3

Result: 3

Another example:
fruits = [0,1,2,2]

Initialize: fruitCount = {}, left = 0, maxLength = 0

right = 0, fruits[0] = 0:
  fruitCount = {0:1}
  fruitCount.size() = 1 <= 2 ✓
  maxLength = 1

right = 1, fruits[1] = 1:
  fruitCount = {0:1, 1:1}
  fruitCount.size() = 2 <= 2 ✓
  maxLength = 2

right = 2, fruits[2] = 2:
  fruitCount = {0:1, 1:1, 2:1}
  fruitCount.size() = 3 > 2 → shrink window
  
  leftFruit = fruits[0] = 0
  fruitCount = {0:0, 1:1, 2:1} → remove 0
  fruitCount = {1:1, 2:1}
  left = 1
  
  fruitCount.size() = 2 <= 2 ✓
  maxLength = max(2, 2-1+1) = 2

right = 3, fruits[3] = 2:
  fruitCount = {1:1, 2:2}
  fruitCount.size() = 2 <= 2 ✓
  maxLength = max(2, 3-1+1) = 3

Result: 3

Another example:
fruits = [3,3,3,1,2,1,1,2,3,3,4]

Initialize: fruitCount = {}, left = 0, maxLength = 0

right = 0-2: fruits = [3,3,3]
  fruitCount = {3:3}, size = 1 <= 2 ✓
  maxLength = 3

right = 3: fruits[3] = 1
  fruitCount = {3:3, 1:1}, size = 2 <= 2 ✓
  maxLength = 4

right = 4: fruits[4] = 2
  fruitCount = {3:3, 1:1, 2:1}, size = 3 > 2 → shrink
  
  Remove fruits[0]=3: fruitCount = {3:2, 1:1, 2:1}, size = 3 > 2
  left = 1
  
  Remove fruits[1]=3: fruitCount = {3:1, 1:1, 2:1}, size = 3 > 2
  left = 2
  
  Remove fruits[2]=3: fruitCount = {3:0, 1:1, 2:1} → remove 3
  fruitCount = {1:1, 2:1}, size = 2 <= 2
  left = 3
  
  maxLength = max(4, 4-3+1) = 2

Continue expanding...
Eventually find maximum window [1,2,1,1,2] of length 5

Result: 5

Why this works:
- Sliding window maintains at most 2 distinct fruit types
- When we have >2 types, we shrink from left until valid
- Each fruit is added and removed at most once
- Maximum window size represents maximum fruits we can collect

Why this is optimal:
- Time: O(n) - single pass, optimal
- Space: O(1) - constant space (at most 3 fruit types in map)
- No redundant calculations
- Efficient window management
- Handles all edge cases

Key insights:
- This is "at most K distinct elements" problem with K=2
- HashMap tracks fruit frequencies in current window
- Shrinking while invalid ensures window always has ≤2 types
- Each element processed exactly twice (added and removed)

This is the perfect solution!
*/
