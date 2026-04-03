import java.util.*;
import java.util.stream.Collectors;

public class Main {
    
    /**
     * Sort map by value in ascending order
     * 
     * Approach:
     * - Stream map entries
     * - Sort by value using comparingByValue()
     * - Collect to LinkedHashMap to maintain order
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static <K, V extends Comparable<V>> Map<K, V> sortMapByValue(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
    
    /**
     * Sort map by value in descending order
     */
    public static <K, V extends Comparable<V>> Map<K, V> sortMapByValueDescending(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
    
    /**
     * Sort map by value, then by key if values are equal
     */
    public static <K extends Comparable<K>, V extends Comparable<V>> Map<K, V> sortMapByValueThenKey(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue()
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
    
    public static void main(String[] args) {
        // Test Case 1: Basic sorting
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("apple", 5);
        map1.put("banana", 2);
        map1.put("kiwi", 9);
        map1.put("orange", 3);
        
        System.out.println("Test Case 1: Ascending");
        System.out.println("Input: " + map1);
        System.out.println("Output: " + sortMapByValue(map1));
        System.out.println();
        
        // Test Case 2: Descending order
        System.out.println("Test Case 2: Descending");
        System.out.println("Input: " + map1);
        System.out.println("Output: " + sortMapByValueDescending(map1));
        System.out.println();
        
        // Test Case 3: With duplicate values
        Map<String, Integer> map3 = new HashMap<>();
        map3.put("a", 5);
        map3.put("b", 2);
        map3.put("c", 5);
        map3.put("d", 3);
        
        System.out.println("Test Case 3: With duplicate values");
        System.out.println("Input: " + map3);
        System.out.println("Output: " + sortMapByValue(map3));
        System.out.println();
        
        // Test Case 4: String values
        Map<String, String> map4 = new HashMap<>();
        map4.put("a", "zebra");
        map4.put("b", "apple");
        map4.put("c", "mango");
        
        System.out.println("Test Case 4: String values");
        System.out.println("Input: " + map4);
        System.out.println("Output: " + sortMapByValue(map4));
        System.out.println();
        
        // Test Case 5: Single entry
        Map<String, Integer> map5 = new HashMap<>();
        map5.put("single", 42);
        
        System.out.println("Test Case 5: Single entry");
        System.out.println("Input: " + map5);
        System.out.println("Output: " + sortMapByValue(map5));
        System.out.println();
        
        // Test Case 6: Secondary sort by key
        Map<String, Integer> map6 = new HashMap<>();
        map6.put("z", 1);
        map6.put("a", 1);
        map6.put("m", 1);
        
        System.out.println("Test Case 6: Same values, sort by key");
        System.out.println("Input: " + map6);
        System.out.println("Output: " + sortMapByValueThenKey(map6));
    }
}
