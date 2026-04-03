import java.util.*;
import java.util.stream.Collectors;

public class Main {
    
    /**
     * Sort strings by length in ascending order
     * 
     * Approach:
     * - Use sorted() with Comparator.comparingInt(String::length)
     * - This naturally sorts in ascending order
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
    
    /**
     * Sort strings by length in descending order (longest first)
     */
    public static List<String> sortByLengthDescending(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
    }
    
    /**
     * Sort by length, then alphabetically by name if same length
     */
    public static List<String> sortByLengthThenAlphabetically(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }
    
    /**
     * Sort and return as array
     */
    public static String[] sortByLengthAsArray(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toArray(String[]::new);
    }
    
    public static void main(String[] args) {
        // Test Case 1: Mixed lengths
        List<String> test1 = Arrays.asList("apple", "kiwi", "banana", "a");
        System.out.println("Test Case 1: Ascending");
        System.out.println("Input: " + test1);
        System.out.println("Output: " + sortByLength(test1));
        System.out.println();
        
        // Test Case 2: Descending order
        System.out.println("Test Case 2: Descending");
        System.out.println("Input: " + test1);
        System.out.println("Output: " + sortByLengthDescending(test1));
        System.out.println();
        
        // Test Case 3: Equal lengths (secondary sort)
        List<String> test3 = Arrays.asList("dog", "cat", "bat", "elephant");
        System.out.println("Test Case 3: By length then alphabetically");
        System.out.println("Input: " + test3);
        System.out.println("Output: " + sortByLengthThenAlphabetically(test3));
        System.out.println();
        
        // Test Case 4: Single element
        List<String> test4 = Arrays.asList("hello");
        System.out.println("Test Case 4: Single element");
        System.out.println("Input: " + test4);
        System.out.println("Output: " + sortByLength(test4));
        System.out.println();
        
        // Test Case 5: All same length
        List<String> test5 = Arrays.asList("cat", "dog", "bat");
        System.out.println("Test Case 5: All same length");
        System.out.println("Input: " + test5);
        System.out.println("Output: " + sortByLength(test5));
        System.out.println();
        
        // Test Case 6: Array output
        System.out.println("Test Case 6: As array");
        System.out.println("Input: " + test1);
        System.out.println("Output: " + Arrays.toString(sortByLengthAsArray(test1)));
    }
}
