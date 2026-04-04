/**
 * Brute Force Approach - 3Sum
 * 
 * Logic:
 * - Check all possible triplets
 * - For each triplet, check if sum equals 0
 * - Collect unique triplets
 * 
 * When to use: Understanding problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(n³) - O(n³) triplets, each sum calculation O(1)
 * Space Complexity: O(n) - for storing result
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> uniqueTriplets = new HashSet<>();
        
        int n = nums.length;
        
        // Check all possible triplets
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        // Sort triplet to handle duplicates consistently
                        Collections.sort(triplet);
                        uniqueTriplets.add(triplet);
                    }
                }
            }
        }
        
        result.addAll(uniqueTriplets);
        return result;
    }
}

/*
Example Walkthrough:
nums = [-1,0,1,2,-1,-4]

i = 0, nums[0] = -1:
  j = 1, nums[1] = 0:
    k = 2, nums[2] = 1: -1 + 0 + 1 = 0 ✓ → triplet [-1,0,1]
    k = 3, nums[3] = 2: -1 + 0 + 2 = 1 ≠ 0
    k = 4, nums[4] = -4: -1 + 0 + -4 = -5 ≠ 0
  j = 2, nums[2] = 1:
    k = 3, nums[3] = 2: -1 + 1 + 2 = 2 ≠ 0
    k = 4, nums[4] = -4: -1 + 1 + -4 = -4 ≠ 0
  j = 3, nums[3] = 2:
    k = 4, nums[4] = -4: -1 + 2 + -4 = -3 ≠ 0
  j = 4, nums[4] = -4:
    No k available

i = 1, nums[1] = 0:
  j = 2, nums[2] = 1:
    k = 3, nums[3] = 2: 0 + 1 + 2 = 3 ≠ 0
    k = 4, nums[4] = -4: 0 + 1 + -4 = -3 ≠ 0
  j = 3, nums[3] = 2:
    k = 4, nums[4] = -4: 0 + 2 + -4 = -2 ≠ 0
  j = 4, nums[4] = -4:
    No k available

i = 2, nums[2] = 1:
  j = 3, nums[3] = 2:
    k = 4, nums[4] = -4: 1 + 2 + -4 = -1 ≠ 0
  j = 4, nums[4] = -4:
    No k available

i = 3, nums[3] = 2:
  j = 4, nums[4] = -4:
    No k available

i = 4, nums[4] = -4:
  No j available

After sorting and removing duplicates:
[[-1,-1,2], [-1,0,1]

Result: [[-1,-1,2],[-1,0,1]]

Why this is inefficient:
- Number of triplets: n*(n-1)*(n-2)/6 = O(n³)
- For each triplet, sum calculation: O(1)
- Total: O(n³) time complexity
- For n=3000, this is completely impractical

Key limitation: No optimization to avoid redundant checking
*/
