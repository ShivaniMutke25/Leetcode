/**
 * Horizontal Scan Approach - Longest Common Prefix
 * 
 * Logic:
 * - Start with first string as current prefix
 * - Iteratively compare current prefix with each string
 * - Shorten prefix if it doesn't match
 * - Continue until all strings processed
 * 
 * When to use: When string count is small, iterative approach preferred
 * When NOT to use: Many strings - more comparisons than vertical scan
 * 
 * Time Complexity: O(mn) - m = avg string length, n = number of strings
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        
        String prefix = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            // Shorten prefix until it matches current string
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        
        return prefix;
    }
}

/*
Example Walkthrough:
strs = ["flower","flow","flight"]

prefix = "flower"

i = 1, strs[1] = "flow":
  "flow".indexOf("flower") = -1 ≠ 0
  prefix = "flowe"
  "flow".indexOf("flowe") = -1 ≠ 0
  prefix = "flow"
  "flow".indexOf("flow") = 0 ✓
  prefix = "flow"

i = 2, strs[2] = "flight":
  "flight".indexOf("flow") = -1 ≠ 0
  prefix = "flo"
  "flight".indexOf("flo") = -1 ≠ 0
  prefix = "fl"
  "flight".indexOf("fl") = 0 ✓
  prefix = "fl"

Result: "fl"

Another example:
strs = ["interview","intermediate","internal"]

prefix = "interview"

i = 1, strs[1] = "intermediate":
  "intermediate".indexOf("interview") = -1 ≠ 0
  prefix = "intervie"
  "intermediate".indexOf("intervie") = -1 ≠ 0
  ...
  prefix = "inter"
  "intermediate".indexOf("inter") = 0 ✓
  prefix = "inter"

i = 2, strs[2] = "internal":
  "internal".indexOf("inter") = 0 ✓
  prefix = "inter"

Result: "inter"

Why this works:
- Start with longest possible prefix (first string)
- Systematically shorten until it fits all strings
- indexOf() == 0 means string starts with prefix
- Each iteration reduces prefix length or confirms it

Trade-offs:
- Time: O(mn) - each prefix check is O(m), n strings
- Space: O(1) - constant extra space
- Simpler to implement than vertical scan
- May do more work than vertical scan in worst case

When this is good:
- String count is small
- Prefix is relatively long
- Prefer iterative over nested loops
*/
