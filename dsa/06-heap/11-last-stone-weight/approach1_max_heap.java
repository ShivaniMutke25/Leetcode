/**
 * Max-Heap Approach - Last Stone Weight (OPTIMAL)
 * 
 * Logic:
 * - Use max-heap to always access two heaviest stones
 * - Extract two heaviest stones and smash them
 * - If different, put difference back into heap
 * - Continue until at most one stone remains
 * 
 * When to use: Large n, performance critical, optimal solution
 * When NOT to use: Very small n, memory constraints
 * 
 * Time Complexity: O(n log n) - heap operations
 * Space Complexity: O(n) - heap for stones
 */
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        
        while (maxHeap.size() > 1) {
            int heaviest = maxHeap.poll();
            int secondHeaviest = maxHeap.poll();
            
            if (heaviest != secondHeaviest) {
                maxHeap.offer(heaviest - secondHeaviest);
            }
        }
        
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}

/*
Example Walkthrough:
stones = [2,7,4,1,8,1]

Initialize maxHeap: [8,7,4,2,1,1]

Iteration 1:
  heaviest = 8, secondHeaviest = 7
  8 != 7 → offer(8-7=1)
  maxHeap: [4,2,1,1,1]

Iteration 2:
  heaviest = 4, secondHeaviest = 2
  4 != 2 → offer(4-2=2)
  maxHeap: [2,2,1,1,1]

Iteration 3:
  heaviest = 2, secondHeaviest = 2
  2 == 2 → no offer
  maxHeap: [1,1,1]

Iteration 4:
  heaviest = 1, secondHeaviest = 1
  1 == 1 → no offer
  maxHeap: [1]

Result: maxHeap.peek() = 1

Why this works:
- Max-heap always provides two heaviest stones
- Smash operation follows game rules exactly
- Each iteration reduces total stones
- Final heap size is 0 or 1

Why this is optimal:
- Time: O(n log n) - optimal for this problem
- Space: O(n) - necessary for heap
- Simple and intuitive implementation
- Handles all cases correctly

Key insights:
- Max-heap gives O(log n) access to heaviest stones
- Game simulation is straightforward
- Each smash reduces complexity
- Final result is remaining stone or 0

This is perfect solution!
*/
