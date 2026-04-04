/**
 * Min-Heap Approach - Find K Closest Elements
 * 
 * Logic:
 * - Calculate distance for each element from x
 * - Use min-heap to find k closest elements
 * - Sort result at the end
 * 
 * When to use: Multiple queries, large n
 * When NOT to use: Very small k, sorted arrays
 * 
 * Time Complexity: O(n log k) - heap operations
 * Space Complexity: O(k) - heap of size k
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            int distA = Math.abs(a[0] - x);
            int distB = Math.abs(b[0] - x);
            if (distA != distB) {
                return distA - distB;
            } else {
                return a[0] - b[0]; // Prefer smaller element
            }
        });
        
        for (int num : arr) {
            minHeap.offer(new int[]{num});
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(minHeap.poll()[0]);
        }
        
        Collections.sort(result);
        return result;
    }
}

/*
Example Walkthrough:
arr = [1,2,3,4,5], k = 4, x = 3

Calculate distances and add to heap:
[1,2], [2,1], [3,0], [4,1], [5,2]

Heap order by distance, then by value:
[3,0], [2,1], [4,1], [1,2], [5,2]

Extract k=4 elements:
1. [3,0] → add 3
2. [2,1] → add 2
3. [4,1] → add 4
4. [1,2] → add 1

Result before sort: [3,2,4,1]
After sort: [1,2,3,4]

Result: [1,2,3,4]

Why this works:
- Heap automatically orders by distance
- Handles tie-breaking by element value
- Extracting k elements gives k closest
- Final sort ensures required order

Why this is not optimal:
- Time complexity is O(n log k) - slower than O(n)
- Space complexity is O(n) for heap
- Doesn't leverage sorted array property
- More complex than two pointers approach

Key limitation: Using heap when two pointers is more efficient
*/
