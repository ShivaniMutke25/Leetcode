/**
 * Brute Force Approach - Isomorphic Strings
 * 
 * Logic:
 * - For each character in s, try to map it to a character in t
 * - Check if this mapping works for the entire strings
 * - Try all possible mappings until one works or all fail
 * 
 * When to use: Understanding the problem, very small inputs
 * When NOT to use: Any realistic input - will be extremely slow
 * 
 * Time Complexity: O(n²) - trying all possible mappings
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        
        return checkMapping(s, t, 0, new HashMap<>(), new HashMap<>());
    }
    
    private boolean checkMapping(String s, String t, int index, 
                                Map<Character, Character> sToT, 
                                Map<Character, Character> tToS) {
        if (index == s.length()) {
            return true; // Successfully mapped all characters
        }
        
        char sChar = s.charAt(index);
        char tChar = t.charAt(index);
        
        // Check if mapping already exists
        if (sToT.containsKey(sChar)) {
            if (sToT.get(sChar) != tChar) {
                return false; // Mapping conflict
            }
        } else {
            if (tToS.containsKey(tChar)) {
                return false; // tChar already mapped to different sChar
            }
            
            // Try this mapping
            sToT.put(sChar, tChar);
            tToS.put(tChar, sChar);
            
            // Recursively check rest of string
            if (checkMapping(s, t, index + 1, sToT, tToS)) {
                return true;
            }
            
            // Backtrack if this mapping doesn't work
            sToT.remove(sChar);
            tToS.remove(tChar);
        }
        
        // Continue with current mapping
        return checkMapping(s, t, index + 1, sToT, tToS);
    }
}

/*
Example Walkthrough:
s = "egg", t = "add"

index = 0, sChar = 'e', tChar = 'a':
  sToT = {}, tToS = {}
  No existing mappings, try mapping 'e' -> 'a'
  sToT = {'e':'a'}, tToS = {'a':'e'}
  
  index = 1, sChar = 'g', tChar = 'd':
    sToT = {'e':'a'}, tToS = {'a':'e'}
    No existing mappings for 'g' and 'd'
    Try mapping 'g' -> 'd'
    sToT = {'e':'a', 'g':'d'}, tToS = {'a':'e', 'd':'g'}
    
    index = 2, sChar = 'g', tChar = 'd':
      sToT.get('g') = 'd' == tChar ✓
      Continue to index = 3 (end)
      Return true

Result: true

Why this is slow:
- For each character, we might try multiple mappings
- Recursive backtracking explores many possibilities
- In worst case, exponential time complexity
- For n=50,000, this is completely impractical

Key limitation: No optimization to directly determine correct mapping
*/
