import java.util.*;
import java.util.stream.Collectors;

public class Main {
    
    /**
     * Find the longest string in a list
     * 
     * Approach:
     * - Use max() with Comparator.comparingInt(String::length)
     * - This compares strings by their length
     * - Returns Optional containing the longest string
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static String longestString(List<String> strings) {
        return strings.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
    }
    
    /**
     * Alternative: Using reduce to find longest
     */
    public static String longestStringAlternative(List<String> strings) {
        return strings.stream()
                .reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2)
                .orElse(null);
    }
    
    /**
     * Get all strings with maximum length
     */
    public static List<String> allLongestStrings(List<String> strings) {
        int maxLength = strings.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
        
        return strings.stream()
                .filter(s -> s.length() == maxLength)
                .collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
        // Test Case 1: Standard case
        List<String> test1 = Arrays.asList("apple", "banana", "kiwi", "watermelon");
        System.out.println("Test Case 1:");
        System.out.println("Input: " + test1);
        System.out.println("Longest: " + longestString(test1));
        System.out.println();
        
        // Test Case 2: All same length
        List<String> test2 = Arrays.asList("cat", "dog", "bat");
        System.out.println("Test Case 2:");
        System.out.println("Input: " + test2);
        System.out.println("Longest: " + longestString(test2));
        System.out.println("All longest: " + allLongestStrings(test2));
        System.out.println();
        
        // Test Case 3: Single element
        List<String> test3 = Arrays.asList("hello");
        System.out.println("Test Case 3:");
        System.out.println("Input: " + test3);
        System.out.println("Longest: " + longestString(test3));
        System.out.println();
        
        // Test Case 4: Empty strings
        List<String> test4 = Arrays.asList("", "a", "bb", "");
        System.out.println("Test Case 4:");
        System.out.println("Input: " + test4);
        System.out.println("Longest: " + longestString(test4));
        System.out.println();
        
        // Test Case 5: Empty list
        List<String> test5 = new ArrayList<>();
        System.out.println("Test Case 5:");
        System.out.println("Input: " + test5);
        System.out.println("Longest: " + longestString(test5));
        System.out.println();
        
        // Test Case 6: Multiple strings with same max length
        List<String> test6 = Arrays.asList("java", "code", "rust");
        System.out.println("Test Case 6:");
        System.out.println("Input: " + test6);
        System.out.println("Longest: " + longestString(test6));
        System.out.println("All longest: " + allLongestStrings(test6));
    }
}
