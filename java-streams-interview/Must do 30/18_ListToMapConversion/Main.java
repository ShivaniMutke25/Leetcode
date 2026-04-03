import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Employee {
    private Integer id;
    private String name;
    private double salary;
    
    public Employee(Integer id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    public Integer getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public double getSalary() {
        return salary;
    }
    
    @Override
    public String toString() {
        return "Employee(" + id + "," + name + "," + salary + ")";
    }
}

public class Main {
    
    /**
     * Convert list to map using 1-based index as key
     * 
     * Approach:
     * - Use IntStream.range() to get indexed stream
     * - Map index to element with 1-based indexing
     * - Collect to map
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static <T> Map<Integer, T> listToMapWithIndexKey(List<T> list) {
        return IntStream.range(0, list.size())
                .boxed()
                .collect(Collectors.toMap(
                        i -> i + 1,  // 1-based key
                        list::get    // value from list
                ));
    }
    
    /**
     * Convert list of objects to map using object property as key
     */
    public static <K, V> Map<K, V> listToMapWithKeyMapper(List<V> list, 
                                                           java.util.function.Function<V, K> keyMapper) {
        return list.stream()
                .collect(Collectors.toMap(
                        keyMapper,
                        v -> v
                ));
    }
    
    /**
     * Convert list of Employee to map with ID as key
     */
    public static Map<Integer, Employee> employeeListToMap(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.toMap(
                        Employee::getId,
                        emp -> emp
                ));
    }
    
    /**
     * Convert list of Employee to map with name as key
     */
    public static Map<String, Employee> employeeListToMapByName(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        emp -> emp
                ));
    }
    
    /**
     * Handle duplicate keys with merge function (keep first)
     */
    public static Map<String, Employee> employeeListToMapByNameHandleDuplicates(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        emp -> emp,
                        (emp1, emp2) -> emp1  // keep first on duplicate
                ));
    }
    
    /**
     * Convert list of strings to map with length as key, value as string
     */
    public static Map<Integer, String> stringListToMapByLength(List<String> strings) {
        return strings.stream()
                .collect(Collectors.toMap(
                        String::length,
                        s -> s,
                        (s1, s2) -> s1 + "," + s2  // concatenate if duplicate lengths
                ));
    }
    
    public static void main(String[] args) {
        // Test Case 1: Index-based map
        List<String> fruits = Arrays.asList("apple", "banana", "kiwi");
        System.out.println("Test Case 1: Index-based map (1-based)");
        System.out.println("Input: " + fruits);
        System.out.println("Output: " + listToMapWithIndexKey(fruits));
        System.out.println();
        
        // Test Case 2: Employee to map by ID
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", 50000),
                new Employee(2, "Bob", 75000),
                new Employee(3, "Charlie", 60000)
        );
        System.out.println("Test Case 2: Employee list to map by ID");
        System.out.println("Input: " + employees);
        System.out.println("Output: " + employeeListToMap(employees));
        System.out.println();
        
        // Test Case 3: Employee to map by name
        System.out.println("Test Case 3: Employee list to map by name");
        System.out.println("Input: " + employees);
        System.out.println("Output: " + employeeListToMapByName(employees));
        System.out.println();
        
        // Test Case 4: String list to map by length
        List<String> words = Arrays.asList("a", "bb", "ccc", "dd", "e");
        System.out.println("Test Case 4: String list to map by length");
        System.out.println("Input: " + words);
        System.out.println("Output: " + stringListToMapByLength(words));
        System.out.println();
        
        // Test Case 5: Handle duplicates
        List<String> colors = Arrays.asList("red", "blue", "red");
        System.out.println("Test Case 5: Generic list with duplicates");
        System.out.println("Input: " + colors);
        System.out.println("Output: " + listToMapWithKeyMapper(colors, s -> s.substring(0, 1)));
        System.out.println();
        
        // Test Case 6: Empty list
        List<String> empty = new ArrayList<>();
        System.out.println("Test Case 6: Empty list");
        System.out.println("Input: " + empty);
        System.out.println("Output: " + listToMapWithIndexKey(empty));
    }
}
