/**
 * HashMap with Sorted Key Approach - Group Anagrams (OPTIMAL)
 * 
 * Logic:
 * - Use HashMap to group strings by their sorted character signature
 * - For each string, sort its characters to create canonical key
 * - Strings with same sorted key are anagrams
 * - Add string to corresponding group in HashMap
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(nklogk) - n strings, each sorted (k = avg length)
 * Space Complexity: O(nk) - HashMap stores all strings
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        
        for (String str : strs) {
            // Create canonical key by sorting characters
            String key = sortString(str);
            
            // Add string to its anagram group
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(str);
        }
        
        return new ArrayList<>(groups.values());
    }
    
    private String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}

/*
Example Walkthrough:
strs = ["eat","tea","tan","ate","nat","bat"]

Initialize: groups = {}

str = "eat":
  key = sortString("eat") = "aet"
  groups.putIfAbsent("aet", []) → groups = {"aet": []}
  groups.get("aet").add("eat") → groups = {"aet": ["eat"]}

str = "tea":
  key = sortString("tea") = "aet"
  groups.get("aet").add("tea") → groups = {"aet": ["eat","tea"]}

str = "tan":
  key = sortString("tan") = "ant"
  groups.putIfAbsent("ant", []) → groups = {"aet": ["eat","tea"], "ant": []}
  groups.get("ant").add("tan") → groups = {"aet": ["eat","tea"], "ant": ["tan"]}

str = "ate":
  key = sortString("ate") = "aet"
  groups.get("aet").add("ate") → groups = {"aet": ["eat","tea","ate"], "ant": ["tan"]}

str = "nat":
  key = sortString("nat") = "ant"
  groups.get("ant").add("nat") → groups = {"aet": ["eat","tea","ate"], "ant": ["tan","nat"]}

str = "bat":
  key = sortString("bat") = "abt"
  groups.putIfAbsent("abt", []) → groups = {"aet": ["eat","tea","ate"], "ant": ["tan","nat"], "abt": []}
  groups.get("abt").add("bat") → groups = {"aet": ["eat","tea","ate"], "ant": ["tan","nat"], "abt": ["bat"]}

Result: [["eat","tea","ate"], ["tan","nat"], ["bat"]]

Why this works:
- Anagrams have identical sorted character sequences
- HashMap groups strings by their canonical sorted form
- Each group contains all strings that are anagrams of each other
- Single pass through all strings

Optimization details:
- Sorting each string takes O(klogk) where k is string length
- HashMap operations are O(1) average
- Total time: O(nklogk) where n is number of strings
- Space: O(nk) to store all strings in groups

Alternative optimization:
- If alphabet size is small (26 lowercase), we could use counting sort
- This would reduce sorting to O(k) instead of O(klogk)
- Total time would be O(nk) instead of O(nklogk)

Why this is optimal:
- Time: O(nklogk) - efficient for typical constraints
- Space: O(nk) - necessary to store all strings
- Clean, intuitive logic
- Handles any number of anagram groups
- No redundant comparisons

This is the perfect solution!
*/
