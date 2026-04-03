import java.util.*;
import java.util.stream.Collectors;

public class Main {
    
    /**
     * Flatten a list of lists into a single list
     * 
     * Approach:
     * - Stream the outer list (list of lists)
     * - Use flatMap() to flatten each inner list into a stream
     * - flatMap() converts Stream<List<T>> to Stream<T>
     * - Collect all elements into a single list
     * 
     * Time Complexity: O(n) where n is total elements
     * Space Complexity: O(n)
     */
    public static <T> List<T> flattenList(List<List<T>> nestedList) {
        return nestedList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
    
    /**
     * Flatten using set (removes duplicates)
     */
    public static <T> Set<T> flattenListAsSet(List<List<T>> nestedList) {
        return nestedList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toSet());
    }
    
    /**
     * Flatten and sort
     */
    public static List<Integer> flattenListAndSort(List<List<Integer>> nestedList) {
        return nestedList.stream()
                .flatMap(List::stream)
                .sorted()
                .collect(Collectors.toList());
    }
    
    /**
     * Flatten and sort descending
     */
    public static List<Integer> flattenListAndSortDescending(List<List<Integer>> nestedList) {
        return nestedList.stream()
                .flatMap(List::stream)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
    
    /**
     * Flatten and filter
     */
    public static List<Integer> flattenListAndFilter(List<List<Integer>> nestedList, int minValue) {
        return nestedList.stream()
                .flatMap(List::stream)
                .filter(n -> n >= minValue)
                .collect(Collectors.toList());
    }
    
    /**
     * Flatten and map (transform each element)
     */
    public static List<Integer> flattenListAndMap(List<List<Integer>> nestedList) {
        return nestedList.stream()
                .flatMap(List::stream)
                .map(n -> n * 2)  // Double each number
                .collect(Collectors.toList());
    }
    
    /**
     * Flatten list of arrays
     */
    public static <T> List<T> flattenArrayList(List<T[]> nestedArrays) {
        return nestedArrays.stream()
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
    
    /**
     * Deep flatten (3 or more levels)
     */
    public static List<Integer> deepFlatten(List<List<List<Integer>>> tripleNestedList) {
        return tripleNestedList.stream()
                .flatMap(List::stream)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
        // Test Case 1: Basic flatten
        List<List<Integer>> nested1 = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );
        System.out.println("Test Case 1: Basic flatten");
        System.out.println("Input: " + nested1);
        System.out.println("Output: " + flattenList(nested1));
        System.out.println();
        
        // Test Case 2: Flatten and remove duplicates
        List<List<Integer>> nested2 = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(3, 4, 5),
                Arrays.asList(5, 6)
        );
        System.out.println("Test Case 2: Flatten and remove duplicates");
        System.out.println("Input: " + nested2);
        System.out.println("Output: " + flattenListAsSet(nested2));
        System.out.println();
        
        // Test Case 3: Flatten and sort
        System.out.println("Test Case 3: Flatten and sort ascending");
        System.out.println("Input: " + nested1);
        System.out.println("Output: " + flattenListAndSort(nested1));
        System.out.println();
        
        // Test Case 4: Flatten and sort descending
        System.out.println("Test Case 4: Flatten and sort descending");
        System.out.println("Input: " + nested1);
        System.out.println("Output: " + flattenListAndSortDescending(nested1));
        System.out.println();
        
        // Test Case 5: Flatten and filter (>= 5)
        System.out.println("Test Case 5: Flatten and filter (>= 5)");
        System.out.println("Input: " + nested1);
        System.out.println("Output: " + flattenListAndFilter(nested1, 5));
        System.out.println();
        
        // Test Case 6: Flatten and map (double values)
        System.out.println("Test Case 6: Flatten and map (double each)");
        System.out.println("Input: " + nested1);
        System.out.println("Output: " + flattenListAndMap(nested1));
        System.out.println();
        
        // Test Case 7: Flatten arrays
        List<Integer[]> arrayList = Arrays.asList(
                new Integer[]{1, 2},
                new Integer[]{3, 4, 5},
                new Integer[]{6}
        );
        System.out.println("Test Case 7: Flatten list of arrays");
        System.out.println("Input: " + Arrays.toString(arrayList.toArray()));
        System.out.println("Output: " + flattenArrayList(arrayList));
        System.out.println();
        
        // Test Case 8: Empty list
        List<List<Integer>> nested8 = new ArrayList<>();
        System.out.println("Test Case 8: Empty nested list");
        System.out.println("Input: " + nested8);
        System.out.println("Output: " + flattenList(nested8));
        System.out.println();
        
        // Test Case 9: Triple nested
        List<List<List<Integer>>> triple = Arrays.asList(
                Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3)),
                Arrays.asList(Arrays.asList(4, 5, 6))
        );
        System.out.println("Test Case 9: Deep flatten (3 levels)");
        System.out.println("Input: " + triple);
        System.out.println("Output: " + deepFlatten(triple));
    }
}
