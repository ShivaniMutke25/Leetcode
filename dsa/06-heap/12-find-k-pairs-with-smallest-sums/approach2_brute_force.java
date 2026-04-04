/**
 * Brute Force Approach - Find K Pairs with Smallest Sums
 * 
 * Logic:
 * - Generate all possible pairs
 * - Sort by sum
 * - Return first k pairs
 * 
 * When to use: Very small inputs, understanding problem
 * When NOT to use: Any realistic input - too slow
 * 
 * Time Complexity: O(mn log mn) - generate all pairs and sort
 * Space Complexity: O(mn) - store all pairs
 */
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> allPairs = new ArrayList<>();
        
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                allPairs.add(Arrays.asList(num1, num2));
            }
        }
        
        allPairs.sort((a, b) -> (a.get(0) + a.get(1)) - (b.get(0) + b.get(1)));
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < Math.min(k, allPairs.size()); i++) {
            result.add(allPairs.get(i));
        }
        
        return result;
    }
}

/*
Example Walkthrough:
nums1 = [1,7,11], nums2 = [2,4,6], k = 3

Generate all pairs:
[1,2]=3, [1,4]=5, [1,6]=7, [7,2]=9, [7,4]=11, [7,6]=13, [11,2]=13, [11,4]=15, [11,6]=17

Sort by sum: [1,2]=3, [1,4]=5, [1,6]=7, [7,2]=9, [7,4]=11, [7,6]=13, [11,2]=13, [11,4]=15, [11,6]=17

Return first 3: [[1,2],[1,4],[1,6]]

Result: [[1,2],[1,4],[1,6]]

Why this works:
- Generates all possible pairs
- Sorting puts pairs in correct order
- Taking first k gives k smallest pairs
- Simple to understand

Why this is not optimal:
- Time complexity is O(mn log mn) - very slow
- Space complexity is O(mn) - uses too much memory
- For m=n=1000, this is 1M pairs
- Doesn't leverage sorted property

Key limitation: Generating all pairs when we only need k
*/
