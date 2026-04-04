/**
 * Simulation Approach - Task Scheduler
 * 
 * Logic:
 * - Count task frequencies
 * - Simulate task execution with cooling period
 * - Use array to track next available time for each task
 * 
 * When to use: Simple implementation, understanding problem
 * When NOT to use: Large n, performance critical
 * 
 * Time Complexity: O(n log n) - sorting
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
        
        // Sort frequencies in descending order
        Arrays.sort(freq);
        
        int maxFreq = freq[25];
        int idleSlots = (maxFreq - 1) * n;
        
        // Fill idle slots with other tasks
        for (int i = 24; i >= 0 && freq[i] > 0; i--) {
            idleSlots -= Math.min(freq[i], maxFreq - 1);
        }
        
        idleSlots = Math.max(0, idleSlots);
        return tasks.length + idleSlots;
    }
}

/*
Example Walkthrough:
tasks = ["A","A","A","B","B","B"], n = 2

Count frequencies: A=3, B=3
Sort: [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,3]

maxFreq = 3
idleSlots = (3-1) * 2 = 4

Fill with other tasks:
freq[24] = 3: idleSlots -= Math.min(3, 2) = 4-2 = 2

idleSlots = Math.max(0, 2) = 2
Result = 6 + 2 = 8

Why this works:
- Most frequent task determines minimum schedule length
- Idle slots needed between most frequent tasks
- Other tasks fill idle slots
- Remaining idle slots add to total time

Why this is not optimal:
- Mathematical approach can be complex to understand
- Edge cases can be tricky
- Heap approach is more intuitive

Key limitation: Complex mathematical reasoning vs intuitive scheduling
*/
