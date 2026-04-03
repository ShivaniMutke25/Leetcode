import java.util.*;
import java.util.stream.Collectors;

public class Main {
    
    /**
     * Find frequency of each element using Java Streams
     * 
     * Approach:
     * - Use groupingBy() to group elements by their value
     * - Use counting() as downstream collector to count occurrences
     * 
     * Time Complexity: O(n) - where n is number of elements
     * Space Complexity: O(k) - where k is number of unique elements
     */
    public static Map<Integer, Long> frequencyOfElements(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.groupingBy(
                        num -> num,  // classifier: group by the element itself
                        Collectors.counting()  // downstream collector: count occurrences
                ));
    }
    
    /**
     * Alternative approach: Using a simpler forEach with Map
     * (For comparison - less functional, but more explicit)
     */
    public static Map<Integer, Long> frequencyOfElementsAlternative(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.toMap(
                        num -> num,  // key: the element
                        num -> 1L,   // value: initial count 1
                        Long::sum    // merge function: sum counts if key exists
                ));
    }
    
    public static void main(String[] args) {
        // Test Case 1: Mixed frequencies
        List<Integer> numbers1 = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
        System.out.println("Test Case 1:");
        System.out.println("Input: " + numbers1);
        System.out.println("Output: " + frequencyOfElements(numbers1));
        System.out.println();
        
        // Test Case 2: All unique elements
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Test Case 2:");
        System.out.println("Input: " + numbers2);
        System.out.println("Output: " + frequencyOfElements(numbers2));
        System.out.println();
        
        // Test Case 3: All same elements
        List<Integer> numbers3 = Arrays.asList(5, 5, 5, 5);
        System.out.println("Test Case 3:");
        System.out.println("Input: " + numbers3);
        System.out.println("Output: " + frequencyOfElements(numbers3));
        System.out.println();
        
        // Test Case 4: Single element
        List<Integer> numbers4 = Arrays.asList(10);
        System.out.println("Test Case 4:");
        System.out.println("Input: " + numbers4);
        System.out.println("Output: " + frequencyOfElements(numbers4));
        System.out.println();
        
        // Test Case 5: Empty list
        List<Integer> numbers5 = new ArrayList<>();
        System.out.println("Test Case 5:");
        System.out.println("Input: " + numbers5);
        System.out.println("Output: " + frequencyOfElements(numbers5));
    }
}
