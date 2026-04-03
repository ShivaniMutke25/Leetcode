/**
 * Brute Force Approach - Valid Parentheses
 * 
 * Logic:
 * - Repeatedly remove matching pairs of brackets
 * - If string becomes empty, it's valid
 * - If no more pairs can be removed but string not empty, it's invalid
 * 
 * When to use: Learning the problem, understanding validation logic
 * When NOT to use: Any realistic input - inefficient
 * 
 * Time Complexity: O(n²) - multiple passes through string
 * Space Complexity: O(n) - string manipulation
 */
class Solution {
    public boolean isValid(String s) {
        String current = s;
        
        while (!current.isEmpty()) {
            String previous = current;
            
            // Remove all matching pairs
            current = current.replace("()", "");
            current = current.replace("[]", "");
            current = current.replace("{}", "");
            
            // If no changes made, no more pairs to remove
            if (current.equals(previous)) {
                break;
            }
        }
        
        return current.isEmpty();
    }
}

/*
Example Walkthrough:
s = "()[]{}"

current = "()[]{}"

First iteration:
  current.replace("()", "") = "[]{}"
  current.replace("[]", "") = "{}"
  current.replace("{}", "") = ""
  current != previous, continue

Second iteration:
  current = "" (empty)
  previous = ""
  current.equals(previous) ✓ but current is empty
  Return true

Another example:
s = "([)]"

current = "([)]"

First iteration:
  current.replace("()", "") = "([)]" (no change)
  current.replace("[]", "") = "([)]" (no change)
  current.replace("{}", "") = "([)]" (no change)
  current.equals(previous) ✓, break
  Return false (current not empty)

Another example:
s = "({[]})"

current = "({[]})"

First iteration:
  current.replace("()", "") = "({[]})" (no change)
  current.replace("[]", "") = "({})"
  current.replace("{}", "") = "()"
  current != previous, continue

Second iteration:
  current = "()"
  current.replace("()", "") = ""
  current.replace("[]", "") = ""
  current.replace("{}", "") = ""
  current != previous, continue

Third iteration:
  current = "" (empty)
  Return true

Why this works:
- Valid parentheses can be reduced by removing matching pairs
- If all pairs can be removed, string is valid
- If stuck with unremovable characters, string is invalid
- Multiple passes handle nested structures

Why this is inefficient:
- Multiple passes through string
- String replacement operations are expensive
- Time complexity O(n²) in worst case
- Not suitable for large inputs

When this is useful:
- Learning the problem concept
- Understanding validation logic
- Small inputs where efficiency not critical
- Educational purposes
*/
