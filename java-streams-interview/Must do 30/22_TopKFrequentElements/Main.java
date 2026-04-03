import java.util.*;
import java.util.stream.Collectors;

public class Main {
    
    /**
     * Find top K frequent elements
     * 
     * Approach:
     * - Count frequency of each element
     * - Sort by frequency in descending order
     * - Limit to K elements
     * - Extract and return the elements
     * 
     * Time Complexity: O(n log k) using heap, O(n log n) using sort
     * Space Complexity: O(n) for frequency map
     */
    public static <T> List<T> topKFrequent(List<T> elements, int k) {
        return elements.stream()
                .collect(Collectors.groupingBy(
                        e -> e,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
    
    /**
     * Top K with frequency map
     */
    public static <T> Map<T, Long> topKFrequentWithCounts(List<T> elements, int k) {
        return elements.stream()
                .collect(Collectors.groupingBy(
                        e -> e,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .limit(k)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    
    /**
     * Top K for integers
     */
    public static List<Integer> topKFrequentIntegers(List<Integer> nums, int k) {
        return nums.stream()
                .collect(Collectors.groupingBy(
                        n -> n,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
    
    /**
     * Top K for strings
     */
    public static List<String> topKFrequentStrings(List<String> words, int k) {
        return words.stream()
                .collect(Collectors.groupingBy(
                        w -> w,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
    
    /**
     * All elements with their frequencies sorted by frequency
     */
    public static <T> List<Map.Entry<T, Long>> getAllByFrequency(List<T> elements) {
        return elements.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<T, Long>comparingByValue().reversed())
                .collect(Collectors.toList());
    }
    
    /**
     * Count of each element
     */
    public static <T> Map<T, Long> getFrequencyMap(List<T> elements) {
        return elements.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    }
    
    public static void main(String[] args) {
        // Test Case 1: Basic top K
        List<Integer> nums1 = Arrays.asList(1, 1, 1, 2, 2, 3);
        System.out.println("Test Case 1: Top 2 frequent elements");
        System.out.println("Input: " + nums1 + ", K=2");
        System.out.println("Output: " + topKFrequentIntegers(nums1, 2));
        System.out.println();
        
        // Test Case 2: With frequency counts
        System.out.println("Test Case 2: Top 2 with counts");
        System.out.println("Input: " + nums1 + ", K=2");
        System.out.println("Output: " + topKFrequentWithCounts(nums1, 2));
        System.out.println();
        
        // Test Case 3: String elements
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "apple", "banana");
        System.out.println("Test Case 3: Top 2 frequent words");
        System.out.println("Input: " + words + ", K=2");
        System.out.println("Output: " + topKFrequentStrings(words, 2));
        System.out.println();
        
        // Test Case 4: K equals number of unique elements
        System.out.println("Test Case 4: K equals number of unique");
        System.out.println("Input: " + nums1 + ", K=3");
        System.out.println("Output: " + topKFrequentIntegers(nums1, 3));
        System.out.println();
        
        // Test Case 5: All elements sorted by frequency
        System.out.println("Test Case 5: All elements by frequency");
        System.out.println("Input: " + nums1);
        System.out.println("Output: " + getAllByFrequency(nums1));
        System.out.println();
        
        // Test Case 6: Frequency map
        System.out.println("Test Case 6: Frequency counts");
        System.out.println("Input: " + nums1);
        System.out.println("Output: " + getFrequencyMap(nums1));
        System.out.println();
        
        // Test Case 7: K=1
        System.out.println("Test Case 7: Top 1 (most frequent)");
        System.out.println("Input: " + nums1 + ", K=1");
        System.out.println("Output: " + topKFrequentIntegers(nums1, 1));
        System.out.println();
        
        // Test Case 8: Single element
        List<Integer> nums8 = Arrays.asList(1);
        System.out.println("Test Case 8: Single element");
        System.out.println("Input: " + nums8 + ", K=1");
        System.out.println("Output: " + topKFrequentIntegers(nums8, 1));
    }
}
