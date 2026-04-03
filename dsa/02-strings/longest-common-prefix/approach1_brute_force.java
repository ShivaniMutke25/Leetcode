/**
 * Brute Force Approach - Longest Common Prefix
 * 
 * Logic:
 * - Generate all possible prefixes from first string
 * - For each prefix, check if it exists in all other strings
 * - Return the longest prefix that works
 * 
 * When to use: Understanding the problem, very small inputs
 * When NOT to use: Any realistic input - inefficient
 * 
 * Time Complexity: O(m²n) - m prefixes, each checked against n strings
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        
        String first = strs[0];
        String longestPrefix = "";
        
        // Generate all possible prefixes from first string
        for (int i = 1; i <= first.length(); i++) {
            String prefix = first.substring(0, i);
            
            // Check if this prefix exists in all strings
            boolean allHavePrefix = true;
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(prefix)) {
                    allHavePrefix = false;
                    break;
                }
            }
            
            if (allHavePrefix) {
                longestPrefix = prefix;
            } else {
                break; // No longer prefixes will work
            }
        }
        
        return longestPrefix;
    }
}

/*
Example Walkthrough:
strs = ["flower","flow","flight"]

first = "flower"

i = 1: prefix = "f"
  Check all strings start with "f":
    "flower".startsWith("f") ✓
    "flow".startsWith("f") ✓
    "flight".startsWith("f") ✓
  longestPrefix = "f"

i = 2: prefix = "fl"
  Check all strings start with "fl":
    "flower".startsWith("fl") ✓
    "flow".startsWith("fl") ✓
    "flight".startsWith("fl") ✓
  longestPrefix = "fl"

i = 3: prefix = "flo"
  Check all strings start with "flo":
    "flower".startsWith("flo") ✓
    "flow".startsWith("flo") ✓
    "flight".startsWith("flo") ✗
  allHavePrefix = false, break

Result: "fl"

Why this is inefficient:
- Generates all possible prefixes (m possibilities)
- For each prefix, checks all strings (n strings)
- Total: O(m * n) prefix checks
- Each startsWith() is O(m) in worst case
- Overall: O(m²n) time complexity

Key limitation: Redundant checking of shorter prefixes when longer ones fail
*/
