import java.util.*;
import java.util.stream.Collectors;

public class Main {
    
    /**
     * Create signature for a word (sorted characters)
     * Two words are anagrams if they have the same signature
     */
    private static String createSignature(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    
    /**
     * Group anagrams from a list of words
     * 
     * Approach:
     * - Create signature for each word (sorted characters)
     * - Group words by signature
     * - Words with same signature are anagrams
     * 
     * Time Complexity: O(n * k log k) where k is average word length
     * Space Complexity: O(n)
     */
    public static Map<String, List<String>> groupAnagrams(List<String> words) {
        return words.stream()
                .collect(Collectors.groupingBy(
                        Main::createSignature
                ));
    }
    
    /**
     * Group anagrams and return only lists with 2+ anagrams
     */
    public static List<List<String>> groupAnagramsFilterPairs(List<String> words) {
        return words.stream()
                .collect(Collectors.groupingBy(Main::createSignature))
                .values()
                .stream()
                .filter(list -> list.size() > 1)
                .collect(Collectors.toList());
    }
    
    /**
     * Get all anagrams for a specific word
     */
    public static List<String> getAnagramsForWord(List<String> words, String targetWord) {
        String signature = createSignature(targetWord);
        return words.stream()
                .filter(word -> createSignature(word).equals(signature))
                .collect(Collectors.toList());
    }
    
    /**
     * Count number of anagram groups
     */
    public static int countAnagramGroups(List<String> words) {
        return (int) words.stream()
                .map(Main::createSignature)
                .distinct()
                .count();
    }
    
    /**
     * Get the signature (sorted characters) of a word
     */
    public static String getSignature(String word) {
        return createSignature(word);
    }
    
    public static void main(String[] args) {
        // Test Case 1: Basic anagram grouping
        List<String> words1 = Arrays.asList("listen", "silent", "hello", "world", "act", "cat");
        System.out.println("Test Case 1: Group anagrams");
        System.out.println("Input: " + words1);
        System.out.println("Output: " + groupAnagrams(words1));
        System.out.println();
        
        // Test Case 2: Only anagram pairs
        System.out.println("Test Case 2: Only groups with 2+ anagrams");
        System.out.println("Input: " + words1);
        System.out.println("Output: " + groupAnagramsFilterPairs(words1));
        System.out.println();
        
        // Test Case 3: Get anagrams for specific word
        System.out.println("Test Case 3: Get anagrams for 'listen'");
        System.out.println("Input: " + words1);
        System.out.println("Output: " + getAnagramsForWord(words1, "listen"));
        System.out.println();
        
        // Test Case 4: Count anagram groups
        System.out.println("Test Case 4: Total anagram groups");
        System.out.println("Input: " + words1);
        System.out.println("Output: " + countAnagramGroups(words1) + " groups");
        System.out.println();
        
        // Test Case 5: No anagrams
        List<String> words5 = Arrays.asList("apple", "banana", "cherry");
        System.out.println("Test Case 5: No anagrams");
        System.out.println("Input: " + words5);
        System.out.println("Output: " + groupAnagrams(words5));
        System.out.println();
        
        // Test Case 6: All are anagrams
        List<String> words6 = Arrays.asList("abc", "bca", "cab", "acb");
        System.out.println("Test Case 6: All are anagrams");
        System.out.println("Input: " + words6);
        System.out.println("Output: " + groupAnagrams(words6));
        System.out.println();
        
        // Test Case 7: Signature display
        String testWord = "listen";
        System.out.println("Test Case 7: Word signature");
        System.out.println("Word: " + testWord);
        System.out.println("Signature: " + getSignature(testWord));
        System.out.println("Anagrams: " + getAnagramsForWord(words1, testWord));
        System.out.println();
        
        // Test Case 8: Single words
        List<String> words8 = Arrays.asList("abc");
        System.out.println("Test Case 8: Single word");
        System.out.println("Input: " + words8);
        System.out.println("Output: " + groupAnagrams(words8));
    }
}
