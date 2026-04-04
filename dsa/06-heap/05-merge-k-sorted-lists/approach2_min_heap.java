/**
 * Min-Heap Approach - Merge K Sorted Lists (OPTIMAL)
 * 
 * Logic:
 * - Use min-heap to always pick smallest available node
 * - Add first node of each list to heap
 * - Repeatedly extract smallest and add its next node to heap
 * - Build result list in order
 * 
 * When to use: Large k, many lists, performance critical
 * When NOT to use: Very small k, memory constraints
 * 
 * Time Complexity: O(n log k) - heap operations
 * Space Complexity: O(k) - heap of size k
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Add first node of each list to heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;
            
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }
        
        return dummy.next;
    }
}

/*
Example Walkthrough:
lists = [[1,4,5],[1,3,4],[2,6]]

Initialize heap with first nodes:
minHeap = [1(from list1), 1(from list2), 2(from list3)]

dummy -> 0, current = dummy

Iteration 1:
  smallest = 1(from list1)
  current.next = 1, current = 1
  offer 1.next = 4 to heap
  heap = [1(from list2), 2(from list3), 4(from list1)]

Iteration 2:
  smallest = 1(from list2)
  current.next = 1, current = 1
  offer 1.next = 3 to heap
  heap = [2(from list3), 3(from list2), 4(from list1)]

Iteration 3:
  smallest = 2(from list3)
  current.next = 2, current = 2
  offer 2.next = 6 to heap
  heap = [3(from list2), 4(from list1), 6(from list3)]

Iteration 4:
  smallest = 3(from list2)
  current.next = 3, current = 3
  offer 3.next = 4 to heap
  heap = [4(from list1), 4(from list2), 6(from list3)]

Iteration 5:
  smallest = 4(from list1)
  current.next = 4, current = 4
  offer 4.next = 5 to heap
  heap = [4(from list2), 5(from list1), 6(from list3)]

Iteration 6:
  smallest = 4(from list2)
  current.next = 4, current = 4
  offer 4.next = null → no offer
  heap = [5(from list1), 6(from list3)]

Iteration 7:
  smallest = 5(from list1)
  current.next = 5, current = 5
  offer 5.next = null → no offer
  heap = [6(from list3)]

Iteration 8:
  smallest = 6(from list3)
  current.next = 6, current = 6
  offer 6.next = null → no offer
  heap = []

Result: [1,1,2,3,4,4,5,6]

Why this works:
- Heap always contains smallest available node from each list
- Each extraction gives next element in merged order
- Each node is processed exactly once
- Heap operations are O(log k)

Why this is optimal:
- Time: O(n log k) - optimal for k-way merge
- Space: O(k) for heap + O(n) for result
- Each node processed exactly once
- Perfect for merging multiple sorted streams

Key insights:
- Min-heap enables efficient selection of smallest element
- Each list contributes exactly one node to heap at a time
- Heap size is always at most k
- Result is built in sorted order automatically

This is perfect solution!
*/
