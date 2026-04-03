/**
 * Two Pointers Approach - Reverse Words in a String (OPTIMAL)
 * 
 * Logic:
 * - Process string from end to beginning using two pointers
 * - Skip spaces, then extract each word
 * - Build result by appending words in reverse order
 * - Handle multiple spaces and edge cases
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - single pass through string
 * Space Complexity: O(1) - constant extra space (ignoring output)
 */
class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;
        
        while (i >= 0) {
            // Skip trailing spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            
            if (i < 0) break;
            
            // Find the start of the current word
            int j = i;
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }
            
            // Extract the word
            String word = s.substring(j + 1, i + 1);
            
            // Append word to result
            if (result.length() > 0) {
                result.append(' ');
            }
            result.append(word);
            
            // Move to next word
            i = j - 1;
        }
        
        return result.toString();
    }
}

/*
Example Walkthrough:
s = "the sky is blue", i = 14

i = 14:
  Skip trailing spaces (none)
  Find word start:
    j = 14, s[14] = 'e'
    j = 13, s[13] = 'u'
    j = 12, s[12] = 'l'
    j = 11, s[11] = 'b'
    j = 10, s[10] = ' ' → stop
  word = s.substring(11, 15) = "blue"
  result = "blue"
  i = 9

i = 9:
  Skip spaces: s[9] = ' ' → i = 8
  Find word start:
    j = 8, s[8] = 's'
    j = 7, s[7] = 'i'
    j = 6, s[6] = ' ' → stop
  word = s.substring(7, 9) = "is"
  result = "blue is"
  i = 5

i = 5:
  Skip spaces: s[5] = ' ' → i = 4
  Find word start:
    j = 4, s[4] = 'y'
    j = 3, s[3] = 'k'
    j = 2, s[2] = 's'
    j = 1, s[1] = 'h'
    j = 0, s[0] = 't'
    j = -1 → stop
  word = s.substring(0, 5) = "the"
  result = "blue is the"
  i = -2

i = -2 < 0 → stop

Result: "blue is the"

Another example with multiple spaces:
s = "  hello   world  ", i = 14

i = 14:
  Skip trailing spaces: i = 13, 12
  Find word: j = 12..7, word = "world"
  result = "world", i = 6

i = 6:
  Skip spaces: i = 5, 4, 3
  Find word: j = 3..-1, word = "hello"
  result = "world hello", i = -2

Result: "world hello"

Why this works:
- Processing from end to beginning builds result in correct order
- Skip spaces handles multiple consecutive spaces
- Two pointers efficiently find word boundaries
- StringBuilder allows efficient string building

Why this is optimal:
- Time: O(n) - single pass through string
- Space: O(1) - constant extra space (ignoring output)
- No extra data structures needed
- Handles all edge cases properly
- In-place processing logic

Key insights:
- Process backwards to avoid final reversal
- Skip spaces to handle multiple spaces
- Extract words using substring
- Build result incrementally

This is the perfect solution!
*/
