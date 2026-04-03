/**
 * Bit Manipulation Approach - Contains Duplicate
 * 
 * Logic:
 * - Use bit array to track seen numbers (works for small ranges)
 * - Each bit represents whether a number has been seen
 * - Set bit when number encountered, check if already set
 * 
 * When to use: Numbers are in small, known range (e.g., 0 to 10^6)
 * When NOT to use: Large value ranges or negative numbers
 * 
 * Time Complexity: O(n) - single pass
 * Space Complexity: O(1) - fixed bit array size
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // This approach works only for non-negative numbers in reasonable range
        // For demonstration, assuming numbers are between 0 and 1000000
        final int MAX_RANGE = 1000000;
        int[] bitArray = new int[(MAX_RANGE / 32) + 1];
        
        for (int num : nums) {
            if (num < 0 || num > MAX_RANGE) {
                // Fall back to HashSet for out-of-range values
                return containsDuplicateHashSet(nums);
            }
            
            int arrayIndex = num / 32;
            int bitPosition = num % 32;
            int bitMask = 1 << bitPosition;
            
            // Check if bit is already set
            if ((bitArray[arrayIndex] & bitMask) != 0) {
                return true;
            }
            
            // Set the bit
            bitArray[arrayIndex] |= bitMask;
        }
        
        return false;
    }
    
    private boolean containsDuplicateHashSet(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }
}

/*
Example Walkthrough:
nums = [1,2,3,1], MAX_RANGE = 1000000

bitArray size = (1000000/32) + 1 = 31251

num = 1:
  - arrayIndex = 1/32 = 0
  - bitPosition = 1%32 = 1
  - bitMask = 1 << 1 = 2
  - bitArray[0] & 2 = 0 (not set)
  - Set bit: bitArray[0] = bitArray[0] | 2

num = 2:
  - arrayIndex = 2/32 = 0
  - bitPosition = 2%32 = 2
  - bitMask = 1 << 2 = 4
  - bitArray[0] & 4 = 0 (not set)
  - Set bit: bitArray[0] = bitArray[0] | 4

num = 3:
  - arrayIndex = 3/32 = 0
  - bitPosition = 3%32 = 3
  - bitMask = 1 << 3 = 8
  - bitArray[0] & 8 = 0 (not set)
  - Set bit: bitArray[0] = bitArray[0] | 8

num = 1:
  - arrayIndex = 1/32 = 0
  - bitPosition = 1%32 = 1
  - bitMask = 1 << 1 = 2
  - bitArray[0] & 2 = 2 (already set) ✓ → Return true

Why this works:
- Each bit represents whether we've seen a specific number
- Bit operations are very fast (O(1))
- Fixed space regardless of input size

Limitations:
- Only works for non-negative numbers
- Requires knowing the maximum value range
- Falls back to HashSet for invalid inputs

When this is useful:
- Numbers are in small, known range
- Memory is extremely constrained
- You want to demonstrate bit manipulation knowledge
*/
