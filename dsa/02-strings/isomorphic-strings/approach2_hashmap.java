/**
 * HashMap Approach - Isomorphic Strings (OPTIMAL)
 * 
 * Logic:
 * - Use two HashMaps to track character mappings in both directions
 * - sToT maps characters from s to t
 * - tToS maps characters from t to s (for bijection check)
 * - For each character pair, check if mapping conflicts
 * 
 * When to use: Always - optimal solution
 * When NOT to use: Never, this is perfect for all cases
 * 
 * Time Complexity: O(n) - single pass through strings
 * Space Complexity: O(1) - constant space (fixed character set)
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        
        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            
            // Check mapping from s to t
            if (sToT.containsKey(sChar)) {
                if (sToT.get(sChar) != tChar) {
                    return false; // sChar maps to different tChar
                }
            } else {
                sToT.put(sChar, tChar);
            }
            
            // Check mapping from t to s (bijection)
            if (tToS.containsKey(tChar)) {
                if (tToS.get(tChar) != sChar) {
                    return false; // tChar already mapped to different sChar
                }
            } else {
                tToS.put(tChar, sChar);
            }
        }
        
        return true;
    }
}

/*
Example Walkthrough:
s = "egg", t = "add"

Initialize: sToT = {}, tToS = {}

i = 0: sChar = 'e', tChar = 'a'
  sToT doesn't contain 'e', so sToT.put('e', 'a')
  tToS doesn't contain 'a', so tToS.put('a', 'e')
  sToT = {'e':'a'}, tToS = {'a':'e'}

i = 1: sChar = 'g', tChar = 'd'
  sToT doesn't contain 'g', so sToT.put('g', 'd')
  tToS doesn't contain 'd', so tToS.put('d', 'g')
  sToT = {'e':'a', 'g':'d'}, tToS = {'a':'e', 'd':'g'}

i = 2: sChar = 'g', tChar = 'd'
  sToT.get('g') = 'd' == tChar ✓
  tToS.get('d') = 'g' == sChar ✓
  No conflicts

Result: true

Another example (not isomorphic):
s = "foo", t = "bar"

i = 0: sChar = 'f', tChar = 'b'
  sToT = {'f':'b'}, tToS = {'b':'f'}

i = 1: sChar = 'o', tChar = 'a'
  sToT = {'f':'b', 'o':'a'}, tToS = {'b':'f', 'a':'o'}

i = 2: sChar = 'o', tChar = 'r'
  sToT.get('o') = 'a' != 'r' → return false

Result: false

Why this works:
- sToT ensures each character in s maps consistently to t
- tToS ensures no two characters in s map to same character in t
- Together they ensure bijection (one-to-one and onto mapping)
- Single pass through strings checks all character pairs

Why two HashMaps:
- Single HashMap only checks s→t mapping
- Could miss cases where multiple s characters map to same t character
- tToS ensures the mapping is bijective

Space complexity is O(1) because:
- Maximum unique characters is limited by character set size
- For ASCII: 256 characters maximum
- For Unicode: still bounded by practical limits

This is the perfect solution!
*/
