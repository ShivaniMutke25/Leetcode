import java.util.*;
import java.util.stream.Collectors;

public class Main {
    
    /**
     * Find the first non-repeating character in a string
     * 
     * Approach:
     * - Count frequency of each character
     * - Stream string in original order
     * - Filter for characters with count == 1
     * - Return first match using findFirst()
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(k) where k is unique characters
     */
    public static Character firstNonRepeatingCharacter(String s) {
        Map<Character, Long> charCount = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        c -> c,
                        Collectors.counting()
                ));
        
        return s.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> charCount.get(c) == 1)
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Alternative: More concise using LinkedHashMap to preserve order
     */
    public static Character firstNonRepeatingCharacterV2(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        c -> c,
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }
    
    public static void main(String[] args) {
        // Test Case 1: Standard case
        String s1 = "leetcode";
        System.out.println("Test Case 1:");
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Output: " + firstNonRepeatingCharacter(s1));
        System.out.println();
        
        // Test Case 2: First character is non-repeating
        String s2 = "abcdefg";
        System.out.println("Test Case 2:");
        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Output: " + firstNonRepeatingCharacter(s2));
        System.out.println();
        
        // Test Case 3: All characters repeat
        String s3 = "aabbcc";
        System.out.println("Test Case 3:");
        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("Output: " + firstNonRepeatingCharacter(s3));
        System.out.println();
        
        // Test Case 4: Single character
        String s4 = "a";
        System.out.println("Test Case 4:");
        System.out.println("Input: \"" + s4 + "\"");
        System.out.println("Output: " + firstNonRepeatingCharacter(s4));
        System.out.println();
        
        // Test Case 5: Non-repeating in middle
        String s5 = "aabcdbef";
        System.out.println("Test Case 5:");
        System.out.println("Input: \"" + s5 + "\"");
        System.out.println("Output: " + firstNonRepeatingCharacter(s5));
    }
}
