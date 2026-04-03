/**
 * Recursive Approach - Decode String
 * 
 * Logic:
 * - Use recursion to handle nested brackets
 * - When encountering '[', recursively decode the substring
 * - When encountering ']', return the decoded substring and remaining string
 * - Build result by concatenating decoded parts
 * 
 * When to use: Simple recursive logic, understanding of recursion
 * When NOT to use: Very deep nesting (stack overflow risk)
 * 
 * Time Complexity: O(n) - each character processed once
 * Space Complexity: O(n) - recursion stack + result
 */
class Solution {
    public String decodeString(String s) {
        return decodeHelper(s, 0).decoded;
    }
    
    private Result decodeHelper(String s, int index) {
        StringBuilder current = new StringBuilder();
        int num = 0;
        
        while (index < s.length()) {
            char c = s.charAt(index);
            
            if (Character.isDigit(c)) {
                // Build the number
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                // Recursively decode the substring
                Result result = decodeHelper(s, index + 1);
                // Repeat the decoded substring num times
                for (int i = 0; i < num; i++) {
                    current.append(result.decoded);
                }
                index = result.nextIndex;
                num = 0; // Reset number
            } else if (c == ']') {
                // Return current result and next index
                return new Result(current.toString(), index + 1);
            } else {
                // Regular character, append to current
                current.append(c);
            }
            index++;
        }
        
        return new Result(current.toString(), index);
    }
    
    private static class Result {
        String decoded;
        int nextIndex;
        
        Result(String decoded, int nextIndex) {
            this.decoded = decoded;
            this.nextIndex = nextIndex;
        }
    }
}

/*
Example Walkthrough:
s = "3[a]2[bc]"

decodeHelper(s, 0):
  current = "", num = 0, index = 0
  
  c = '3': num = 3
  c = '[': 
    decodeHelper(s, 2):
      current = "", num = 0, index = 2
      c = 'a': current = "a"
      c = ']': return new Result("a", 4)
    
    Repeat "a" 3 times: current = "aaa"
    index = 4, num = 0
  
  c = '2': num = 2
  c = '[':
    decodeHelper(s, 6):
      current = "", num = 0, index = 6
      c = 'b': current = "b"
      c = 'c': current = "bc"
      c = ']': return new Result("bc", 9)
    
    Repeat "bc" 2 times: current = "aaabcbc"
    index = 9, num = 0

Return "aaabcbc"

Why this works:
- Recursion naturally handles nested structures
- Each recursive call handles one level of brackets
- Result class carries both decoded string and next position
- Multi-digit numbers are built correctly

Trade-offs:
- Time: O(n) - optimal
- Space: O(n) - recursion stack
- Simplicity: Clean, intuitive logic
- Limitation: Risk of stack overflow for very deep nesting

When this is good:
- Learning recursion concepts
- Simple implementation needed
- Nesting depth is reasonable
*/
