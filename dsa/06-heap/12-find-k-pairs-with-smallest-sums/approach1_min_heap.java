/**
 * Min-Heap Approach - Find K Pairs with Smallest Sums (OPTIMAL)
 * 
 * Logic:
 * - Use min-heap to track smallest pair sums
 * - Initialize heap with pairs from first k elements of nums1
 * - Extract smallest pair and add next pair from same row
 * - Continue until k pairs are found
 * 
 * When to use: Large inputs, performance critical, optimal solution
 * When NOT to use: Very small k, memory constraints
 * 
 * Time Complexity: O(k log k) - heap operations
 * Space Complexity: O(k) - heap of size k
 */
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }
        
        // Min-heap: [sum, index1, index2]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // Initialize heap with first k elements from nums1 paired with nums2[0]
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }
        
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int sum = current[0];
            int i = current[1];
            int j = current[2];
            
            result.add(Arrays.asList(nums1[i], nums2[j]));
            
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }
        
        return result;
    }
}

/*
Example Walkthrough:
nums1 = [1,7,11], nums2 = [2,4,6], k = 3

Initialize heap with first k=3 elements:
[1+2=3, i=0, j=0], [7+2=9, i=1, j=0], [11+2=13, i=2, j=0]
Heap: [3,9,13]

k = 3:

Iteration 1:
  current = [3,0,0], result = [[1,2]]
  j+1 = 1 < 3 → offer [1+4=5,0,1]
  Heap: [5,9,13]

Iteration 2:
  current = [5,0,1], result = [[1,2],[1,4]]
  j+1 = 2 < 3 → offer [1+6=7,0,2]
  Heap: [7,9,13]

Iteration 3:
  current = [7,0,2], result = [[1,2],[1,4],[1,6]]
  j+1 = 3 >= 3 → no offer
  Heap: [9,13]

Result: [[1,2],[1,4],[1,6]]

Why this works:
- Heap always contains smallest available pair sum
- Each extraction generates next candidate from same row
- Leverages sorted property of both arrays
- Efficiently finds k smallest pairs

Why this is optimal:
- Time: O(k log k) - optimal for k pairs
- Space: O(k) - minimal space needed
- Doesn't generate all possible pairs
- Perfect for large inputs

Key insights:
- Initialize with first k elements from nums1
- Each extraction generates next in sequence
- Heap ensures smallest sum is always available
- Avoids O(mn) brute force approach

This is perfect solution!
*/
