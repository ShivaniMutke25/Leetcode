import java.util.*;
import java.util.stream.Collectors;

public class Main {
    
    /**
     * Find the first repeating character in a string
     * 
     * Approach:
     * - Count frequency of each character
     * - Stream string in original order
     * - Filter for characters with count > 1
     * - Return first match
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(k) where k is unique characters
     */
    public static Character firstRepeatingCharacter(String s) {
        Map<Character, Long> charCount = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        c -> c,
                        Collectors.counting()
                ));
        
        return s.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> charCount.get(c) > 1)
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Alternative: Using LinkedHashMap to maintain insertion order
     */
    public static Character firstRepeatingCharacterV2(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        c -> c,
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }
    
    public static void main(String[] args) {
        // Test Case 1: Standard case
        String s1 = "abcabd";
        System.out.println("Test Case 1:");
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Output: " + firstRepeatingCharacter(s1));
        System.out.println();
        
        // Test Case 2: Repeating character at end
        String s2 = "abcdef";
        System.out.println("Test Case 2:");
        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Output: " + firstRepeatingCharacter(s2));
        System.out.println();
        
        // Test Case 3: Multiple repeating, first one is 'a'
        String s3 = "aabbcc";
        System.out.println("Test Case 3:");
        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("Output: " + firstRepeatingCharacter(s3));
        System.out.println();
        
        // Test Case 4: Single character
        String s4 = "a";
        System.out.println("Test Case 4:");
        System.out.println("Input: \"" + s4 + "\"");
        System.out.println("Output: " + firstRepeatingCharacter(s4));
        System.out.println();
        
        // Test Case 5: Repeating in middle
        String s5 = "abcdeabc";
        System.out.println("Test Case 5:");
        System.out.println("Input: \"" + s5 + "\"");
        System.out.println("Output: " + firstRepeatingCharacter(s5));
    }
}
