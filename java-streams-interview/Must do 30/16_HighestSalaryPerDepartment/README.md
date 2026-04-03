# Highest Salary per Department

## Problem Statement
Find the highest salary in each department. Return a map where key is department name and value is the highest salary in that department.

### Input
```
List<Employee> employees = [
    Employee("Alice", "HR", 50000),
    Employee("Bob", "IT", 75000),
    Employee("Charlie", "HR", 60000)
]
```

### Output
```
{HR=60000.0, IT=75000.0}
```

## Approach

### Using Java Streams
1. **Stream employees** - Create a stream of employees
2. **Group by department** - Use `groupingBy(Employee::getDepartment)`
3. **Find max salary** - Use `Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))` as downstream collector
4. **Map to value** - Extract the salary value from the Optional
5. **Return map** - Result is a map of department -> maximum salary

**Step-by-step execution:**
```
Input: [Alice(HR,50000), Bob(IT,75000), Charlie(HR,60000)]
  ↓
Group by department
  ├─ HR: [Alice(50000), Charlie(60000)]
  └─ IT: [Bob(75000)]
  ↓
Find max salary in each group
  HR: max = 60000
  IT: max = 75000
  ↓
Output: {HR=60000.0, IT=75000.0}
```

## Time Complexity
**O(n)** where n is the number of employees
- Grouping and finding max: **O(n)** (single pass, each employee processed once)

## Space Complexity
**O(d)** where d is the number of departments
- Map stores one entry per department: **O(d)** (≤ n)

## Code Implementation
See [Main.java](./Main.java)
