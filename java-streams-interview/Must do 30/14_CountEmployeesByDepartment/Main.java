import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDepartment() {
        return department;
    }
    
    @Override
    public String toString() {
        return name + "(" + department + ")";
    }
}

public class Main {
    
    /**
     * Count employees by department
     * 
     * Approach:
     * - Stream employees
     * - Group by department
     * - Count using Collectors.counting()
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(d) where d is number of departments
     */
    public static Map<String, Long> countByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting()
                ));
    }
    
    /**
     * Count with sorted department names
     */
    public static Map<String, Long> countByDepartmentSorted(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        TreeMap::new,
                        Collectors.counting()
                ));
    }
    
    /**
     * Get department with maximum employees
     */
    public static String getDepartmentWithMostEmployees(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
    
    /**
     * Get department with minimum employees
     */
    public static String getDepartmentWithLeastEmployees(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
    
    /**
     * Filter departments with at least N employees
     */
    public static Map<String, Long> filterDepartmentsByEmployeeCount(List<Employee> employees, int minCount) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= minCount)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    
    public static void main(String[] args) {
        // Test Case 1: Basic count
        List<Employee> employees1 = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Charlie", "HR"),
                new Employee("Dave", "Finance"),
                new Employee("Eve", "IT"),
                new Employee("Frank", "IT")
        );
        System.out.println("Test Case 1: Count employees");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + countByDepartment(employees1));
        System.out.println();
        
        // Test Case 2: Sorted departments
        System.out.println("Test Case 2: Sorted by department name");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + countByDepartmentSorted(employees1));
        System.out.println();
        
        // Test Case 3: Department with most employees
        System.out.println("Test Case 3: Department with most employees");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + getDepartmentWithMostEmployees(employees1));
        System.out.println();
        
        // Test Case 4: Department with least employees
        System.out.println("Test Case 4: Department with least employees");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + getDepartmentWithLeastEmployees(employees1));
        System.out.println();
        
        // Test Case 5: Filter departments with at least 2 employees
        System.out.println("Test Case 5: Departments with at least 2 employees");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + filterDepartmentsByEmployeeCount(employees1, 2));
        System.out.println();
        
        // Test Case 6: Single employee
        List<Employee> employees6 = Arrays.asList(new Employee("Solo", "Admin"));
        System.out.println("Test Case 6: Single employee");
        System.out.println("Input: " + employees6);
        System.out.println("Output: " + countByDepartment(employees6));
    }
}
