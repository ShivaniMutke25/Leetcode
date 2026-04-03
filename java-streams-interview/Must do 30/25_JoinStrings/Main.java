import java.util.*;
import java.util.stream.Collectors;

public class Main {
    
    /**
     * Join strings with delimiter
     * 
     * Approach:
     * - Stream the list
     * - Use Collectors.joining(delimiter)
     * - Result is a single concatenated string
     * 
     * Time Complexity: O(n) where n is total characters
     * Space Complexity: O(m) where m is result string length
     */
    public static String joinStrings(List<String> strings, String delimiter) {
        return strings.stream()
                .collect(Collectors.joining(delimiter));
    }
    
    /**
     * Join strings with delimiter, prefix, and suffix
     */
    public static String joinStringsWithAffixes(List<String> strings, String delimiter, 
                                                String prefix, String suffix) {
        return strings.stream()
                .collect(Collectors.joining(delimiter, prefix, suffix));
    }
    
    /**
     * Join without streams (traditional method)
     */
    public static String joinStringsTraditional(List<String> strings, String delimiter) {
        return String.join(delimiter, strings);
    }
    
    /**
     * Join strings using reduce (alternative stream approach)
     */
    public static String joinStringsWithReduce(List<String> strings, String delimiter) {
        return strings.stream()
                .reduce((s1, s2) -> s1 + delimiter + s2)
                .orElse("");
    }
    
    /**
     * Join with custom formatting
     */
    public static String joinStringsFormatted(List<String> strings, String delimiter) {
        return strings.stream()
                .map(s -> "\"" + s + "\"")  // quote each string
                .collect(Collectors.joining(delimiter));
    }
    
    /**
     * Join non-null strings only
     */
    public static String joinNonNull(List<String> strings, String delimiter) {
        return strings.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.joining(delimiter));
    }
    
    /**
     * Join non-empty strings only
     */
    public static String joinNonEmpty(List<String> strings, String delimiter) {
        return strings.stream()
                .filter(s -> s != null && !s.isEmpty())
                .collect(Collectors.joining(delimiter));
    }
    
    /**
     * Join with length limit (truncate each string)
     */
    public static String joinWithLengthLimit(List<String> strings, String delimiter, int maxLength) {
        return strings.stream()
                .map(s -> s.length() > maxLength ? s.substring(0, maxLength) + "..." : s)
                .collect(Collectors.joining(delimiter));
    }
    
    public static void main(String[] args) {
        // Test Case 1: Simple join with comma
        List<String> words1 = Arrays.asList("apple", "banana", "cherry");
        System.out.println("Test Case 1: Join with comma");
        System.out.println("Input: " + words1);
        System.out.println("Output: " + joinStrings(words1, ","));
        System.out.println();
        
        // Test Case 2: Join with other delimiters
        System.out.println("Test Case 2: Join with space");
        System.out.println("Input: " + words1);
        System.out.println("Output: " + joinStrings(words1, " "));
        System.out.println();
        
        // Test Case 3: Join with prefix and suffix
        System.out.println("Test Case 3: Join with brackets");
        System.out.println("Input: " + words1);
        System.out.println("Output: " + joinStringsWithAffixes(words1, ",", "[", "]"));
        System.out.println();
        
        // Test Case 4: Complex prefix and suffix
        System.out.println("Test Case 4: Join with complex affixes");
        System.out.println("Input: " + words1);
        System.out.println("Output: " + joinStringsWithAffixes(words1, " | ", "START: ", " :END"));
        System.out.println();
        
        // Test Case 5: Join with quoted strings
        System.out.println("Test Case 5: Quote wrapped");
        System.out.println("Input: " + words1);
        System.out.println("Output: " + joinStringsFormatted(words1, ", "));
        System.out.println();
        
        // Test Case 6: Join with null and empty values
        List<String> words6 = Arrays.asList("apple", null, "banana", "", "cherry");
        System.out.println("Test Case 6: Filter nulls");
        System.out.println("Input: " + words6);
        System.out.println("Output: " + joinNonNull(words6, ","));
        System.out.println();
        
        // Test Case 7: Filter empty strings too
        System.out.println("Test Case 7: Filter nulls and empty");
        System.out.println("Input: " + words6);
        System.out.println("Output: " + joinNonEmpty(words6, ","));
        System.out.println();
        
        // Test Case 8: Truncate long words
        List<String> words8 = Arrays.asList("apple", "watermelon", "cherry");
        System.out.println("Test Case 8: Truncate to 4 chars");
        System.out.println("Input: " + words8);
        System.out.println("Output: " + joinWithLengthLimit(words8, ",", 4));
        System.out.println();
        
        // Test Case 9: Single string
        List<String> words9 = Arrays.asList("single");
        System.out.println("Test Case 9: Single string");
        System.out.println("Input: " + words9);
        System.out.println("Output: " + joinStrings(words9, ","));
        System.out.println();
        
        // Test Case 10: Empty list
        List<String> words10 = new ArrayList<>();
        System.out.println("Test Case 10: Empty list");
        System.out.println("Input: " + words10);
        System.out.println("Output: '" + joinStrings(words10, ",") + "'");
    }
}
