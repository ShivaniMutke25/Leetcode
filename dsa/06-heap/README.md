# Heap Problems - DSA Master Collection

This folder contains comprehensive solutions for heap problems asked in technical interviews, with multiple approaches for each problem including time/space complexity analysis and usage guidelines.

## 📋 Problem List

| # | Problem | LeetCode ID | Difficulty | Best Approach | Time | Space |
|---|---------|-------------|------------|---------------|------|-------|
| 1 | [Kth Largest Element in Array](./01-kth-largest-element-in-array/) | 215 | Medium | Min-Heap | O(n log k) | O(k) |
| 2 | [Top K Frequent Elements](./02-top-k-frequent-elements/) | 347 | Medium | Min-Heap | O(n log k) | O(k) |
| 3 | [Kth Largest Element in Stream](./03-kth-largest-element-in-stream/) | 703 | Easy | Min-Heap | O(log k) | O(k) |
| 4 | [Find Median from Data Stream](./04-find-median-from-data-stream/) | 295 | Hard | Two Heaps | O(log n) | O(n) |
| 5 | [Merge K Sorted Lists](./05-merge-k-sorted-lists/) | 23 | Hard | Min-Heap | O(n log k) | O(k) |
| 6 | [K Closest Points to Origin](./06-k-closest-points-to-origin/) | 973 | Medium | Max-Heap | O(n log k) | O(k) |
| 7 | [Find K Closest Elements](./07-find-k-closest-elements/) | 658 | Medium | Min-Heap | O(n log k) | O(k) |
| 8 | [Meeting Rooms II](./08-meeting-rooms-ii/) | 253 | Medium | Min-Heap | O(n log n) | O(n) |
| 9 | [Task Scheduler](./09-task-scheduler/) | 621 | Medium | Max-Heap | O(n log n) | O(1) |
| 10 | [Reorganize String](./10-reorganize-string/) | 767 | Medium | Max-Heap | O(n log n) | O(n) |
| 11 | [Last Stone Weight](./11-last-stone-weight/) | 1046 | Easy | Max-Heap | O(n log n) | O(n) |
| 12 | [Find K Pairs with Smallest Sums](./12-find-k-pairs-with-smallest-sums/) | 373 | Medium | Min-Heap | O(n log k) | O(k) |
| 13 | [Furthest Building You Can Reach](./13-furthest-building-you-can-reach/) | 1642 | Medium | Min-Heap | O(n log n) | O(n) |
| 14 | [Sliding Window Median](./14-sliding-window-median/) | 480 | Hard | Two Heaps | O(n log k) | O(k) |

## 🎯 Key Patterns & Techniques

### 1. **Min-Heap Pattern**
- **When to use**: Find kth largest elements, smallest elements
- **Problems**: Kth Largest, Top K Frequent, K Closest Points
- **Time**: O(n log k), **Space**: O(k)
- **Key**: Maintain heap of size k with smallest/largest elements

### 2. **Max-Heap Pattern**
- **When to use**: Find kth smallest elements, largest frequencies
- **Problems**: Task Scheduler, Reorganize String, Last Stone Weight
- **Time**: O(n log n), **Space**: O(n)
- **Key**: Maintain heap with largest elements for processing

### 3. **Two Heaps Pattern**
- **When to use**: Find median, maintain balance
- **Problems**: Find Median, Sliding Window Median
- **Time**: O(log n), **Space**: O(n)
- **Key**: One max-heap for lower half, one min-heap for upper half

### 4. **Priority Queue Pattern**
- **When to use**: Process elements in priority order
- **Problems**: Merge K Lists, Meeting Rooms II, Task Scheduler
- **Time**: O(n log k), **Space**: O(k)
- **Key**: Use heap to always process highest priority element

### 5. **Streaming Pattern**
- **When to use**: Handle continuous data streams
- **Problems**: Kth Largest in Stream, Find Median from Stream
- **Time**: O(log k) per insertion, **Space**: O(k)
- **Key**: Maintain heap while processing streaming data

## 🛠️ Core Components

### 1. **PriorityQueue Implementation**
```java
// Min-Heap (default)
PriorityQueue<Integer> minHeap = new PriorityQueue<>();

// Max-Heap
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

// Custom Comparator
PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
```

### 2. **Kth Largest Element**
```java
public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    for (int num : nums) {
        minHeap.offer(num);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
    }
    
    return minHeap.peek();
}
```

### 3. **Two Heaps for Median**
```java
class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // Lower half
    private PriorityQueue<Integer> minHeap; // Upper half
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        
        if (maxHeap.size() > minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }
}
```

## 📚 Usage Instructions

### For Each Problem:
1. **Read the README.md** for problem description and approach comparison
2. **Study multiple approaches** from brute force to optimal
3. **Understand complexity analysis** and when to use each approach
4. **Practice interview talking points** provided in each README
5. **Master the pattern** for similar problems

### Learning Path:
1. **Start with easy problems** - Kth Largest in Stream, Last Stone Weight
2. **Progress to medium** - Top K Frequent, K Closest Points, Task Scheduler
3. **Tackle hard problems** - Find Median, Merge K Lists, Sliding Window Median

## 🏆 Interview Strategy

### How to Approach Heap Problems:
1. **Identify if heap is applicable** - Need kth element, priority processing
2. **Choose heap type** - Min-heap for largest elements, max-heap for smallest
3. **Determine heap size** - Usually k elements for kth problems
4. **Implement efficiently** - Use built-in PriorityQueue
5. **Explain trade-offs** - Time vs space complexity

### Common Follow-up Questions:
- "Why use heap instead of sorting?" → O(n log k) vs O(n log n)
- "What if we need smallest instead of largest?" → Use max-heap
- "Can we optimize space?" → Use heap of size k instead of full array
- "What about streaming data?" → Maintain heap while processing

## 📈 Progress Tracking

- ✅ **Problems with complete solutions**: 0/14
- 🔄 **Currently working on**: Folder structure setup
- 📋 **Next steps**: Create individual problem folders with comprehensive solutions

---

## 🎯 Key Insights

- **Heap** is essential for kth element and priority processing problems
- **Min-heap** finds kth largest, **max-heap** finds kth smallest
- **Two heaps** pattern is crucial for median finding
- **Priority queue** enables efficient priority-based processing
- **Streaming** problems require maintaining heap while processing data

Master these patterns and you'll be well-prepared for any heap interview question!
