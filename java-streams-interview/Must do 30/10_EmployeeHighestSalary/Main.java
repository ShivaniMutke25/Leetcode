import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private double salary;
    
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    
    public String getName() {
        return name;
    }
    
    public double getSalary() {
        return salary;
    }
    
    @Override
    public String toString() {
        return "Employee(" + name + ", " + salary + ")";
    }
}

public class Main {
    
    /**
     * Find employee with highest salary
     * 
     * Approach:
     * - Use max() with Comparator.comparingDouble(Employee::getSalary)
     * - Returns Optional containing the employee with max salary
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static Employee findHighestPaidEmployee(List<Employee> employees) {
        return employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }
    
    /**
     * Alternative: Using reduce
     */
    public static Employee findHighestPaidEmployeeReduce(List<Employee> employees) {
        return employees.stream()
                .reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2)
                .orElse(null);
    }
    
    /**
     * Get name of highest paid employee
     */
    public static String getHighestPaidEmployeeName(List<Employee> employees) {
        return employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .map(Employee::getName)
                .orElse(null);
    }
    
    /**
     * Get all employees with maximum salary (in case of multiple with same salary)
     */
    public static List<Employee> getAllHighestPaidEmployees(List<Employee> employees) {
        double maxSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .max()
                .orElse(0);
        
        return employees.stream()
                .filter(e -> e.getSalary() == maxSalary)
                .collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
        // Test Case 1: Standard case
        List<Employee> employees1 = Arrays.asList(
                new Employee("Alice", 50000),
                new Employee("Bob", 75000),
                new Employee("Charlie", 60000)
        );
        System.out.println("Test Case 1:");
        System.out.println("Input: " + employees1);
        System.out.println("Highest paid: " + findHighestPaidEmployee(employees1));
        System.out.println();
        
        // Test Case 2: Single employee
        List<Employee> employees2 = Arrays.asList(
                new Employee("Alice", 50000)
        );
        System.out.println("Test Case 2:");
        System.out.println("Input: " + employees2);
        System.out.println("Highest paid: " + findHighestPaidEmployee(employees2));
        System.out.println();
        
        // Test Case 3: Same salaries
        List<Employee> employees3 = Arrays.asList(
                new Employee("Dave", 70000),
                new Employee("Eve", 70000),
                new Employee("Frank", 70000)
        );
        System.out.println("Test Case 3: Multiple with same salary");
        System.out.println("Input: " + employees3);
        System.out.println("Highest paid: " + findHighestPaidEmployee(employees3));
        System.out.println("All highest: " + getAllHighestPaidEmployees(employees3));
        System.out.println();
        
        // Test Case 4: Get name only
        System.out.println("Test Case 4: Get name only");
        System.out.println("Input: " + employees1);
        System.out.println("Highest paid name: " + getHighestPaidEmployeeName(employees1));
        System.out.println();
        
        // Test Case 5: Empty list
        List<Employee> employees5 = new ArrayList<>();
        System.out.println("Test Case 5: Empty list");
        System.out.println("Input: " + employees5);
        System.out.println("Highest paid: " + findHighestPaidEmployee(employees5));
    }
}
