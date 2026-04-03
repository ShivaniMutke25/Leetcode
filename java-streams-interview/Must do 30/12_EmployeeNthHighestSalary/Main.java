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
     * Find employee with Nth highest salary
     * 
     * Approach:
     * - Extract and get distinct salaries
     * - Sort in descending order
     * - Skip N-1 elements
     * - Get the Nth salary
     * - Find employee with that salary
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static Employee findNthHighestPaidEmployee(List<Employee> employees, int n) {
        if (n <= 0) {
            return null;
        }
        
        double nthHighestSalary = employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(n - 1)
                .findFirst()
                .orElse(-1.0);
        
        if (nthHighestSalary == -1.0) {
            return null;
        }
        
        return employees.stream()
                .filter(e -> e.getSalary() == nthHighestSalary)
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Get all employees with Nth highest salary
     */
    public static List<Employee> getAllNthHighestPaidEmployees(List<Employee> employees, int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        
        double nthHighestSalary = employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(n - 1)
                .findFirst()
                .orElse(-1.0);
        
        if (nthHighestSalary == -1.0) {
            return new ArrayList<>();
        }
        
        return employees.stream()
                .filter(e -> e.getSalary() == nthHighestSalary)
                .collect(Collectors.toList());
    }
    
    /**
     * Get list of employees sorted by salary descending
     */
    public static List<Employee> sortEmployeesBySalaryDescending(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
        // Test Case 1: Find 2nd highest salary
        List<Employee> employees1 = Arrays.asList(
                new Employee("Alice", 50000),
                new Employee("Bob", 75000),
                new Employee("Charlie", 60000),
                new Employee("Dave", 70000)
        );
        System.out.println("Test Case 1: 2nd highest");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + findNthHighestPaidEmployee(employees1, 2));
        System.out.println();
        
        // Test Case 2: Find 1st highest (should be same as highest)
        System.out.println("Test Case 2: 1st highest");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + findNthHighestPaidEmployee(employees1, 1));
        System.out.println();
        
        // Test Case 3: Find Nth where N is out of range
        System.out.println("Test Case 3: N out of range");
        System.out.println("Input: " + employees1 + ", N=10");
        System.out.println("Output: " + findNthHighestPaidEmployee(employees1, 10));
        System.out.println();
        
        // Test Case 4: Multiple with same Nth salary
        List<Employee> employees4 = Arrays.asList(
                new Employee("A", 90000),
                new Employee("B", 80000),
                new Employee("C", 80000),
                new Employee("D", 70000)
        );
        System.out.println("Test Case 4: Multiple with same 2nd salary");
        System.out.println("Input: " + employees4);
        System.out.println("Output: " + findNthHighestPaidEmployee(employees4, 2));
        System.out.println("All Nth highest: " + getAllNthHighestPaidEmployees(employees4, 2));
        System.out.println();
        
        // Test Case 5: Negative N
        System.out.println("Test Case 5: Negative N");
        System.out.println("Input: " + employees1 + ", N=-1");
        System.out.println("Output: " + findNthHighestPaidEmployee(employees1, -1));
        System.out.println();
        
        // Test Case 6: View sorted employees
        System.out.println("Test Case 6: All employees sorted by salary");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + sortEmployeesBySalaryDescending(employees1));
    }
}
