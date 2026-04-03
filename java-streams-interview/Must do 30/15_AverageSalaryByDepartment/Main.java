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
     * Calculate average salary by department
     * 
     * Approach:
     * - Stream employees
     * - Group by department
     * - Calculate average using Collectors.averagingDouble()
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(d) where d is number of departments
     */
    public static Map<String, Double> averageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
    }
    
    /**
     * Average salary with sorted department names
     */
    public static Map<String, Double> averageSalaryByDepartmentSorted(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        TreeMap::new,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
    }
    
    /**
     * Also get min and max salary per department
     */
    public static Map<String, Map<String, Double>> salaryStatsByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> {
                                    Map<String, Double> stats = new HashMap<>();
                                    double avg = list.stream()
                                            .mapToDouble(Employee::getSalary)
                                            .average()
                                            .orElse(0);
                                    double min = list.stream()
                                            .mapToDouble(Employee::getSalary)
                                            .min()
                                            .orElse(0);
                                    double max = list.stream()
                                            .mapToDouble(Employee::getSalary)
                                            .max()
                                            .orElse(0);
                                    stats.put("average", avg);
                                    stats.put("min", min);
                                    stats.put("max", max);
                                    return stats;
                                }
                        )
                ));
    }
    
    /**
     * Get department with highest average salary
     */
    public static String getDepartmentWithHighestAverageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
    
    public static void main(String[] args) {
        // Test Case 1: Basic average
        List<Employee> employees1 = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "IT", 75000),
                new Employee("Charlie", "HR", 60000),
                new Employee("Dave", "Finance", 65000),
                new Employee("Eve", "IT", 80000)
        );
        System.out.println("Test Case 1: Average salary by department");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + averageSalaryByDepartment(employees1));
        System.out.println();
        
        // Test Case 2: Sorted departments
        System.out.println("Test Case 2: Sorted by department name");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + averageSalaryByDepartmentSorted(employees1));
        System.out.println();
        
        // Test Case 3: Salary statistics
        System.out.println("Test Case 3: Min, Average, Max salary");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + salaryStatsByDepartment(employees1));
        System.out.println();
        
        // Test Case 4: Department with highest average
        System.out.println("Test Case 4: Department with highest average salary");
        System.out.println("Input: " + employees1);
        System.out.println("Output: " + getDepartmentWithHighestAverageSalary(employees1));
        System.out.println();
        
        // Test Case 5: Single department
        List<Employee> employees5 = Arrays.asList(
                new Employee("X", "Admin", 45000),
                new Employee("Y", "Admin", 55000)
        );
        System.out.println("Test Case 5: Single department");
        System.out.println("Input: " + employees5);
        System.out.println("Output: " + averageSalaryByDepartment(employees5));
        System.out.println();
        
        // Test Case 6: Single employee per department
        List<Employee> employees6 = Arrays.asList(
                new Employee("Solo1", "Dept1", 50000),
                new Employee("Solo2", "Dept2", 60000)
        );
        System.out.println("Test Case 6: One employee per department");
        System.out.println("Input: " + employees6);
        System.out.println("Output: " + averageSalaryByDepartment(employees6));
    }
}
