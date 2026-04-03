import java.util.*;
import java.util.stream.Collectors;

public class Main {
    
    // ===== COLLECT EXAMPLES =====
    
    /**
     * collect(): Create a List
     */
    public static List<Integer> collectToList() {
        return Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
        // Output: [2, 4, 6, 8, 10]
    }
    
    /**
     * collect(): Create a Map
     */
    public static Map<String, Integer> collectToMap() {
        return Arrays.asList("apple", "banana", "cherry")
                .stream()
                .collect(Collectors.toMap(
                        s -> s,
                        String::length
                ));
        // Output: {apple=5, banana=6, cherry=6}
    }
    
    /**
     * collect(): Group by property
     */
    public static Map<Integer, List<String>> collectGrouping() {
        return Arrays.asList("a", "bb", "ccc", "dd", "e")
                .stream()
                .collect(Collectors.groupingBy(String::length));
        // Output: {1=[a, e], 2=[bb, dd], 3=[ccc]}
    }
    
    /**
     * collect(): Partition by condition
     */
    public static Map<Boolean, List<Integer>> collectPartitioning() {
        return Arrays.asList(1, 2, 3, 4, 5, 6)
                .stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        // Output: {false=[1, 3, 5], true=[2, 4, 6]}
    }
    
    /**
     * collect(): Join strings
     */
    public static String collectJoining() {
        return Arrays.asList("apple", "banana", "cherry")
                .stream()
                .collect(Collectors.joining(", "));
        // Output: "apple, banana, cherry"
    }
    
    /**
     * collect(): To Set
     */
    public static Set<Integer> collectToSet() {
        return Arrays.asList(1, 2, 2, 3, 3, 3)
                .stream()
                .collect(Collectors.toSet());
        // Output: {1, 2, 3}
    }
    
    // ===== REDUCE EXAMPLES =====
    
    /**
     * reduce(): Sum numbers
     */
    public static int reduceSumNumbers() {
        return Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .reduce(0, (a, b) -> a + b);
        // Output: 15
    }
    
    /**
     * reduce(): Find maximum
     */
    public static Optional<Integer> reduceMax() {
        return Arrays.asList(3, 1, 4, 1, 5, 9)
                .stream()
                .reduce(Integer::max);
        // Output: Optional[9]
    }
    
    /**
     * reduce(): Find minimum
     */
    public static Optional<Integer> reduceMin() {
        return Arrays.asList(3, 1, 4, 1, 5, 9)
                .stream()
                .reduce(Integer::min);
        // Output: Optional[1]
    }
    
    /**
     * reduce(): Concatenate strings
     */
    public static Optional<String> reduceConcat() {
        return Arrays.asList("Hello", " ", "World")
                .stream()
                .reduce((a, b) -> a + b);
        // Output: Optional["Hello World"]
    }
    
    /**
     * reduce(): Count elements
     */
    public static int reduceCount() {
        return Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .reduce(0, (count, e) -> count + 1, (c1, c2) -> c1 + c2);
        // Output: 5
    }
    
    /**
     * reduce(): Multiply numbers
     */
    public static Optional<Integer> reduceMultiply() {
        return Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .reduce((a, b) -> a * b);
        // Output: Optional[120]
    }
    
    // ===== COMPARISON & COMBINATIONS =====
    
    /**
     * Using collect() for complex operations
     * (Better than reduce for this)
     */
    public static Map<String, Double> collectAndCalculate() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        return new HashMap<String, Double>() {{
            put("sum", (double) numbers.stream()
                    .reduce(0, Integer::sum));
            put("count", (double) numbers.size());
            put("average", numbers.stream()
                    .reduce(0, Integer::sum) / (double) numbers.size());
        }};
    }
    
    /**
     * Performance: Sum with collect() vs reduce()
     */
    public static void performanceComparison() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Using reduce()
        int sumReduce = numbers.stream()
                .reduce(0, Integer::sum);
        
        // Using collect() with custom collector
        int sumCollect = numbers.stream()
                .collect(
                        () -> new int[1],  // supplier
                        (arr, n) -> arr[0] += n,  // accumulator
                        (arr1, arr2) -> arr1[0] += arr2[0]  // combiner
                )[0];
        
        System.out.println("Sum using reduce(): " + sumReduce);
        System.out.println("Sum using collect(): " + sumCollect);
    }
    
    /**
     * Demonstration of when to use which
     */
    public static void demonstrationWhenToUse() {
        System.out.println("=== WHEN TO USE COLLECT ===");
        System.out.println("✓ Creating collections (List, Map, Set)");
        System.out.println("✓ Grouping or partitioning data");
        System.out.println("✓ Joining strings");
        System.out.println("✓ Complex data transformations");
        System.out.println("✓ Parallel processing (better performance)");
        System.out.println();
        
        System.out.println("=== WHEN TO USE REDUCE ===");
        System.out.println("✓ Summing or multiplication");
        System.out.println("✓ Finding min/max");
        System.out.println("✓ Simple string concatenation");
        System.out.println("✓ Combining two values");
        System.out.println("✓ When you need Optional result");
    }
    
    public static void main(String[] args) {
        // ===== COLLECT DEMONSTRATIONS =====
        System.out.println("====== COLLECT() EXAMPLES ======\n");
        
        System.out.println("1. Collect to List:");
        System.out.println("Input: [1, 2, 3, 4, 5] --map(n*2)-->");
        System.out.println("Output: " + collectToList());
        System.out.println();
        
        System.out.println("2. Collect to Map:");
        System.out.println("Input: [\"apple\", \"banana\", \"cherry\"]");
        System.out.println("Output: " + collectToMap());
        System.out.println();
        
        System.out.println("3. Collect with grouping:");
        System.out.println("Input: [\"a\", \"bb\", \"ccc\", \"dd\", \"e\"]");
        System.out.println("Output: " + collectGrouping());
        System.out.println();
        
        System.out.println("4. Collect with partitioning:");
        System.out.println("Input: [1, 2, 3, 4, 5, 6]");
        System.out.println("Output: " + collectPartitioning());
        System.out.println();
        
        System.out.println("5. Collect with joining:");
        System.out.println("Input: [\"apple\", \"banana\", \"cherry\"]");
        System.out.println("Output: " + collectJoining());
        System.out.println();
        
        System.out.println("6. Collect to Set:");
        System.out.println("Input: [1, 2, 2, 3, 3, 3]");
        System.out.println("Output: " + collectToSet());
        System.out.println();
        
        // ===== REDUCE DEMONSTRATIONS =====
        System.out.println("\n====== REDUCE() EXAMPLES ======\n");
        
        System.out.println("1. Sum numbers:");
        System.out.println("Input: [1, 2, 3, 4, 5]");
        System.out.println("Output: " + reduceSumNumbers());
        System.out.println();
        
        System.out.println("2. Find maximum:");
        System.out.println("Input: [3, 1, 4, 1, 5, 9]");
        System.out.println("Output: " + reduceMax());
        System.out.println();
        
        System.out.println("3. Find minimum:");
        System.out.println("Input: [3, 1, 4, 1, 5, 9]");
        System.out.println("Output: " + reduceMin());
        System.out.println();
        
        System.out.println("4. Concatenate strings:");
        System.out.println("Input: [\"Hello\", \" \", \"World\"]");
        System.out.println("Output: " + reduceConcat());
        System.out.println();
        
        System.out.println("5. Multiply numbers:");
        System.out.println("Input: [1, 2, 3, 4, 5]");
        System.out.println("Output: " + reduceMultiply());
        System.out.println();
        
        // ===== DECISION GUIDE =====
        System.out.println("\n====== WHEN TO USE WHICH ======\n");
        demonstrationWhenToUse();
        System.out.println();
        
        // ===== PERFORMANCE =====
        System.out.println("\n====== PERFORMANCE COMPARISON ======\n");
        performanceComparison();
    }
}
