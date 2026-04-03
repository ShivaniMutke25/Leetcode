import java.util.*;
import java.util.stream.Collectors;

public class Main {
    
    /**
     * Partition numbers into even and odd
     * 
     * Approach:
     * - Use Collectors.partitioningBy() with even predicate
     * - Returns map with true (even) and false (odd) keys
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static Map<String, List<Integer>> partitionEvenOdd(List<Integer> numbers) {
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        
        Map<String, List<Integer>> result = new LinkedHashMap<>();
        result.put("even", partitioned.get(true));
        result.put("odd", partitioned.get(false));
        return result;
    }
    
    /**
     * Partition and return as direct map
     */
    public static Map<Boolean, List<Integer>> partitionEvenOddDirect(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
    }
    
    /**
     * Partition with custom predicate
     */
    public static <T> Map<Boolean, List<T>> partitionByPredicate(List<T> items, 
                                                                  java.util.function.Predicate<T> predicate) {
        return items.stream()
                .collect(Collectors.partitioningBy(predicate));
    }
    
    /**
     * Partition strings by length (short vs long)
     */
    public static Map<Boolean, List<String>> partitionByLength(List<String> strings, int threshold) {
        return strings.stream()
                .collect(Collectors.partitioningBy(s -> s.length() >= threshold));
    }
    
    /**
     * Partition and get counts
     */
    public static Map<String, Long> countEvenOdd(List<Integer> numbers) {
        Map<Boolean, Long> counts = numbers.stream()
                .collect(Collectors.partitioningBy(
                        n -> n % 2 == 0,
                        Collectors.counting()
                ));
        
        Map<String, Long> result = new LinkedHashMap<>();
        result.put("even", counts.get(true));
        result.put("odd", counts.get(false));
        return result;
    }
    
    /**
     * Partition positive and negative numbers
     */
    public static Map<String, List<Integer>> partitionPositiveNegative(List<Integer> numbers) {
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n >= 0));
        
        Map<String, List<Integer>> result = new LinkedHashMap<>();
        result.put("positive", partitioned.get(true));
        result.put("negative", partitioned.get(false));
        return result;
    }
    
    /**
     * Partition by multiple conditions
     */
    public static Map<String, List<Integer>> partitionByRange(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.groupingBy(n -> {
                    if (n < 0) return "negative";
                    if (n == 0) return "zero";
                    if (n <= 10) return "1-10";
                    return "above-10";
                }));
    }
    
    public static void main(String[] args) {
        // Test Case 1: Basic even/odd partition
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Test Case 1: Partition even and odd");
        System.out.println("Input: " + numbers1);
        System.out.println("Output: " + partitionEvenOdd(numbers1));
        System.out.println();
        
        // Test Case 2: Direct boolean map
        System.out.println("Test Case 2: Direct boolean map");
        System.out.println("Input: " + numbers1);
        System.out.println("Output: " + partitionEvenOddDirect(numbers1));
        System.out.println();
        
        // Test Case 3: Count even and odd
        System.out.println("Test Case 3: Count even and odd");
        System.out.println("Input: " + numbers1);
        System.out.println("Output: " + countEvenOdd(numbers1));
        System.out.println();
        
        // Test Case 4: Partition positive and negative
        List<Integer> numbers4 = Arrays.asList(-5, -2, 0, 3, 7, -1, 8);
        System.out.println("Test Case 4: Partition positive and negative");
        System.out.println("Input: " + numbers4);
        System.out.println("Output: " + partitionPositiveNegative(numbers4));
        System.out.println();
        
        // Test Case 5: Partition strings by length
        List<String> strings5 = Arrays.asList("apple", "a", "banana", "cat", "hello");
        System.out.println("Test Case 5: Partition strings (length >= 4)");
        System.out.println("Input: " + strings5);
        System.out.println("Output: " + partitionByLength(strings5, 4));
        System.out.println();
        
        // Test Case 6: Partition with multiple ranges
        System.out.println("Test Case 6: Partition by range");
        System.out.println("Input: " + numbers4);
        System.out.println("Output: " + partitionByRange(numbers4));
        System.out.println();
        
        // Test Case 7: All even
        List<Integer> numbers7 = Arrays.asList(2, 4, 6, 8);
        System.out.println("Test Case 7: All even numbers");
        System.out.println("Input: " + numbers7);
        System.out.println("Output: " + partitionEvenOdd(numbers7));
        System.out.println();
        
        // Test Case 8: All odd
        List<Integer> numbers8 = Arrays.asList(1, 3, 5, 7);
        System.out.println("Test Case 8: All odd numbers");
        System.out.println("Input: " + numbers8);
        System.out.println("Output: " + partitionEvenOdd(numbers8));
    }
}
