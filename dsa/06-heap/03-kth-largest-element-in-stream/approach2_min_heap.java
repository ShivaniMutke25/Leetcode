/**
 * Min-Heap Approach - Kth Largest Element in a Stream (OPTIMAL)
 * 
 * Logic:
 * - Use min-heap of size k to maintain k largest elements
 * - In constructor, initialize heap with initial numbers
 * - For each add operation, insert new element and maintain heap size
 * - Heap root is always the kth largest element
 * 
 * When to use: Streaming data, many add operations, small k
 * When NOT to use: Very small k, one-time query
 * 
 * Time Complexity: O(log n) per add - heap operations
 * Space Complexity: O(k) - heap of size k
 */
class KthLargest {
    private int k;
    private PriorityQueue<Integer> minHeap;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        
        // Keep only k largest elements
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        
        return minHeap.peek();
    }
}

/*
Example Walkthrough:
k = 3, nums = [4,5,8,2]

Initialize: k = 3, minHeap = []

Constructor:
add(4): minHeap.offer(4) → [4], size = 1 <= k=3 → no poll
add(5): minHeap.offer(5) → [4,5], size = 2 <= k=3 → no poll
add(8): minHeap.offer(8) → [4,5,8], size = 3 <= k=3 → no poll
add(2): minHeap.offer(2) → [2,4,5,8], size = 4 > k=3 → minHeap.poll() → [4,5,8]

add(3):
  minHeap.offer(3) → [3,4,5,8]
  size = 4 > k=3 → minHeap.poll() → [4,5,8]
  return minHeap.peek() = 4

add(5):
  minHeap.offer(5) → [4,5,5,8]
  size = 4 > k=3 → minHeap.poll() → [5,5,8]
  return minHeap.peek() = 5

add(10):
  minHeap.offer(10) → [5,5,8,10]
  size = 4 > k=3 → minHeap.poll() → [5,8,10]
  return minHeap.peek() = 5

add(9):
  minHeap.offer(9) → [5,8,9,10]
  size = 4 > k=3 → minHeap.poll() → [8,9,10]
  return minHeap.peek() = 8

add(4):
  minHeap.offer(4) → [4,8,9,10]
  size = 4 > k=3 → minHeap.poll() → [8,9,10]
  return minHeap.peek() = 8

Result: [null, 4, 5, 5, 8, 8]

Why this works:
- Min-heap always contains k largest elements
- Smallest element in heap is the kth largest overall
- Each insertion/removal is O(log k)
- Total time per add is O(log k) - optimal for streaming
- Space is O(k) - much better than O(n)

Why this is optimal:
- Time: O(log k) per add - optimal for streaming data
- Space: O(k) - minimal space needed
- Handles infinite streaming data efficiently
- Perfect for real-time applications

Key insights:
- Min-heap of size k maintains k largest elements
- Heap root is always the kth largest element
- Much better than sorting for streaming data
- Perfect for real-time processing

This is perfect solution!
*/
