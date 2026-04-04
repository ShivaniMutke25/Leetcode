/**
 * Brute Force Approach - Reverse Vowels of a String
 * 
 * Logic:
 * - Extract all vowels from the string
 * - Reverse the vowels
 * - Reconstruct string with reversed vowels
 * 
 * When to use: Understanding problem, very small inputs
 * When NOT to use: Any realistic input - will be too slow
 * 
 * Time Complexity: O(n²) - O(n) to extract + O(n) to reconstruct
 * Space Complexity: O(n) - for storing vowels
 */
class Solution {
    public String reverseVowels(String s) {
        // Extract vowels
        List<Character> vowels = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }
        
        // Reverse vowels
        Collections.reverse(vowels);
        
        // Reconstruct string
        StringBuilder result = new StringBuilder();
        int vowelIndex = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                result.append(vowels.get(vowelIndex++));
            } else {
                result.append(c);
            }
        }
        
        return result.toString();
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}

/*
Example Walkthrough:
s = "hello"

Extract vowels:
h: not vowel
e: vowel → vowels = [e]
l: not vowel
l: not vowel
o: vowel → vowels = [e, o]

Reverse vowels:
vowels = [o, e]

Reconstruct string:
h: not vowel → result = "h"
e: vowel → result = "ho"
l: not vowel → result = "hol"
l: not vowel → result = "holl"
o: vowel → result = "holle"

Result: "holle"

Why this is inefficient:
- Multiple passes through the string
- Extra space for storing vowels
- Reconstruction step is unnecessary work
- Could be done in-place with two pointers

Key limitation: Doesn't leverage in-place swapping capability
*/
