import java.util.*;
import java.util.stream.Collectors;

public class Main {
    
    /**
     * Find all duplicate elements in a list
     * 
     * Approach:
     * - Group elements and count their frequency
     * - Filter elements with frequency > 1
     * - Collect keys to get duplicates
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(k) where k is unique elements
     */
    public static List<Integer> findDuplicates(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.groupingBy(
                        num -> num,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
    
    /**
     * Alternative: Using LinkedHashSet to maintain order
     */
    public static Set<Integer> findDuplicatesAsSet(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.groupingBy(
                        num -> num,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
    
    public static void main(String[] args) {
        // Test Case 1: Mixed duplicates
        List<Integer> test1 = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
        System.out.println("Test Case 1:");
        System.out.println("Input: " + test1);
        System.out.println("Output: " + findDuplicates(test1));
        System.out.println();
        
        // Test Case 2: No duplicates
        List<Integer> test2 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Test Case 2:");
        System.out.println("Input: " + test2);
        System.out.println("Output: " + findDuplicates(test2));
        System.out.println();
        
        // Test Case 3: All duplicates
        List<Integer> test3 = Arrays.asList(1, 1, 2, 2, 3, 3);
        System.out.println("Test Case 3:");
        System.out.println("Input: " + test3);
        System.out.println("Output: " + findDuplicates(test3));
        System.out.println();
        
        // Test Case 4: Single element repeated
        List<Integer> test4 = Arrays.asList(5, 5, 5, 5);
        System.out.println("Test Case 4:");
        System.out.println("Input: " + test4);
        System.out.println("Output: " + findDuplicates(test4));
        System.out.println();
        
        // Test Case 5: Empty list
        List<Integer> test5 = new ArrayList<>();
        System.out.println("Test Case 5:");
        System.out.println("Input: " + test5);
        System.out.println("Output: " + findDuplicates(test5));
    }
}
