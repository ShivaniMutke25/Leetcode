import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
    
    @Override
    public String toString() {
        return "E(" + id + "," + name + ")";
    }
}

public class Main {
    
    /**
     * Remove duplicate objects using LinkedHashSet
     * Preserves insertion order and removes duplicates
     * Requires proper equals() and hashCode() implementation
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static <T> List<T> removeDuplicates(List<T> list) {
        return list.stream()
                .collect(Collectors.toCollection(LinkedHashSet::new))
                .stream()
                .collect(Collectors.toList());
    }
    
    /**
     * Alternative: Using distinct() 
     * Requires equals() method to be properly overridden
     */
    public static <T> List<T> removeDuplicatesDistinct(List<T> list) {
        return list.stream()
                .distinct()
                .collect(Collectors.toList());
    }
    
    /**
     * Remove duplicates by ID (custom key)
     */
    public static List<Employee> removeDuplicatesByID(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.toMap(
                        Employee::getId,
                        emp -> emp,
                        (emp1, emp2) -> emp1  // keep first
                ))
                .values()
                .stream()
                .collect(Collectors.toList());
    }
    
    /**
     * Remove duplicates by custom predicate
     */
    public static <T> List<T> removeDuplicatesByKey(List<T> list, 
                                                     java.util.function.Function<T, Object> keyExtractor) {
        return list.stream()
                .collect(Collectors.toMap(
                        keyExtractor,
                        t -> t,
                        (t1, t2) -> t1
                ))
                .values()
                .stream()
                .collect(Collectors.toList());
    }
    
    /**
     * Count duplicates
     */
    public static <T> Map<T, Long> countDuplicates(List<T> list) {
        return list.stream()
                .collect(Collectors.groupingBy(
                        t -> t,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    
    /**
     * Get only unique elements (count == 1)
     */
    public static <T> List<T> getUniqueElements(List<T> list) {
        Map<T, Long> counts = list.stream()
                .collect(Collectors.groupingBy(t -> t, Collectors.counting()));
        
        return list.stream()
                .filter(t -> counts.get(t) == 1)
                .distinct()
                .collect(Collectors.toList());
    }
    
    /**
     * Remove duplicates using HashSet (doesn't preserve order)
     */
    public static <T> List<T> removeDuplicatesHashSet(List<T> list) {
        return list.stream()
                .collect(Collectors.toCollection(HashSet::new))
                .stream()
                .collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
        // Test Case 1: Basic duplicate removal
        List<Employee> employees1 = Arrays.asList(
                new Employee(1, "Alice"),
                new Employee(2, "Bob"),
                new Employee(1, "Alice"),
                new Employee(3, "Charlie"),
                new Employee(2, "Bob")
        );
        System.out.println("Test Case 1: Remove duplicates");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + removeDuplicates(employees1));
        System.out.println();
        
        // Test Case 2: Remove by ID only
        System.out.println("Test Case 2: Remove duplicates by ID");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + removeDuplicatesByID(employees1));
        System.out.println();
        
        // Test Case 3: Count duplicates
        System.out.println("Test Case 3: Count duplicates");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + countDuplicates(employees1));
        System.out.println();
        
        // Test Case 4: Get only unique (no duplicates)
        System.out.println("Test Case 4: Get only unique elements");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + getUniqueElements(employees1));
        System.out.println();
        
        // Test Case 5: No duplicates
        List<Employee> employees5 = Arrays.asList(
                new Employee(1, "Alice"),
                new Employee(2, "Bob"),
                new Employee(3, "Charlie")
        );
        System.out.println("Test Case 5: No duplicates");
        System.out.println("Input: " + employees5);
        System.out.println("Output: " + removeDuplicates(employees5));
        System.out.println();
        
        // Test Case 6: All duplicates
        List<Employee> employees6 = Arrays.asList(
                new Employee(1, "Alice"),
                new Employee(1, "Alice"),
                new Employee(1, "Alice")
        );
        System.out.println("Test Case 6: All duplicates");
        System.out.println("Input: " + employees6);
        System.out.println("Output: " + removeDuplicates(employees6));
        System.out.println();
        
        // Test Case 7: With integers
        List<Integer> numbers7 = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
        System.out.println("Test Case 7: Remove integer duplicates");
        System.out.println("Input: " + numbers7);
        System.out.println("Output: " + removeDuplicates(numbers7));
        System.out.println();
        
        // Test Case 8: Empty list
        List<Employee> employees8 = new ArrayList<>();
        System.out.println("Test Case 8: Empty list");
        System.out.println("Input: " + employees8);
        System.out.println("Output: " + removeDuplicates(employees8));
    }
}
