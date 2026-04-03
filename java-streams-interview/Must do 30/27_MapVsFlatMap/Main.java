import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    
    // ===== MAP EXAMPLES =====
    
    /**
     * map(): Transform each element 1-to-1
     * Output: Stream<R> where each input maps to one output
     */
    public static List<Integer> mapExample1() {
        // Multiply each number by 2
        return Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
        // Output: [2, 4, 6, 8, 10]
    }
    
    /**
     * map(): Extract property from object
     */
    public static List<Integer> mapExample2() {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        return words.stream()
                .map(String::length)  // Extract length property
                .collect(Collectors.toList());
        // Output: [5, 6, 6]
    }
    
    // ===== FLATMAP EXAMPLES =====
    
    /**
     * flatMap(): Convert 1-to-many, then flatten
     * Output: Stream<R> flattened from multiple streams
     */
    public static List<Integer> flatMapExample1() {
        // For each number, create stream of [n, n*2, n*3], then flatten
        return Arrays.asList(1, 2, 3)
                .stream()
                .flatMap(n -> Stream.of(n, n*2, n*3))
                .collect(Collectors.toList());
        // Output: [1, 2, 3, 2, 4, 6, 3, 6, 9]
    }
    
    /**
     * flatMap(): Flatten list of lists
     */
    public static List<Integer> flatMapExample2() {
        List<List<Integer>> lists = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );
        return lists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        // Output: [1, 2, 3, 4, 5, 6]
    }
    
    /**
     * flatMap(): Split strings into characters
     */
    public static List<Character> flatMapExample3() {
        return Arrays.asList("hello", "world")
                .stream()
                .flatMap(s -> s.chars().boxed().map(c -> (char) c.intValue()))
                .collect(Collectors.toList());
        // Output: [h, e, l, l, o, w, o, r, l, d]
    }
    
    /**
     * flatMap(): Convert to streams and combine
     */
    public static List<String> flatMapExample4() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        return numbers.stream()
                .flatMap(n -> Arrays.asList("num" + n + "a", "num" + n + "b").stream())
                .collect(Collectors.toList());
        // Output: [num1a, num1b, num2a, num2b, num3a, num3b]
    }
    
    // ===== COMPARISON VISUALS =====
    
    /**
     * Visual comparison: map() vs flatMap()
     */
    public static void demonstrationComparison() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        
        // MAP: Each input -> single output
        List<Integer> mapResult = input.stream()
                .map(n -> n * 10)
                .collect(Collectors.toList());
        System.out.println("MAP:     [1, 2, 3] --map(n*10)--> [10, 20, 30]");
        System.out.println("Result:  " + mapResult);
        System.out.println();
        
        // FLATMAP: Each input -> stream of outputs -> flatten
        List<Integer> flatMapResult = input.stream()
                .flatMap(n -> Stream.of(n, n*10))
                .collect(Collectors.toList());
        System.out.println("FLATMAP: [1, 2, 3] --flatMap(Stream.of(n, n*10))--> flatten");
        System.out.println("Result:  " + flatMapResult);
        System.out.println();
    }
    
    /**
     * Use map() to uppercase strings
     */
    public static List<String> mapStringsToUpperCase(List<String> words) {
        return words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
    
    /**
     * Use flatMap() to get all words from multiple sentences
     */
    public static List<String> flatMapSentencesToWords(List<String> sentences) {
        return sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.toList());
    }
    
    /**
     * Use flatMap() to expand ranges
     */
    public static List<Integer> flatMapExpand(List<Integer> starts) {
        return starts.stream()
                .flatMap(start -> Stream.of(start, start+1, start+2))
                .collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
        // ===== MAP DEMONSTRATIONS =====
        System.out.println("====== MAP() EXAMPLES ======\n");
        
        System.out.println("1. Multiply by 2:");
        System.out.println("Input: [1, 2, 3, 4, 5]");
        System.out.println("Output: " + mapExample1());
        System.out.println();
        
        System.out.println("2. Extract length property:");
        System.out.println("Input: [\"apple\", \"banana\", \"cherry\"]");
        System.out.println("Output: " + mapExample2());
        System.out.println();
        
        System.out.println("3. Uppercase strings:");
        List<String> words = Arrays.asList("hello", "world", "java");
        System.out.println("Input: " + words);
        System.out.println("Output: " + mapStringsToUpperCase(words));
        System.out.println();
        
        // ===== FLATMAP DEMONSTRATIONS =====
        System.out.println("\n====== FLATMAP() EXAMPLES ======\n");
        
        System.out.println("1. Expand each number (n, n*2, n*3):");
        System.out.println("Input: [1, 2, 3]");
        System.out.println("Output: " + flatMapExample1());
        System.out.println();
        
        System.out.println("2. Flatten list of lists:");
        System.out.println("Input: [[1,2], [3,4], [5,6]]");
        System.out.println("Output: " + flatMapExample2());
        System.out.println();
        
        System.out.println("3. Split words into characters:");
        System.out.println("Input: [\"hello\", \"world\"]");
        System.out.println("Output: " + flatMapExample3());
        System.out.println();
        
        System.out.println("4. Convert range expansion:");
        List<Integer> starts = Arrays.asList(1, 5, 9);
        System.out.println("Input: " + starts);
        System.out.println("Output: " + flatMapExpand(starts));
        System.out.println();
        
        System.out.println("5. Split sentences to words:");
        List<String> sentences = Arrays.asList("Hello World", "Java Streams", "Map FlatMap");
        System.out.println("Input: " + sentences);
        System.out.println("Output: " + flatMapSentencesToWords(sentences));
        System.out.println();
        
        // ===== VISUAL COMPARISON =====
        System.out.println("\n====== MAP vs FLATMAP COMPARISON ======\n");
        demonstrationComparison();
    }
}
