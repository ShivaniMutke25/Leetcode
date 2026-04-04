/**
 * Sort by Frequency Approach - Top K Frequent Elements
 * 
 * Logic:
 * - Count frequency of each element using HashMap
 * - Sort frequency pairs by frequency descending
 * - Return first k elements
 * 
 * When to use: Simple implementation, moderate input size
 * When NOT to use: Very large n, multiple queries
 * 
 * Time Complexity: O(n log n) - sorting
 * Space Complexity: O(n) - frequency map
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Convert to array and sort by frequency
        List<int[]> freqList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            freqList.add(new int[]{entry.getKey(), entry.getValue()});
        }
        
        freqList.sort((a, b) -> b[1] - a[1]); // Sort by frequency descending
        
        // Extract top k elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = freqList.get(i)[0];
        }
        
        return result;
    }
}

/*
Example Walkthrough:
nums = [1,1,1,2,2,3], k = 2

Count frequencies:
1: 3, 2: 2, 3: 1

Sort by frequency: [(1,3), (2,2), (3,1)]

Extract top 2: [1, 2]

Result: [1, 2]

Another example:
nums = [1], k = 1

Count frequencies:
1: 1

Sort by frequency: [(1,1)]

Extract top 1: [1]

Result: [1]

Why this works:
- Frequency counting gives us occurrence count
- Sorting by frequency puts most frequent first
- Taking first k gives us k most frequent
- Simple and easy to understand

Why this is not optimal:
- Time complexity is O(n log n) - sorting all frequencies
- For large n, sorting is expensive
- We only need k elements, not full sort
- Space is O(n) but time is high

Key limitation: Sorting all frequencies when we only need top k
*/
