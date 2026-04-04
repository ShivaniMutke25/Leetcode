/**
 * Sort + Count Approach - Meeting Rooms II
 * 
 * Logic:
 * - Separate start and end times
 * - Sort both arrays
 * - Use two pointers to count overlapping meetings
 * 
 * When to use: Simple implementation, moderate input size
 * When NOT to use: Very large n, memory constraints
 * 
 * Time Complexity: O(n log n) - sorting
 * Space Complexity: O(n) - separate arrays
 */
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int rooms = 0, endPtr = 0;
        
        for (int start : starts) {
            if (start < ends[endPtr]) {
                rooms++; // Need new room
            } else {
                endPtr++; // Reuse room
            }
        }
        
        return rooms;
    }
}

/*
Example Walkthrough:
intervals = [[0,30],[5,10],[15,20]]

starts = [0,5,15], ends = [10,20,30]

rooms = 0, endPtr = 0

start = 0:
  0 < ends[0]=10 → rooms = 1

start = 5:
  5 < ends[0]=10 → rooms = 2

start = 15:
  15 >= ends[0]=10 → endPtr = 1
  15 < ends[1]=20 → rooms = 3 (but we reuse, so rooms stays 2)

Result: 2

Why this works:
- Start times sorted chronologically
- End times sorted chronologically
- Two pointers track room availability
- Count gives maximum simultaneous meetings

Why this is not optimal:
- Uses O(n) extra space for arrays
- Two-pointer approach can be confusing
- Min-heap approach is more intuitive

Key limitation: Extra space usage when heap approach is cleaner
*/
