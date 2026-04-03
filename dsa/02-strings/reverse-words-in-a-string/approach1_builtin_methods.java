/**
 * Built-in Methods Approach - Reverse Words in a String
 * 
 * Logic:
 * - Split string by spaces to get words
 * - Reverse the array of words
 * - Join words back with single spaces
 * 
 * When to use: Quick solution, language features allowed
 * When NOT to use: Manual implementation required, space constraints tight
 * 
 * Time Complexity: O(n) - split, reverse, and join operations
 * Space Complexity: O(n) - array of words and result string
 */
class Solution {
    public String reverseWords(String s) {
        // Trim leading/trailing spaces and split by one or more spaces
        String[] words = s.trim().split("\\s+");
        
        // Reverse the array of words
        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        
        // Join words with single spaces
        return String.join(" ", words);
    }
}

/*
Example Walkthrough:
s = "the sky is blue"

1. s.trim() = "the sky is blue" (no leading/trailing spaces)
2. s.split("\\s+") = ["the", "sky", "is", "blue"]

3. Reverse array:
   ["the", "sky", "is", "blue"]
   ["blue", "sky", "is", "the"]
   ["blue", "is", "sky", "the"]

4. String.join(" ", words) = "blue is sky the"

Another example with multiple spaces:
s = "  hello   world  "

1. s.trim() = "hello   world"
2. s.split("\\s+") = ["hello", "world"]

3. Reverse array:
   ["world", "hello"]

4. String.join(" ", words) = "world hello"

Why this works:
- trim() removes leading/trailing spaces
- split("\\s+") handles multiple consecutive spaces
- reverse() reverses word order
- join() reconstructs string with single spaces

Trade-offs:
- Time: O(n) - efficient
- Space: O(n) - needs extra space for word array
- Simple and readable
- Uses language built-in features
- May not be allowed in some interview settings

When this is good:
- Quick implementation needed
- Language features are allowed
- Code readability is prioritized
- Space constraints are not tight
*/
