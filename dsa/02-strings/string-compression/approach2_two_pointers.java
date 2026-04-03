/**
 * Two Pointers Approach - String Compression (OPTIMAL)
 * 
 * Logic:
 * - Use two pointers: read for scanning, write for building result
 * - Count consecutive characters and write character + count
 * - Handle single characters by only writing character
 * - Modify array in-place and return write pointer position
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - single pass through characters
 * Space Complexity: O(1) - constant extra space
 */
class Solution {
    public int compress(char[] chars) {
        int write = 0; // Write pointer
        int read = 0;  // Read pointer
        
        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;
            
            // Count consecutive characters
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }
            
            // Write the character
            chars[write] = currentChar;
            write++;
            
            // Write the count if more than 1
            if (count > 1) {
                // Convert count to string and write each digit
                String countStr = String.valueOf(count);
                for (int i = 0; i < countStr.length(); i++) {
                    chars[write] = countStr.charAt(i);
                    write++;
                }
            }
        }
        
        return write;
    }
}

/*
Example Walkthrough:
chars = ["a","a","b","b","c","c","c"]
write = 0, read = 0

read = 0, currentChar = 'a':
  Count consecutive 'a': read = 2, count = 2
  chars[write] = 'a', write = 1
  count > 1, countStr = "2":
    chars[1] = '2', write = 2

read = 2, currentChar = 'b':
  Count consecutive 'b': read = 4, count = 2
  chars[write] = 'b', write = 3
  count > 1, countStr = "2":
    chars[3] = '2', write = 4

read = 4, currentChar = 'c':
  Count consecutive 'c': read = 7, count = 3
  chars[write] = 'c', write = 5
  count > 1, countStr = "3":
    chars[5] = '3', write = 6

read = 7 (end)
Return write = 6

Final chars: ['a','2','b','2','c','3',...]

Another example with multiple digit count:
chars = ["a","a","a","a","a","a","b","b","b","b","b","b","b","b","b","b","b","b","b","b","c","c"]

read = 0, currentChar = 'a':
  Count = 6, chars[0] = 'a', write = 1
  countStr = "6":
    chars[1] = '6', write = 2

read = 6, currentChar = 'b':
  Count = 12, chars[2] = 'b', write = 3
  countStr = "12":
    chars[3] = '1', write = 4
    chars[4] = '2', write = 5

read = 18, currentChar = 'c':
  Count = 2, chars[5] = 'c', write = 6
  countStr = "2":
    chars[6] = '2', write = 7

Return write = 7

Final chars: ['a','6','b','1','2','c','2',...]

Another example with single characters:
chars = ["a","b","c"]

read = 0, currentChar = 'a':
  Count = 1, chars[0] = 'a', write = 1
  count <= 1, don't write count

read = 1, currentChar = 'b':
  Count = 1, chars[1] = 'b', write = 2
  count <= 1, don't write count

read = 2, currentChar = 'c':
  Count = 1, chars[2] = 'c', write = 3
  count <= 1, don't write count

Return write = 3

Why this works:
- Two pointers allow in-place modification
- Read pointer scans original array
- Write pointer builds compressed result
- Count string handles multi-digit counts
- Single character case handled by count check

Why this is optimal:
- Time: O(n) - single pass through characters
- Space: O(1) - constant extra space
- In-place modification as required
- Handles all edge cases
- Efficient memory usage

Key insights:
- Two pointers separate reading and writing
- Count string handles multi-digit numbers
- Single characters don't need count written
- Write pointer position is the new length

This is the perfect solution!
*/
