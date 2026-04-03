# Second Highest Salary per Department

## Problem Statement
Find the second highest salary in each department. Return a map where key is department name and value is the second highest salary.

### Input
```
List<Employee> employees = [
    Employee("Alice", "HR", 50000),
    Employee("Bob", "IT", 75000),
    Employee("Charlie", "HR", 60000),
    Employee("Dave", "IT", 80000)
]
```

### Output
```
{HR=50000.0, IT=75000.0}
```

## Approach

### Using Java Streams
1. **Stream employees** - Create stream of employees
2. **Group by department** - Use `groupingBy(Employee::getDepartment)`
3. **Get distinct salaries** - For each department, get unique salary values
4. **Sort descending** - Sort salaries in descending order
5. **Skip first** - Skip the highest salary
6. **Get second** - Get the second highest salary

**Step-by-step execution:**
```
Input: [Alice(HR,50000), Bob(IT,75000), Charlie(HR,60000), Dave(IT,80000)]
  ↓
Group by department
  ├─ HR: [50000, 60000]
  └─ IT: [75000, 80000]
  ↓
For each group, sort descending and skip 1
  HR: [60000, 50000] -> skip 1 -> 50000 (2nd = 50000)
  IT: [80000, 75000] -> skip 1 -> 75000 (2nd = 75000)
  ↓
Output: {HR=50000.0, IT=75000.0}
```

## Time Complexity
**O(n log n)** where n is the number of employees
- Grouping: **O(n)**
- Sorting in each group: **O(k log k)** where k is employees per department (≤ n)
- Overall: **O(n log n)** in worst case when employees are evenly distributed

## Space Complexity
**O(n)** for storing grouped employees

## Code Implementation
See [Main.java](./Main.java)
