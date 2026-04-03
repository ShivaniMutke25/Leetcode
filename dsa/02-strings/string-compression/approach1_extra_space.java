/**
 * Extra Space Approach - String Compression
 * 
 * Logic:
 * - Use StringBuilder to build compressed string
 * - Count consecutive characters and append character + count
 * - Handle single characters by only appending character
 * - Copy result back to original array
 * 
 * When to use: Simpler logic acceptable, space not a concern
 * When NOT to use: In-place required, space constraints tight
 * 
 * Time Complexity: O(n) - single pass through characters
 * Space Complexity: O(n) - StringBuilder storage
 */
class Solution {
    public int compress(char[] chars) {
        StringBuilder compressed = new StringBuilder();
        int i = 0;
        
        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;
            
            // Count consecutive characters
            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }
            
            // Append character
            compressed.append(currentChar);
            
            // Append count if more than 1
            if (count > 1) {
                compressed.append(count);
            }
        }
        
        // Copy compressed string back to array
        String result = compressed.toString();
        for (int j = 0; j < result.length(); j++) {
            chars[j] = result.charAt(j);
        }
        
        return result.length();
    }
}

/*
Example Walkthrough:
chars = ["a","a","b","b","c","c","c"]

i = 0, currentChar = 'a':
  Count consecutive 'a': count = 2
  compressed.append('a'), compressed.append('2')
  compressed = "a2"

i = 2, currentChar = 'b':
  Count consecutive 'b': count = 2
  compressed.append('b'), compressed.append('2')
  compressed = "a2b2"

i = 4, currentChar = 'c':
  Count consecutive 'c': count = 3
  compressed.append('c'), compressed.append('3')
  compressed = "a2b2c3"

Copy back to chars:
chars[0] = 'a', chars[1] = '2', chars[2] = 'b', chars[3] = '2', chars[4] = 'c', chars[5] = '3'

Return 6

Another example with single characters:
chars = ["a","b","c"]

i = 0, currentChar = 'a':
  Count = 1, compressed.append('a')
  compressed = "a"

i = 1, currentChar = 'b':
  Count = 1, compressed.append('b')
  compressed = "ab"

i = 2, currentChar = 'c':
  Count = 1, compressed.append('c')
  compressed = "abc"

Return 3

Why this works:
- StringBuilder allows efficient string building
- Counting consecutive characters handles compression
- Single character case handled by count check
- Final copy ensures in-place requirement

Trade-offs:
- Time: O(n) - efficient
- Space: O(n) - needs extra storage
- Simple and readable
- Easy to implement and debug
- May not meet strict in-place requirements

When this is good:
- Code simplicity is prioritized
- Space constraints are not strict
- Quick implementation needed
- Learning the compression concept
*/
