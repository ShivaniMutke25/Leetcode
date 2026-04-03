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
        return name + "(" + department + "," + salary + ")";
    }
}

public class Main {
    
    /**
     * Find second highest salary per department
     * 
     * Approach:
     * - Group employees by department
     * - For each group, get distinct salaries
     * - Sort descending, skip 1, get the second highest
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static Map<String, Double> secondHighestSalaryPerDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> {
                                    double secondHighest = list.stream()
                                            .map(Employee::getSalary)
                                            .distinct()
                                            .sorted(Comparator.reverseOrder())
                                            .skip(1)
                                            .findFirst()
                                            .orElse(-1.0);
                                    return secondHighest == -1.0 ? null : secondHighest;
                                }
                        )
                ));
    }
    
    /**
     * Alternative: Get the employee with second highest salary
     */
    public static Map<String, Employee> secondHighestPaidEmployeePerDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> {
                                    double secondHighestSalary = list.stream()
                                            .map(Employee::getSalary)
                                            .distinct()
                                            .sorted(Comparator.reverseOrder())
                                            .skip(1)
                                            .findFirst()
                                            .orElse(-1.0);
                                    
                                    if (secondHighestSalary == -1.0) {
                                        return null;
                                    }
                                    
                                    return list.stream()
                                            .filter(e -> e.getSalary() == secondHighestSalary)
                                            .findFirst()
                                            .orElse(null);
                                }
                        )
                ));
    }
    
    /**
     * Sorted by department name
     */
    public static Map<String, Double> secondHighestSalaryPerDepartmentSorted(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        TreeMap::new,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> {
                                    double secondHighest = list.stream()
                                            .map(Employee::getSalary)
                                            .distinct()
                                            .sorted(Comparator.reverseOrder())
                                            .skip(1)
                                            .findFirst()
                                            .orElse(-1.0);
                                    return secondHighest == -1.0 ? null : secondHighest;
                                }
                        )
                ));
    }
    
    public static void main(String[] args) {
        // Test Case 1: Normal case
        List<Employee> employees1 = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "IT", 75000),
                new Employee("Charlie", "HR", 60000),
                new Employee("Dave", "IT", 80000),
                new Employee("Eve", "Finance", 65000)
        );
        System.out.println("Test Case 1: Second highest salary per department");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + secondHighestSalaryPerDepartment(employees1));
        System.out.println();
        
        // Test Case 2: Get employee with second highest
        System.out.println("Test Case 2: Second highest paid employee per department");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + secondHighestPaidEmployeePerDepartment(employees1));
        System.out.println();
        
        // Test Case 3: Sorted departments
        System.out.println("Test Case 3: Sorted by department name");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + secondHighestSalaryPerDepartmentSorted(employees1));
        System.out.println();
        
        // Test Case 4: Only 1 unique salary per department
        List<Employee> employees4 = Arrays.asList(
                new Employee("A", "Dept1", 50000),
                new Employee("B", "Dept2", 75000)
        );
        System.out.println("Test Case 4: Single unique salary per department");
        System.out.println("Input: " + employees4);
        System.out.println("Output: " + secondHighestSalaryPerDepartment(employees4));
        System.out.println();
        
        // Test Case 5: Multiple with same second highest
        List<Employee> employees5 = Arrays.asList(
                new Employee("A", "Dept1", 80000),
                new Employee("B", "Dept1", 60000),
                new Employee("C", "Dept1", 60000)
        );
        System.out.println("Test Case 5: Multiple with same second highest salary");
        System.out.println("Input: " + employees5);
        System.out.println("Output: " + secondHighestSalaryPerDepartment(employees5));
    }
}
