/**
 * Brute Force Approach - Backspace String Compare
 * 
 * Logic:
 * - Simulate typing both strings character by character
 * - Handle backspace by removing previous character
 * - Compare final results
 * 
 * When to use: Understanding problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(n²) - O(n) processing × O(n) string operations
 * Space Complexity: O(n) - for building final strings
 */
class Solution {
    public boolean backspaceCompare(String s, String t) {
        return processString(s).equals(processString(t));
    }
    
    private String processString(String str) {
        StringBuilder result = new StringBuilder();
        
        for (char c : str.toCharArray()) {
            if (c == '#') {
                // Backspace: remove previous character if exists
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}

/*
Example Walkthrough:
s = "ab#c", t = "ad#c"

Process s:
'a' → result = "a"
'b' → result = "ab"
'#' → result = "a" (remove 'b')
'c' → result = "ac"

Process t:
'a' → result = "a"
'd' → result = "ad"
'#' → result = "a" (remove 'd')
'c' → result = "ac"

Compare: "ac" == "ac" → true

Result: true

Why this is inefficient:
- Building final strings requires O(n) space
- String operations (append, delete) are O(n) each
- Total: O(n²) time complexity
- Multiple passes through the data

Key limitation: Doesn't process strings efficiently in-place
*/
