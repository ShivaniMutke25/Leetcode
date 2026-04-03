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
        return name;
    }
}

public class Main {
    
    /**
     * Group employees by department
     * 
     * Approach:
     * - Stream employees
     * - Use groupingBy() to group by department
     * - Collect into map with department -> list of employees
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
    
    /**
     * Group by department and sort employees by salary within each group
     */
    public static Map<String, List<Employee>> groupByDepartmentAndSortBySalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                        .collect(Collectors.toList())
                        )
                ));
    }
    
    /**
     * Group by department in TreeMap (sorted keys)
     */
    public static Map<String, List<Employee>> groupByDepartmentSorted(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        TreeMap::new,
                        Collectors.toList()
                ));
    }
    
    /**
     * Group by department and map to employee names
     */
    public static Map<String, List<String>> groupByDepartmentGetNames(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())
                ));
    }
    
    /**
     * Count employees per department
     */
    public static Map<String, Long> countEmployeesByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting()
                ));
    }
    
    public static void main(String[] args) {
        // Test Case 1: Basic grouping
        List<Employee> employees1 = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "IT", 75000),
                new Employee("Charlie", "HR", 60000),
                new Employee("Dave", "Finance", 65000),
                new Employee("Eve", "IT", 80000)
        );
        System.out.println("Test Case 1: Basic grouping");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + groupByDepartment(employees1));
        System.out.println();
        
        // Test Case 2: Group and sort by salary
        System.out.println("Test Case 2: Group by department, sorted by salary");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + groupByDepartmentAndSortBySalary(employees1));
        System.out.println();
        
        // Test Case 3: Sorted map keys
        System.out.println("Test Case 3: Sorted department names");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + groupByDepartmentSorted(employees1));
        System.out.println();
        
        // Test Case 4: Get employee names only
        System.out.println("Test Case 4: Employees names by department");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + groupByDepartmentGetNames(employees1));
        System.out.println();
        
        // Test Case 5: Count employees
        System.out.println("Test Case 5: Count employees per department");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + countEmployeesByDepartment(employees1));
        System.out.println();
        
        // Test Case 6: Single department
        List<Employee> employees6 = Arrays.asList(
                new Employee("X", "Admin", 45000),
                new Employee("Y", "Admin", 50000)
        );
        System.out.println("Test Case 6: Single department");
        System.out.println("Input: " + employees6);
        System.out.println("Output: " + groupByDepartment(employees6));
    }
}
