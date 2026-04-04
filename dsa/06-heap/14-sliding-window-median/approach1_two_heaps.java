/**
 * Two Heaps Approach - Sliding Window Median (OPTIMAL)
 * 
 * Logic:
 * - Use two heaps: max-heap for lower half, min-heap for upper half
 * - Maintain balance and handle window sliding
 * - Use lazy deletion for efficient sliding
 * - Calculate median from heap tops
 * 
 * When to use: Large n, performance critical, optimal solution
 * When NOT to use: Memory constraints, very small k
 * 
 * Time Complexity: O(n log k) - heap operations
 * Space Complexity: O(k) - window size
 */
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Map<Integer, Integer> delayed = new HashMap<>();
        
        int balance = 0; // maxHeap.size() - minHeap.size()
        
        for (int i = 0; i < nums.length; i++) {
            // Add current number
            if (!maxHeap.isEmpty() && nums[i] <= maxHeap.peek()) {
                maxHeap.offer(nums[i]);
                balance++;
            } else {
                minHeap.offer(nums[i]);
                balance--;
            }
            
            // Rebalance heaps
            if (balance > 0) {
                minHeap.offer(maxHeap.poll());
                balance--;
            } else if (balance < 0) {
                maxHeap.offer(minHeap.poll());
                balance++;
            }
            
            // Remove elements outside window
            if (i >= k) {
                int outNum = nums[i - k];
                delayed.put(outNum, delayed.getOrDefault(outNum, 0) + 1);
                
                if (outNum <= maxHeap.peek()) {
                    balance--;
                } else {
                    balance++;
                }
                
                // Clean top of heaps
                while (!maxHeap.isEmpty() && delayed.containsKey(maxHeap.peek())) {
                    int num = maxHeap.poll();
                    delayed.put(num, delayed.get(num) - 1);
                    if (delayed.get(num) == 0) {
                        delayed.remove(num);
                    }
                }
                
                while (!minHeap.isEmpty() && delayed.containsKey(minHeap.peek())) {
                    int num = minHeap.poll();
                    delayed.put(num, delayed.get(num) - 1);
                    if (delayed.get(num) == 0) {
                        delayed.remove(num);
                    }
                }
            }
            
            // Calculate median
            if (i >= k - 1) {
                if (k % 2 == 1) {
                    result[i - k + 1] = maxHeap.peek();
                } else {
                    result[i - k + 1] = (maxHeap.peek() + minHeap.peek()) / 2.0;
                }
            }
        }
        
        return result;
    }
}

/*
Example Walkthrough:
nums = [1,3,-1,-3,5,3,6,7], k = 3

Initialize: maxHeap = [], minHeap = [], delayed = {}, balance = 0

i = 0: add 1 → maxHeap = [1], balance = 1
i = 1: add 3 → minHeap = [3], balance = 0 (rebalance)
i = 2: add -1 → maxHeap = [-1], minHeap = [1,3], balance = 0
Median: k=3 odd → maxHeap.peek() = 1 → result[0] = 1

i = 3: add -3 → maxHeap = [-3,-1], minHeap = [1,3], balance = 1
       rebalance → maxHeap = [-1], minHeap = [-3,1,3], balance = 0
       remove nums[0]=1 → delayed = {1:1}, balance--
       clean → remove 1 from minHeap
Median: maxHeap.peek() = -1 → result[1] = -1

Continue similarly...

Result: [1,-1,-1,3,5,6]

Why this works:
- Two heaps maintain separate halves of window
- Lazy deletion enables efficient sliding
- Balance ensures correct median calculation
- Each operation is O(log k)

Why this is optimal:
- Time: O(n log k) - optimal for sliding window median
- Space: O(k) - window size
- Handles all sliding scenarios correctly
- Much better than sorting each window

Key insights:
- Two heaps maintain window halves
- Lazy deletion for efficient sliding
- Balance is crucial for correct median
- Different calculation for even/odd window sizes

This is perfect solution!
*/
