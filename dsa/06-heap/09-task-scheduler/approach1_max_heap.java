/**
 * Max-Heap Approach - Task Scheduler (OPTIMAL)
 * 
 * Logic:
 * - Count task frequencies
 * - Use max-heap to prioritize most frequent tasks
 * - Use queue to track tasks in cooling period
 * - Schedule tasks while respecting cooling period
 * 
 * When to use: Large n, performance critical, optimal solution
 * When NOT to use: Very small n, memory constraints
 * 
 * Time Complexity: O(n log n) - heap operations
 * Space Complexity: O(1) - fixed alphabet size
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        
        // Count task frequencies
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        
        // Max-heap for most frequent tasks
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int count : freq) {
            if (count > 0) {
                maxHeap.offer(count);
            }
        }
        
        int time = 0;
        Queue<int[]> coolDown = new LinkedList<>(); // [count, availableTime]
        
        while (!maxHeap.isEmpty() || !coolDown.isEmpty()) {
            // Check if any task is ready from cooling
            if (!coolDown.isEmpty() && coolDown.peek()[1] <= time) {
                int[] ready = coolDown.poll();
                maxHeap.offer(ready[0]);
            }
            
            if (!maxHeap.isEmpty()) {
                int count = maxHeap.poll() - 1;
                if (count > 0) {
                    coolDown.offer(new int[]{count, time + n + 1});
                }
            }
            
            time++;
        }
        
        return time;
    }
}

/*
Example Walkthrough:
tasks = ["A","A","A","B","B","B"], n = 2

Count frequencies: A=3, B=3
Max-heap: [3,3]

Initialize: time = 0, coolDown = []

Time 0:
  maxHeap.poll() = 3 (A)
  count = 2, coolDown.offer([2, 0+2+1=3])
  time = 1

Time 1:
  coolDown.peek()[1] = 3 > 1 → no task ready
  maxHeap.poll() = 3 (B)
  count = 2, coolDown.offer([2, 1+2+1=4])
  time = 2

Time 2:
  coolDown.peek()[1] = 3 > 2 → no task ready
  maxHeap.isEmpty() → idle
  time = 3

Time 3:
  coolDown.peek()[1] = 3 <= 3 → ready = [2], maxHeap.offer(2)
  maxHeap.poll() = 2 (A)
  count = 1, coolDown.offer([1, 3+2+1=6])
  time = 4

Continue until all tasks complete...
Final time = 8

Result: 8

Why this works:
- Max-heap always processes most frequent available task
- Queue tracks tasks in cooling period
- Cooling period enforced by time check
- Continues until all tasks are completed

Why this is optimal:
- Time: O(n log n) - optimal for this problem
- Space: O(1) - fixed alphabet size
- Handles all cooling scenarios correctly
- Minimizes total execution time

Key insights:
- Most frequent tasks should be scheduled first
- Cooling period enforced through queue
- Idle time handled automatically
- Fixed alphabet size gives O(1) space

This is perfect solution!
*/
