/**
 * Min-Heap Approach - Top K Frequent Elements (OPTIMAL)
 * 
 * Logic:
 * - Count frequency of each element using HashMap
 * - Use min-heap of size k to maintain k most frequent elements
 * - For each frequency pair, add to heap and remove smallest if size exceeds k
 * - Extract elements from heap
 * 
 * When to use: Large n, small k, multiple queries
 * When NOT to use: k close to n, very small arrays
 * 
 * Time Complexity: O(n log k) - heap operations
 * Space Complexity: O(n) - frequency map + heap
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Use min-heap to maintain k most frequent elements
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});
            
            // Keep only k most frequent elements
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // Extract elements from heap
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll()[0];
        }
        
        return result;
    }
}

/*
Example Walkthrough:
nums = [1,1,1,2,2,3], k = 2

Count frequencies:
1: 3, 2: 2, 3: 1

Initialize: minHeap = []

Process (1,3):
  minHeap.offer([1,3]) → [(1,3)]
  size = 1 <= k=2 → no poll

Process (2,2):
  minHeap.offer([2,2]) → [(2,2), (1,3)]
  size = 2 <= k=2 → no poll

Process (3,1):
  minHeap.offer([3,1]) → [(3,1), (1,3), (2,2)]
  size = 3 > k=2 → minHeap.poll() → [(2,2), (1,3)]

Extract from heap:
result[1] = minHeap.poll()[0] = 2
result[0] = minHeap.poll()[0] = 1

Result: [1, 2]

Another example:
nums = [4,1,-1,2,-1,2,3], k = 2

Count frequencies:
4: 1, 1: 1, -1: 2, 2: 2, 3: 1

Process all frequencies, maintaining size 2:
Final heap contains: [(4,1), (2,2)] or similar

Extract: [2, -1] or similar

Result: [2, -1]

Why this works:
- Min-heap always contains k most frequent elements
- Smallest frequency in heap is the kth most frequent overall
- Each insertion/removal is O(log k)
- Total time is O(n log k) - better than sorting
- Space is O(n) for frequency map + O(k) for heap

Why this is optimal:
- Time: O(n log k) - optimal for top-k problem
- Space: O(n) - necessary for frequency counting
- Handles large arrays efficiently
- Multiple queries are fast after initial setup

Key insights:
- Frequency counting is essential first step
- Min-heap of size k maintains k most frequent elements
- Heap root is always the least frequent among top k
- Better than sorting when k << n

This is perfect solution!
*/
