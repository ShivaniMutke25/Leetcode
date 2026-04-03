import java.util.*;
import java.util.stream.Collectors;

// ===== INCORRECT VERSION (No equals/hashCode) =====
class EmployeeIncorrect {
    private int id;
    private String name;
    
    public EmployeeIncorrect(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    
    @Override
    public String toString() {
        return "EmpInc(" + id + "," + name + ")";
    }
    // No equals() or hashCode() - PROBLEM!
}

// ===== CORRECT VERSION (With proper equals/hashCode) =====
class EmployeeCorrect {
    private int id;
    private String name;
    
    public EmployeeCorrect(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeCorrect)) return false;
        EmployeeCorrect employee = (EmployeeCorrect) o;
        return id == employee.id && Objects.equals(name, employee.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
    
    @Override
    public String toString() {
        return "EmpCor(" + id + "," + name + ")";
    }
}

// ===== PARTIAL VERSION (Only equals, no hashCode - WRONG!) =====
class EmployeePartial {
    private int id;
    private String name;
    
    public EmployeePartial(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeePartial)) return false;
        EmployeePartial employee = (EmployeePartial) o;
        return id == employee.id && Objects.equals(name, employee.name);
    }
    // NO hashCode() - HashCode will use default Object.hashCode()
    // This breaks the equals/hashCode contract!
    
    @Override
    public String toString() {
        return "EmpPart(" + id + "," + name + ")";
    }
}

public class Main {
    
    /**
     * Demonstrate the problem: Without equals() and hashCode()
     */
    public static void demonstrateProblem() {
        System.out.println("=== PROBLEM: No equals() and hashCode() ===\n");
        
        EmployeeIncorrect emp1 = new EmployeeIncorrect(1, "Alice");
        EmployeeIncorrect emp2 = new EmployeeIncorrect(1, "Alice");
        
        System.out.println("emp1: " + emp1);
        System.out.println("emp2: " + emp2);
        System.out.println("emp1.equals(emp2): " + emp1.equals(emp2));
        System.out.println("(Should be true, but is false!)");
        System.out.println();
        
        // Problem in HashMap
        Map<EmployeeIncorrect, String> mapIncorrect = new HashMap<>();
        mapIncorrect.put(emp1, "Department1");
        mapIncorrect.put(emp2, "Department2");  // Adds duplicate key!
        
        System.out.println("HashMap size: " + mapIncorrect.size());
        System.out.println("(Should be 1, but is 2!)");
        System.out.println("HashMap: " + mapIncorrect);
        System.out.println();
        
        // Problem in HashSet
        Set<EmployeeIncorrect> setIncorrect = new HashSet<>();
        setIncorrect.add(emp1);
        setIncorrect.add(emp2);  // Adds duplicate!
        
        System.out.println("HashSet size: " + setIncorrect.size());
        System.out.println("(Should be 1, but is 2!)");
        System.out.println("HashSet: " + setIncorrect);
        System.out.println();
    }
    
    /**
     * Demonstrate the solution: With proper equals() and hashCode()
     */
    public static void demonstrateSolution() {
        System.out.println("\n=== SOLUTION: Proper equals() and hashCode() ===\n");
        
        EmployeeCorrect emp1 = new EmployeeCorrect(1, "Alice");
        EmployeeCorrect emp2 = new EmployeeCorrect(1, "Alice");
        
        System.out.println("emp1: " + emp1);
        System.out.println("emp2: " + emp2);
        System.out.println("emp1.equals(emp2): " + emp1.equals(emp2));
        System.out.println("emp1.hashCode() == emp2.hashCode(): " + 
                (emp1.hashCode() == emp2.hashCode()));
        System.out.println("(Correctly identified as equal!)");
        System.out.println();
        
        // Solution in HashMap
        Map<EmployeeCorrect, String> mapCorrect = new HashMap<>();
        mapCorrect.put(emp1, "Department1");
        mapCorrect.put(emp2, "Department2");  // Overwrites key due to equality
        
        System.out.println("HashMap size: " + mapCorrect.size());
        System.out.println("(Correctly 1!)");
        System.out.println("HashMap: " + mapCorrect);
        System.out.println("Value: " + mapCorrect.get(emp1));
        System.out.println("(Can retrieve by either equal object)");
        System.out.println();
        
        // Solution in HashSet
        Set<EmployeeCorrect> setCorrect = new HashSet<>();
        setCorrect.add(emp1);
        setCorrect.add(emp2);  // Won't add duplicate
        
        System.out.println("HashSet size: " + setCorrect.size());
        System.out.println("(Correctly 1!)");
        System.out.println("HashSet: " + setCorrect);
        System.out.println();
    }
    
    /**
     * Demonstrate partial implementation problem
     */
    public static void demonstratePartialProblem() {
        System.out.println("\n=== PROBLEM: Only equals(), no hashCode() ===\n");
        
        EmployeePartial emp1 = new EmployeePartial(1, "Alice");
        EmployeePartial emp2 = new EmployeePartial(1, "Alice");
        
        System.out.println("emp1.equals(emp2): " + emp1.equals(emp2));
        System.out.println("emp1.hashCode(): " + emp1.hashCode());
        System.out.println("emp2.hashCode(): " + emp2.hashCode());
        System.out.println("Are hashcodes equal? " + (emp1.hashCode() == emp2.hashCode()));
        System.out.println("(They're different! Breaks equals/hashCode contract!)");
        System.out.println();
        
        Set<EmployeePartial> setPartial = new HashSet<>();
        setPartial.add(emp1);
        setPartial.add(emp2);  // Still adds duplicate due to different hash codes
        
        System.out.println("HashSet size: " + setPartial.size());
        System.out.println("(Should be 1, but is 2!)");
        System.out.println("Set contains both: " + setPartial);
        System.out.println();
    }
    
    /**
     * Working with stream and HashMap
     */
    public static void streamWithHashMap() {
        System.out.println("\n=== Using Streams with HashMap ===\n");
        
        List<EmployeeCorrect> employees = Arrays.asList(
                new EmployeeCorrect(1, "Alice"),
                new EmployeeCorrect(2, "Bob"),
                new EmployeeCorrect(1, "Alice"),  // duplicate
                new EmployeeCorrect(3, "Charlie")
        );
        
        // Collect to map (requires proper equals/hashCode)
        Map<EmployeeCorrect, Integer> salaryMap = employees.stream()
                .distinct()  // Requires equals/hashCode
                .collect(Collectors.toMap(
                        emp -> emp,
                        emp -> emp.getId() * 10000
                ));
        
        System.out.println("Employees: " + employees);
        System.out.println("Distinct count: " + employees.stream().distinct().count());
        System.out.println("Salary map size: " + salaryMap.size());
        System.out.println("Map: " + salaryMap);
        System.out.println();
    }
    
    /**
     * Best practices for equals and hashCode
     */
    public static void bestPractices() {
        System.out.println("\n=== BEST PRACTICES ===\n");
        System.out.println("1. Always override both equals() AND hashCode()");
        System.out.println("2. Use Objects.equals() for null safety");
        System.out.println("3. Use Objects.hash() for combining hash codes");
        System.out.println("4. Base equals/hashCode on immutable fields");
        System.out.println("5. Ensure: if equals() then same hashCode()");
        System.out.println("6. Make hashCode() consistent across object lifetime");
        System.out.println("7. Test with collections: HashMap, HashSet");
        System.out.println("8. Use IDE (IntelliJ, Eclipse) to generate implementations");
        System.out.println();
    }
    
    public static void main(String[] args) {
        // Show the problem
        demonstrateProblem();
        
        // Show the solution
        demonstrateSolution();
        
        // Show partial problem
        demonstratePartialProblem();
        
        // Show usage with streams
        streamWithHashMap();
        
        // Best practices
        bestPractices();
    }
}
