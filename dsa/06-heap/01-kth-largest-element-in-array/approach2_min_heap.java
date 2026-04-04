/**
 * Min-Heap Approach - Kth Largest Element in an Array (OPTIMAL)
 * 
 * Logic:
 * - Use min-heap of size k to maintain k largest elements
 * - For each element, add to heap
 * - If heap size exceeds k, remove smallest element
 * - Heap root is always the kth largest element
 * 
 * When to use: Multiple queries, streaming data, small k
 * When NOT to use: Very small arrays, k close to n
 * 
 * Time Complexity: O(n log k) - heap operations
 * Space Complexity: O(k) - heap of size k
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.offer(num);
            
            // Keep only k largest elements
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        return minHeap.peek();
    }
}

/*
Example Walkthrough:
nums = [3,2,1,5,6,4], k = 2

Initialize: minHeap = []

num = 3:
  minHeap.offer(3) → [3]
  size = 1 <= k=2 → no poll

num = 2:
  minHeap.offer(2) → [2,3]
  size = 2 <= k=2 → no poll

num = 1:
  minHeap.offer(1) → [1,2,3]
  size = 3 > k=2 → minHeap.poll() → [2,3]

num = 5:
  minHeap.offer(5) → [2,3,5]
  size = 3 > k=2 → minHeap.poll() → [3,5]

num = 6:
  minHeap.offer(6) → [3,5,6]
  size = 3 > k=2 → minHeap.poll() → [5,6]

num = 4:
  minHeap.offer(4) → [4,5,6]
  size = 3 > k=2 → minHeap.poll() → [5,6]

Result: minHeap.peek() = 5

Another example:
nums = [3,2,3,1,2,4,5,5,6], k = 4

Initialize: minHeap = []

Process all elements, maintaining size 4:
After processing, minHeap contains [4,5,5,6]

Result: minHeap.peek() = 4

Why this works:
- Min-heap always contains k largest elements
- Smallest element in heap is the kth largest overall
- Each insertion/removal is O(log k)
- Total time is O(n log k) - better than sorting
- Space is O(k) - much better than O(n)

Why this is optimal:
- Time: O(n log k) - optimal for kth element problem
- Space: O(k) - minimal space needed
- Handles streaming data efficiently
- Multiple queries are fast after initial setup

Key insights:
- Min-heap of size k maintains k largest elements
- Heap root is always the kth largest element
- Better than sorting when k << n
- Perfect for streaming data scenarios

This is perfect solution!
*/
