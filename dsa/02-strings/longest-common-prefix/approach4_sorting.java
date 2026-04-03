/**
 * Sorting Approach - Longest Common Prefix
 * 
 * Logic:
 * - Sort all strings lexicographically
 * - Common prefix of first and last string is the answer
 * - Because sorted strings with common prefix will be adjacent
 * 
 * When to use: When sorting is acceptable, simpler logic
 * When NOT to use: When O(mn) time is required (sorting adds log n factor)
 * 
 * Time Complexity: O(mn log n) - sorting + one comparison
 * Space Complexity: O(1) - constant space (ignoring sort space)
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        
        // Sort strings lexicographically
        Arrays.sort(strs);
        
        // Compare first and last string
        String first = strs[0];
        String last = strs[strs.length - 1];
        
        int i = 0;
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }
        
        return first.substring(0, i);
    }
}

/*
Example Walkthrough:
strs = ["flower","flow","flight"]

Sort: ["flight","flow","flower"]

first = "flight", last = "flower"

i = 0: first[0] = 'f', last[0] = 'f' → match, i = 1
i = 1: first[1] = 'l', last[1] = 'l' → match, i = 2
i = 2: first[2] = 'i', last[2] = 'o' → mismatch, stop

Result: "fl"

Why this works:
- After sorting, strings with common prefix are grouped together
- First and last strings have the smallest common prefix
- Any other pair will have at least this much common prefix
- If first and last differ at position i, all strings differ by then

Example with more strings:
strs = ["apple","application","apply","apt"]
Sort: ["app","apple","application","apply","apt"]
first = "app", last = "apt"
Common prefix = "ap"

Original unsorted order:
"apple" vs "apt" = "ap" ✓
"application" vs "apt" = "ap" ✓
"apply" vs "apt" = "ap" ✓
"app" vs "apt" = "ap" ✓

Trade-offs:
- Time: O(mn log n) due to sorting
- Space: O(1) (ignoring sort overhead)
- Very simple implementation
- Sorting overhead may be significant for large n

When this is useful:
- Code simplicity is prioritized
- n is relatively small
- Sorting cost is acceptable
- Want to avoid nested loops

This approach is elegant but not optimal for large inputs.
*/
