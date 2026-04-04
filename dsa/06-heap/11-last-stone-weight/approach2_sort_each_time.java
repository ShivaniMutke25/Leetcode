/**
 * Sort Each Time Approach - Last Stone Weight
 * 
 * Logic:
 * - Sort array each iteration
 * - Take two heaviest stones and smash them
 * - If different, add difference back and resort
 * 
 * When to use: Simple implementation, very small n
 * When NOT to use: Large n, performance critical
 * 
 * Time Complexity: O(n² log n) - sorting each iteration
 * Space Complexity: O(1) - in-place sorting
 */
class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> stoneList = new ArrayList<>();
        for (int stone : stones) {
            stoneList.add(stone);
        }
        
        while (stoneList.size() > 1) {
            // Sort to find heaviest stones
            Collections.sort(stoneList);
            
            int heaviest = stoneList.remove(stoneList.size() - 1);
            int secondHeaviest = stoneList.remove(stoneList.size() - 1);
            
            if (heaviest != secondHeaviest) {
                stoneList.add(heaviest - secondHeaviest);
            }
        }
        
        return stoneList.isEmpty() ? 0 : stoneList.get(0);
    }
}

/*
Example Walkthrough:
stones = [2,7,4,1,8,1]

Initialize: stoneList = [2,7,4,1,8,1]

Iteration 1:
  Sort: [1,1,2,4,7,8]
  heaviest = 8, secondHeaviest = 7
  8 != 7 → add(1)
  stoneList = [1,1,2,4,1]

Iteration 2:
  Sort: [1,1,1,2,4]
  heaviest = 4, secondHeaviest = 2
  4 != 2 → add(2)
  stoneList = [1,1,1,2]

Iteration 3:
  Sort: [1,1,1,2]
  heaviest = 2, secondHeaviest = 1
  2 != 1 → add(1)
  stoneList = [1,1,1,1]

Iteration 4:
  Sort: [1,1,1,1]
  heaviest = 1, secondHeaviest = 1
  1 == 1 → no add
  stoneList = [1,1]

Iteration 5:
  Sort: [1,1]
  heaviest = 1, secondHeaviest = 1
  1 == 1 → no add
  stoneList = [1]

Result: 1

Why this works:
- Sorting puts heaviest stones at end
- Smash operation follows game rules
- Each iteration reduces stone count
- Final result is remaining stone or 0

Why this is not optimal:
- Time complexity is O(n² log n) - very slow
- Sorting each iteration is expensive
- For n=30, this could be 900 operations
- Heap approach is much more efficient

Key limitation: Sorting entire array each iteration
*/
