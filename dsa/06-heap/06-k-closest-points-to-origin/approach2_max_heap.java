/**
 * Max-Heap Approach - K Closest Points to Origin (OPTIMAL)
 * 
 * Logic:
 * - Use max-heap of size k to maintain k closest points
 * - For each point, calculate distance and add to heap
 * - If heap size exceeds k, remove farthest point
 * - Extract all points from heap
 * 
 * When to use: Large n, small k, performance critical
 * When NOT to use: k close to n, very small arrays
 * 
 * Time Complexity: O(n log k) - heap operations
 * Space Complexity: O(k) - heap of size k
 */
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-heap based on distance (farthest at root)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];
            return distB - distA; // Max-heap
        });
        
        for (int[] point : points) {
            maxHeap.offer(point);
            
            // Keep only k closest points
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        // Extract points from heap
        int[][] result = new int[k][2];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }
        
        return result;
    }
}

/*
Example Walkthrough:
points = [[1,3],[-2,2]], k = 1

Initialize: maxHeap = []

Process [1,3]:
  distance = 1² + 3² = 10
  maxHeap.offer([1,3]) → [[1,3]]
  size = 1 <= k=1 → no poll

Process [-2,2]:
  distance = (-2)² + 2² = 8
  maxHeap.offer([-2,2]) → [[1,3],[-2,2]] (max-heap: [1,3] at root)
  size = 2 > k=1 → maxHeap.poll() → removes [1,3]
  maxHeap = [[-2,2]]

Extract from heap:
result[0] = maxHeap.poll() = [-2,2]

Result: [[-2,2]]

Another example:
points = [[3,3],[5,-1],[-2,4]], k = 2

Initialize: maxHeap = []

Process [3,3]:
  distance = 3² + 3² = 18
  maxHeap.offer([3,3]) → [[3,3]]
  size = 1 <= k=2 → no poll

Process [5,-1]:
  distance = 5² + (-1)² = 26
  maxHeap.offer([5,-1]) → [[5,-1],[3,3]] (max-heap: [5,-1] at root)
  size = 2 <= k=2 → no poll

Process [-2,4]:
  distance = (-2)² + 4² = 20
  maxHeap.offer([-2,4]) → [[5,-1],[-2,4],[3,3]] (max-heap: [5,-1] at root)
  size = 3 > k=2 → maxHeap.poll() → removes [5,-1]
  maxHeap = [[-2,4],[3,3]]

Extract from heap:
result[1] = maxHeap.poll() = [3,3]
result[0] = maxHeap.poll() = [-2,4]

Result: [[-2,4],[3,3]]

Why this works:
- Max-heap always contains k closest points
- Farthest point among k closest is at heap root
- Each insertion/removal is O(log k)
- Total time is O(n log k) - better than sorting
- Space is O(k) - much better than O(n)

Why this is optimal:
- Time: O(n log k) - optimal for k-closest problem
- Space: O(k) - minimal space needed
- Handles large arrays efficiently
- Perfect for when k << n

Key insights:
- Max-heap of size k maintains k closest points
- Heap root is always the farthest among k closest
- Using squared distance avoids sqrt calculation
- Better than sorting when k << n

This is perfect solution!
*/
