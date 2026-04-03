import java.util.*;
import java.util.stream.Collectors;

public class Main {
    
    /**
     * Filter out null values from a list
     * 
     * Approach:
     * - Stream the list
     * - Use filter(Objects::nonNull) to keep only non-null elements
     * - Collect to list
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(k) where k is non-null elements
     */
    public static <T> List<T> filterNullValues(List<T> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
    
    /**
     * Filter nulls and return as set (removes duplicates too)
     */
    public static <T> Set<T> filterNullValuesAsSet(List<T> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }
    
    /**
     * Count null and non-null values
     */
    public static <T> Map<String, Long> countNullness(List<T> list) {
        Map<String, Long> counts = new HashMap<>();
        counts.put("null", list.stream().filter(Objects::isNull).count());
        counts.put("nonNull", list.stream().filter(Objects::nonNull).count());
        return counts;
    }
    
    /**
     * Filter nulls while filtering other condition simultaneously
     */
    public static List<Integer> filterNullAndOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(Objects::nonNull)
                .filter(n -> n % 2 == 0)  // even numbers only
                .collect(Collectors.toList());
    }
    
    /**
     * Filter nulls with multiple conditions
     */
    public static List<String> filterNullAndEmptyStrings(List<String> strings) {
        return strings.stream()
                .filter(Objects::nonNull)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }
    
    /**
     * Get percentage of null values
     */
    public static double getNullPercentage(List<?> list) {
        if (list.isEmpty()) return 0;
        long nullCount = list.stream().filter(Objects::isNull).count();
        return (nullCount * 100.0) / list.size();
    }
    
    /**
     * Replace nulls with default value, but keep non-nulls
     * (Alternative to filtering)
     */
    public static <T> List<T> replaceNullsWithDefault(List<T> list, T defaultValue) {
        return list.stream()
                .map(item -> item == null ? defaultValue : item)
                .collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
        // Test Case 1: Basic null filtering
        List<String> items1 = Arrays.asList("apple", null, "banana", null, "cherry", null);
        System.out.println("Test Case 1: Filter null values");
        System.out.println("Input: " + items1);
        System.out.println("Output: " + filterNullValues(items1));
        System.out.println();
        
        // Test Case 2: With duplicates
        List<String> items2 = Arrays.asList("apple", null, "apple", "banana", null, "banana");
        System.out.println("Test Case 2: Filter nulls and duplicates");
        System.out.println("Input: " + items2);
        System.out.println("Output: " + filterNullValuesAsSet(items2));
        System.out.println();
        
        // Test Case 3: Count null and non-null
        System.out.println("Test Case 3: Count nulls and non-nulls");
        System.out.println("Input: " + items1);
        System.out.println("Output: " + countNullness(items1));
        System.out.println();
        
        // Test Case 4: Nulls only
        List<Integer> numbers4 = Arrays.asList(null, null, null);
        System.out.println("Test Case 4: All nulls");
        System.out.println("Input: " + numbers4);
        System.out.println("Output: " + filterNullValues(numbers4));
        System.out.println();
        
        // Test Case 5: No nulls
        List<Integer> numbers5 = Arrays.asList(1, 2, 3, 4);
        System.out.println("Test Case 5: No nulls");
        System.out.println("Input: " + numbers5);
        System.out.println("Output: " + filterNullValues(numbers5));
        System.out.println();
        
        // Test Case 6: Filter nulls and odd numbers
        List<Integer> numbers6 = Arrays.asList(1, null, 2, 3, null, 4, 5);
        System.out.println("Test Case 6: Filter nulls and even numbers");
        System.out.println("Input: " + numbers6);
        System.out.println("Output: " + filterNullAndOddNumbers(numbers6));
        System.out.println();
        
        // Test Case 7: Filter nulls and empty strings
        List<String> strings7 = Arrays.asList("hello", null, "", "world", null, "");
        System.out.println("Test Case 7: Filter nulls and empty strings");
        System.out.println("Input: " + strings7);
        System.out.println("Output: " + filterNullAndEmptyStrings(strings7));
        System.out.println();
        
        // Test Case 8: Null percentage
        System.out.println("Test Case 8: Null percentage");
        System.out.println("Input: " + items1);
        System.out.println("Output: " + getNullPercentage(items1) + "%");
        System.out.println();
        
        // Test Case 9: Replace nulls with default
        List<String> items9 = Arrays.asList("apple", null, "banana", null);
        System.out.println("Test Case 9: Replace nulls with default");
        System.out.println("Input: " + items9);
        System.out.println("Output: " + replaceNullsWithDefault(items9, "UNKNOWN"));
    }
}
