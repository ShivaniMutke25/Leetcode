import java.util.*;
import java.util.stream.Collectors;

public class Main {
    
    // ===== FINDFIRST EXAMPLES =====
    
    /**
     * findFirst(): Get first element that matches
     * Always respects encounter order
     */
    public static Optional<Integer> findFirstExample1() {
        return Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .filter(n -> n > 2)
                .findFirst();
        // Output: Optional[3]
    }
    
    /**
     * findFirst(): First even number
     */
    public static Optional<Integer> findFirstExample2() {
        return Arrays.asList(1, 3, 5, 6, 7)
                .stream()
                .filter(n -> n % 2 == 0)
                .findFirst();
        // Output: Optional[6] - first even
    }
    
    /**
     * findFirst(): First string with length > 3
     */
    public static Optional<String> findFirstExample3() {
        return Arrays.asList("a", "ab", "abc", "abcd", "abcde")
                .stream()
                .filter(s -> s.length() > 3)
                .findFirst();
        // Output: Optional[abcd] - first > 3 chars
    }
    
    // ===== FINDANY EXAMPLES =====
    
    /**
     * findAny(): Get any element that matches
     * No ordering guarantee
     */
    public static Optional<Integer> findAnyExample1() {
        return Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .filter(n -> n > 2)
                .findAny();
        // Sequential: Optional[3] (happens to be first)
        // Parallel: Could be [3], [4], or [5]
    }
    
    /**
     * findAny(): First even number (parallel)
     */
    public static Optional<Integer> findAnyExample2() {
        return Arrays.asList(1, 2, 3, 4, 5, 6, 7)
                .parallelStream()
                .filter(n -> n % 2 == 0)
                .findAny();
        // Output: Any of [2, 4, 6]
    }
    
    /**
     * findAny(): Any string with length > 3 (parallel)
     */
    public static Optional<String> findAnyExample3() {
        List<String> words = Arrays.asList("a", "ab", "abc", "abcd", "abcde", 
                                           "abcdef", "abcdefg");
        return words.parallelStream()
                .filter(s -> s.length() > 3)
                .findAny();
        // Output: Any matching element (faster in parallel)
    }
    
    // ===== COMPARISON DEMONSTRATIONS =====
    
    /**
     * Sequential stream behavior
     */
    public static void sequentialComparison() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("Sequential Stream:");
        System.out.println("findFirst: " + 
                numbers.stream()
                        .filter(n -> n > 5)
                        .findFirst());
        // Always output: Optional[6]
        
        System.out.println("findAny:   " + 
                numbers.stream()
                        .filter(n -> n > 5)
                        .findAny());
        // Usually output: Optional[6] (but not guaranteed)
    }
    
    /**
     * Parallel stream behavior
     */
    public static void parallelComparison() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("\nParallel Stream:");
        System.out.println("findFirst: " + 
                numbers.parallelStream()
                        .filter(n -> n > 5)
                        .findFirst());
        // Always output: Optional[6]
        
        System.out.println("findAny:   " + 
                numbers.parallelStream()
                        .filter(n -> n > 5)
                        .findAny());
        // Could be any: [6], [7], [8], [9], [10]
        // (More efficient than findFirst in parallel)
    }
    
    /**
     * Use case: Check if any element exists (findAny preferred)
     */
    public static boolean hasAnythingGreaterThan5() {
        return Arrays.asList(1, 2, 3, 10, 5)
                .parallelStream()
                .anyMatch(n -> n > 5);
        // Better than using findAny().isPresent()
    }
    
    /**
     * Use case: Get first element in order (findFirst required)
     */
    public static Optional<Integer> getFirstGreaterThan5(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n > 5)
                .findFirst();
        // Must use findFirst to respect order
    }
    
    /**
     * Performance test: findFirst vs findAny in parallel
     */
    public static void performanceComparison() {
        List<Integer> largeList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            largeList.add(i);
        }
        
        long start1 = System.nanoTime();
        Optional<Integer> first = largeList.parallelStream()
                .filter(n -> n > 500000)
                .findFirst();
        long time1 = System.nanoTime() - start1;
        
        long start2 = System.nanoTime();
        Optional<Integer> any = largeList.parallelStream()
                .filter(n -> n > 500000)
                .findAny();
        long time2 = System.nanoTime() - start2;
        
        System.out.println("\nPerformance (1M elements, parallel):");
        System.out.println("findFirst: " + time1 + " ns");
        System.out.println("findAny:   " + time2 + " ns");
        System.out.println("findAny is typically faster in parallel streams");
    }
    
    /**
     * Decision guide
     */
    public static void decisionGuide() {
        System.out.println("\n=== WHEN TO USE FINDFIRST ===");
        System.out.println("✓ You need the first matching element");
        System.out.println("✓ Order matters in your use case");
        System.out.println("✓ Sequential stream");
        System.out.println("✗ Don't use in parallel for performance");
        System.out.println();
        
        System.out.println("=== WHEN TO USE FINDANY ===");
        System.out.println("✓ Any matching element is acceptable");
        System.out.println("✓ Order doesn't matter");
        System.out.println("✓ Parallel streams (better performance)");
        System.out.println("✓ Checking existence with anyMatch()");
    }
    
    public static void main(String[] args) {
        // ===== FINDFIRST EXAMPLES =====
        System.out.println("====== FINDFIRST() EXAMPLES ======\n");
        
        System.out.println("1. First element > 2:");
        System.out.println("Input: [1, 2, 3, 4, 5]");
        System.out.println("Output: " + findFirstExample1());
        System.out.println();
        
        System.out.println("2. First even number:");
        System.out.println("Input: [1, 3, 5, 6, 7]");
        System.out.println("Output: " + findFirstExample2());
        System.out.println();
        
        System.out.println("3. First string length > 3:");
        System.out.println("Input: [\"a\", \"ab\", \"abc\", \"abcd\", \"abcde\"]");
        System.out.println("Output: " + findFirstExample3());
        System.out.println();
        
        // ===== FINDANY EXAMPLES =====
        System.out.println("\n====== FINDANY() EXAMPLES ======\n");
        
        System.out.println("1. Any element > 2:");
        System.out.println("Input: [1, 2, 3, 4, 5]");
        System.out.println("Sequential Output: " + findAnyExample1());
        System.out.println();
        
        System.out.println("2. Any even number (parallel):");
        System.out.println("Input: [1, 2, 3, 4, 5, 6, 7]");
        System.out.println("Parallel Output: " + findAnyExample2());
        System.out.println("(Could be [2], [4], or [6])");
        System.out.println();
        
        System.out.println("3. Any string length > 3 (parallel):");
        System.out.println("Input: [\"a\", \"ab\", \"abc\", \"abcd\", \"abcde\", ...]");
        System.out.println("Output: " + findAnyExample3());
        System.out.println();
        
        // ===== COMPARISONS =====
        System.out.println("\n====== SEQUENTIAL vs PARALLEL ======");
        sequentialComparison();
        parallelComparison();
        
        // ===== DECISION GUIDE =====
        System.out.println("\n====== DECISION GUIDE ======");
        decisionGuide();
        
        // ===== PERFORMANCE =====
        System.out.println("\n====== PERFORMANCE TEST ======");
        performanceComparison();
    }
}
