import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private double salary;
    
    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public double getSalary() {
        return salary;
    }
    
    @Override
    public String toString() {
        return "E(" + name + "," + department + "," + salary + ")";
    }
}

public class Main {
    
    /**
     * Handle duplicates by keeping the first occurrence
     * 
     * Approach:
     * - Use toMap() with 3 parameters: keyMapper, valueMapper, mergeFunction
     * - Merge function keeps first value when duplicate key found
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static Map<String, Employee> employeeMapKeepFirst(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        emp -> emp,
                        (emp1, emp2) -> emp1  // Keep first
                ));
    }
    
    /**
     * Handle duplicates by keeping the last occurrence
     */
    public static Map<String, Employee> employeeMapKeepLast(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        emp -> emp,
                        (emp1, emp2) -> emp2  // Keep last
                ));
    }
    
    /**
     * Handle duplicates by combining values (e.g., concatenate departments)
     */
    public static Map<String, String> employeeMapCombineDepartments(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        Employee::getDepartment,
                        (dept1, dept2) -> dept1 + ", " + dept2  // Combine departments
                ));
    }
    
    /**
     * Handle duplicates by combining salaries
     */
    public static Map<String, Double> employeeMapSumSalaries(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        Employee::getSalary,
                        Double::sum  // Sum salaries for duplicate names
                ));
    }
    
    /**
     * Handle duplicates by keeping employee with higher salary
     */
    public static Map<String, Employee> employeeMapKeepHigherSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        emp -> emp,
                        (emp1, emp2) -> emp1.getSalary() > emp2.getSalary() ? emp1 : emp2
                ));
    }
    
    /**
     * Create map with custom map type (LinkedHashMap to preserve insertion order)
     */
    public static Map<String, Employee> employeeMapLinkedHashMap(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        emp -> emp,
                        (emp1, emp2) -> emp1,
                        LinkedHashMap::new  // LinkedHashMap preserves insertion order
                ));
    }
    
    /**
     * Create map with TreeMap (sorted keys)
     */
    public static Map<String, Employee> employeeMapTreeMap(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        emp -> emp,
                        (emp1, emp2) -> emp1,
                        TreeMap::new  // TreeMap keeps keys sorted
                ));
    }
    
    public static void main(String[] args) {
        // Test Case 1: Listing with duplicate names
        List<Employee> employees1 = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "IT", 75000),
                new Employee("Alice", "Finance", 60000)  // Duplicate name
        );
        System.out.println("Test Case 1: Keep first occurrence");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + employeeMapKeepFirst(employees1));
        System.out.println();
        
        // Test Case 2: Keep last
        System.out.println("Test Case 2: Keep last occurrence");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + employeeMapKeepLast(employees1));
        System.out.println();
        
        // Test Case 3: Combine departments
        System.out.println("Test Case 3: Combine departments");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + employeeMapCombineDepartments(employees1));
        System.out.println();
        
        // Test Case 4: Sum salaries
        System.out.println("Test Case 4: Sum salaries for duplicates");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + employeeMapSumSalaries(employees1));
        System.out.println();
        
        // Test Case 5: Keep higher salary
        List<Employee> employees5 = Arrays.asList(
                new Employee("Charlie", "HR", 50000),
                new Employee("Charlie", "IT", 80000)
        );
        System.out.println("Test Case 5: Keep employee with higher salary");
        System.out.println("Input: " + employees5);
        System.out.println("Output: " + employeeMapKeepHigherSalary(employees5));
        System.out.println();
        
        // Test Case 6: TreeMap (sorted keys)
        System.out.println("Test Case 6: TreeMap with sorted keys");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + employeeMapTreeMap(employees1));
        System.out.println();
        
        // Test Case 7: No duplicates
        List<Employee> employees7 = Arrays.asList(
                new Employee("X", "A", 1000),
                new Employee("Y", "B", 2000)
        );
        System.out.println("Test Case 7: No duplicates");
        System.out.println("Input: " + employees7);
        System.out.println("Output: " + employeeMapKeepFirst(employees7));
    }
}
