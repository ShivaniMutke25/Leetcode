/**
 * Two Heaps Approach - Find Median from Data Stream (OPTIMAL)
 * 
 * Logic:
 * - Use max-heap for lower half, min-heap for upper half
 * - Maintain balance so size difference is at most 1
 * - For each add, insert into appropriate heap and rebalance
 * - For median, peek at heap tops based on total size
 * 
 * When to use: Streaming data, many queries, real-time processing
 * When NOT to use: Very small datasets, memory constraints
 * 
 * Time Complexity: O(log n) per add - heap operations
 * Space Complexity: O(n) - storing all elements
 */
class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // Lower half
    private PriorityQueue<Integer> minHeap; // Upper half
    
    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Add to appropriate heap
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        
        // Rebalance to maintain size difference <= 1
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            // Even number of elements
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            // Odd number of elements, maxHeap has one more
            return maxHeap.peek();
        }
    }
}

/*
Example Walkthrough:
addNum(1):
  maxHeap.isEmpty() → add to maxHeap: [1]
  Rebalance: maxHeap.size=1, minHeap.size=0 → OK

addNum(2):
  num=2 > maxHeap.peek()=1 → add to minHeap: [2]
  Rebalance: maxHeap.size=1, minHeap.size=1 → OK

findMedian():
  maxHeap.size == minHeap.size (1 == 1)
  return (maxHeap.peek() + minHeap.peek()) / 2.0 = (1 + 2) / 2.0 = 1.5

addNum(3):
  num=3 > maxHeap.peek()=1 → add to minHeap: [2,3]
  Rebalance: minHeap.size=2 > maxHeap.size=1 → maxHeap.offer(minHeap.poll()) → maxHeap=[2], minHeap=[3]

findMedian():
  maxHeap.size > minHeap.size (2 > 1)
  return maxHeap.peek() = 2

Result: [null, null, null, 1.5, null, 2.0]

Why this works:
- Max-heap always contains lower half of elements
- Min-heap always contains upper half of elements
- Balance ensures median is always accessible
- Each insertion/removal is O(log n)
- Median retrieval is O(1) - just peek at heap tops

Why this is optimal:
- Time: O(log n) per add - optimal for streaming data
- Space: O(n) - necessary to store all elements
- Handles infinite streaming data efficiently
- Perfect for real-time applications

Key insights:
- Two heaps maintain separate halves of data
- Max-heap gives largest in lower half
- Min-heap gives smallest in upper half
- Balance is crucial for correct median calculation
- Different median calculation for even/odd sizes

This is perfect solution!
*/
