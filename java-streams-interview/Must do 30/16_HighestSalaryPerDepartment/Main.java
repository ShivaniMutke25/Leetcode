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
     * Find highest salary per department
     * 
     * Approach:
     * - Stream employees
     * - Group by department
     * - Use maxBy() to find employee with max salary
     * - Map to extract salary value
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(d) where d is number of departments
     */
    public static Map<String, Double> highestSalaryPerDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                optional -> optional.map(Employee::getSalary).orElse(0.0)
                        )
                ));
    }
    
    /**
     * Alternative: Get highest paid employee per department
     */
    public static Map<String, Employee> highestPaidEmployeePerDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                optional -> optional.orElse(null)
                        )
                ));
    }
    
    /**
     * Sorted departments
     */
    public static Map<String, Double> highestSalaryPerDepartmentSorted(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        TreeMap::new,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                optional -> optional.map(Employee::getSalary).orElse(0.0)
                        )
                ));
    }
    
    /**
     * Get all employees with max salary per department
     */
    public static Map<String, List<Employee>> allHighestPaidPerDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> {
                                    double maxSalary = list.stream()
                                            .mapToDouble(Employee::getSalary)
                                            .max()
                                            .orElse(0);
                                    return list.stream()
                                            .filter(e -> e.getSalary() == maxSalary)
                                            .collect(Collectors.toList());
                                }
                        )
                ));
    }
    
    public static void main(String[] args) {
        // Test Case 1: Basic highest salary
        List<Employee> employees1 = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "IT", 75000),
                new Employee("Charlie", "HR", 60000),
                new Employee("Dave", "Finance", 65000),
                new Employee("Eve", "IT", 80000)
        );
        System.out.println("Test Case 1: Highest salary per department");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + highestSalaryPerDepartment(employees1));
        System.out.println();
        
        // Test Case 2: Get employee with highest salary
        System.out.println("Test Case 2: Highest paid employee per department");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + highestPaidEmployeePerDepartment(employees1));
        System.out.println();
        
        // Test Case 3: Sorted departments
        System.out.println("Test Case 3: Sorted by department name");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + highestSalaryPerDepartmentSorted(employees1));
        System.out.println();
        
        // Test Case 4: Multiple with same max
        List<Employee> employees4 = Arrays.asList(
                new Employee("A", "Dept1", 50000),
                new Employee("B", "Dept1", 50000),
                new Employee("C", "Dept2", 75000)
        );
        System.out.println("Test Case 4: Multiple employees with highest salary");
        System.out.println("Input: " + employees4);
        System.out.println("Output: " + allHighestPaidPerDepartment(employees4));
        System.out.println();
        
        // Test Case 5: Single employee
        List<Employee> employees5 = Arrays.asList(new Employee("Solo", "Admin", 45000));
        System.out.println("Test Case 5: Single employee");
        System.out.println("Input: " + employees5);
        System.out.println("Output: " + highestSalaryPerDepartment(employees5));
    }
}
