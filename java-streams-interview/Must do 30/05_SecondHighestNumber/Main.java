import java.util.*;
import java.util.stream.Collectors;

public class Main {
    
    /**
     * Find the second highest number in a list
     * 
     * Approach:
     * - Get distinct elements to avoid duplicates
     * - Sort in descending order
     * - Skip the highest element
     * - Return the first (which is second highest)
     * 
     * Time Complexity: O(n log n) due to sorting
     * Space Complexity: O(n)
     */
    public static Integer secondHighestNumber(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .sorted(Collections.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Alternative: Using collect to sort inline
     */
    public static Integer secondHighestNumberV2(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.toCollection(TreeSet<Integer>::new))
                .stream()
                .sorted(Collections.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Using reduce for finding top 2 (more efficient - single pass)
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static Integer secondHighestNumberOptimal(List<Integer> numbers) {
        Map<String, Integer> result = numbers.stream()
                .reduce(new HashMap<String, Integer>() {{
                    put("max", Integer.MIN_VALUE);
                    put("secondMax", Integer.MIN_VALUE);
                }},
                (map, num) -> {
                    if (num > map.get("max")) {
                        map.put("secondMax", map.get("max"));
                        map.put("max", num);
                    } else if (num > map.get("secondMax") && num != map.get("max")) {
                        map.put("secondMax", num);
                    }
                    return map;
                },
                (map1, map2) -> map1);
        
        int secondMax = result.get("secondMax");
        return secondMax == Integer.MIN_VALUE ? null : secondMax;
    }
    
    public static void main(String[] args) {
        // Test Case 1: Normal case
        List<Integer> test1 = Arrays.asList(10, 5, 20, 15, 30);
        System.out.println("Test Case 1:");
        System.out.println("Input: " + test1);
        System.out.println("Output: " + secondHighestNumber(test1));
        System.out.println();
        
        // Test Case 2: With duplicates
        List<Integer> test2 = Arrays.asList(5, 5, 5, 5);
        System.out.println("Test Case 2:");
        System.out.println("Input: " + test2);
        System.out.println("Output: " + secondHighestNumber(test2));
        System.out.println();
        
        // Test Case 3: Only two elements
        List<Integer> test3 = Arrays.asList(10, 5);
        System.out.println("Test Case 3:");
        System.out.println("Input: " + test3);
        System.out.println("Output: " + secondHighestNumber(test3));
        System.out.println();
        
        // Test Case 4: Negative numbers
        List<Integer> test4 = Arrays.asList(-5, -10, -1, -20);
        System.out.println("Test Case 4:");
        System.out.println("Input: " + test4);
        System.out.println("Output: " + secondHighestNumber(test4));
        System.out.println();
        
        // Test Case 5: Single element
        List<Integer> test5 = Arrays.asList(42);
        System.out.println("Test Case 5:");
        System.out.println("Input: " + test5);
        System.out.println("Output: " + secondHighestNumber(test5));
        System.out.println();
        
        // Compare with optimal solution
        System.out.println("=== Optimal Solution (O(n) time) ===");
        List<Integer> testOpt = Arrays.asList(10, 5, 20, 15, 30);
        System.out.println("Input: " + testOpt);
        System.out.println("Output: " + secondHighestNumberOptimal(testOpt));
    }
}
