import java.util.*;
import java.util.stream.Collectors;

public class Main {
    
    /**
     * Find the Nth highest number in a list
     * 
     * Approach:
     * - Get distinct elements
     * - Sort in descending order
     * - Skip (N-1) elements
     * - Return the first element
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static Integer nthHighestNumber(List<Integer> numbers, int n) {
        if (n <= 0) {
            return null;
        }
        
        return numbers.stream()
                .distinct()
                .sorted(Collections.reverseOrder())
                .skip(n - 1)
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Using TreeSet for automatic sorting (descending order)
     */
    public static Integer nthHighestNumberAlternative(List<Integer> numbers, int n) {
        if (n <= 0) {
            return null;
        }
        
        Set<Integer> distinctNumbers = new TreeSet<>((a, b) -> Integer.compare(b, a));
        distinctNumbers.addAll(numbers);
        
        return distinctNumbers.stream()
                .skip(n - 1)
                .findFirst()
                .orElse(null);
    }
    
    public static void main(String[] args) {
        // Test Case 1: Find 3rd highest
        List<Integer> test1 = Arrays.asList(10, 5, 20, 15, 30);
        System.out.println("Test Case 1:");
        System.out.println("Input: " + test1 + ", N=3");
        System.out.println("Output: " + nthHighestNumber(test1, 3));
        System.out.println();
        
        // Test Case 2: Find 1st highest
        System.out.println("Test Case 2:");
        System.out.println("Input: " + test1 + ", N=1");
        System.out.println("Output: " + nthHighestNumber(test1, 1));
        System.out.println();
        
        // Test Case 3: Find 5th highest
        System.out.println("Test Case 3:");
        System.out.println("Input: " + test1 + ", N=5");
        System.out.println("Output: " + nthHighestNumber(test1, 5));
        System.out.println();
        
        // Test Case 4: N is out of range
        System.out.println("Test Case 4:");
        System.out.println("Input: " + test1 + ", N=10");
        System.out.println("Output: " + nthHighestNumber(test1, 10));
        System.out.println();
        
        // Test Case 5: With duplicates
        List<Integer> test5 = Arrays.asList(5, 5, 5, 5);
        System.out.println("Test Case 5:");
        System.out.println("Input: " + test5 + ", N=1");
        System.out.println("Output: " + nthHighestNumber(test5, 1));
        System.out.println();
        
        // Test Case 6: Negative N
        System.out.println("Test Case 6:");
        System.out.println("Input: " + test1 + ", N=-1");
        System.out.println("Output: " + nthHighestNumber(test1, -1));
    }
}
