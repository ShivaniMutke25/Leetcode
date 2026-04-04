/**
 * Min-Heap Approach - Meeting Rooms II (OPTIMAL)
 * 
 * Logic:
 * - Sort intervals by start time
 * - Use min-heap to track end times of active meetings
 * - For each meeting, check if earliest ending room is available
 * - If available, reuse; otherwise, add new room
 * 
 * When to use: Large n, performance critical, intuitive implementation
 * When NOT to use: Memory constraints, very small n
 * 
 * Time Complexity: O(n log n) - sorting + heap operations
 * Space Complexity: O(n) - heap for end times
 */
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        // Min-heap to track end times of active meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int[] interval : intervals) {
            // If earliest ending meeting is done, reuse room
            if (!minHeap.isEmpty() && interval[0] >= minHeap.peek()) {
                minHeap.poll();
            }
            
            // Add current meeting's end time
            minHeap.offer(interval[1]);
        }
        
        return minHeap.size();
    }
}

/*
Example Walkthrough:
intervals = [[0,30],[5,10],[15,20]]

Sort by start time: [[0,30],[5,10],[15,20]]

Initialize: minHeap = []

Process [0,30]:
  minHeap.isEmpty() → no reuse
  minHeap.offer(30) → [30]

Process [5,10]:
  minHeap.peek() = 30, 5 < 30 → no reuse
  minHeap.offer(10) → [10,30]

Process [15,20]:
  minHeap.peek() = 10, 15 >= 10 → reuse room, minHeap.poll() → [30]
  minHeap.offer(20) → [20,30]

Result: minHeap.size() = 2

Another example:
intervals = [[7,10],[2,4]]

Sort by start time: [[2,4],[7,10]]

Initialize: minHeap = []

Process [2,4]:
  minHeap.isEmpty() → no reuse
  minHeap.offer(4) → [4]

Process [7,10]:
  minHeap.peek() = 4, 7 >= 4 → reuse room, minHeap.poll() → []
  minHeap.offer(10) → [10]

Result: minHeap.size() = 1

Why this works:
- Heap always contains end times of active meetings
- Earliest ending meeting is at heap root
- If current meeting starts after earliest end, reuse room
- Heap size at any time is rooms currently in use
- Maximum heap size gives minimum rooms needed

Why this is optimal:
- Time: O(n log n) - optimal for this problem
- Space: O(n) - necessary for heap
- Intuitive room allocation logic
- Handles all edge cases correctly

Key insights:
- Sort by start time for chronological processing
- Min-heap tracks earliest ending meeting
- Room reuse when meeting starts after earliest end
- Heap size represents current room usage

This is perfect solution!
*/
