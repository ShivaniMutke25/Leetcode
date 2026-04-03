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
     * Find employee with second highest salary
     * 
     * Approach:
     * - Stream employees, extract distinct salaries
     * - Sort in descending order
     * - Skip first (highest), get second
     * - Find employee with that salary
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static Employee findSecondHighestPaidEmployee(List<Employee> employees) {
        double secondHighestSalary = employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(-1.0);
        
        if (secondHighestSalary == -1.0) {
            return null;
        }
        
        return employees.stream()
                .filter(e -> e.getSalary() == secondHighestSalary)
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Alternative: Using sorted() without distinct
     */
    public static Employee findSecondHighestPaidEmployeeV2(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1)
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Get all employees with second highest salary
     */
    public static List<Employee> getAllSecondHighestPaidEmployees(List<Employee> employees) {
        double secondHighestSalary = employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(-1.0);
        
        if (secondHighestSalary == -1.0) {
            return new ArrayList<>();
        }
        
        return employees.stream()
                .filter(e -> e.getSalary() == secondHighestSalary)
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
        System.out.println("Second highest: " + findSecondHighestPaidEmployee(employees1));
        System.out.println();
        
        // Test Case 2: Less than 2 unique salaries
        List<Employee> employees2 = Arrays.asList(
                new Employee("Alice", 50000)
        );
        System.out.println("Test Case 2:");
        System.out.println("Input: " + employees2);
        System.out.println("Second highest: " + findSecondHighestPaidEmployee(employees2));
        System.out.println();
        
        // Test Case 3: Multiple same salaries
        List<Employee> employees3 = Arrays.asList(
                new Employee("Alice", 50000),
                new Employee("Bob", 75000),
                new Employee("Charlie", 75000),
                new Employee("Dave", 60000)
        );
        System.out.println("Test Case 3: Multiple with same second highest salary");
        System.out.println("Input: " + employees3);
        System.out.println("Second highest: " + findSecondHighestPaidEmployee(employees3));
        System.out.println("All second highest: " + getAllSecondHighestPaidEmployees(employees3));
        System.out.println();
        
        // Test Case 4: Only 2 employees
        List<Employee> employees4 = Arrays.asList(
                new Employee("X", 100000),
                new Employee("Y", 50000)
        );
        System.out.println("Test Case 4: Only 2 employees");
        System.out.println("Input: " + employees4);
        System.out.println("Second highest: " + findSecondHighestPaidEmployee(employees4));
        System.out.println();
        
        // Test Case 5: Empty list
        List<Employee> employees5 = new ArrayList<>();
        System.out.println("Test Case 5: Empty list");
        System.out.println("Input: " + employees5);
        System.out.println("Second highest: " + findSecondHighestPaidEmployee(employees5));
    }
}
