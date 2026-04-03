# Average Salary by Department

## Problem Statement
Calculate the average salary for each department. Return a map where key is department name and value is the average salary.

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
{HR=55000.0, IT=75000.0}
```

## Approach

### Using Java Streams
1. **Stream employees** - Create a stream of employees
2. **Group by department** - Use `groupingBy(Employee::getDepartment)`
3. **Calculate average** - Use `Collectors.averagingDouble(Employee::getSalary)` as downstream collector
4. **Return map** - Result is a map of department -> average salary

**Step-by-step execution:**
```
Input: [Alice(HR,50000), Bob(IT,75000), Charlie(HR,60000)]
  ↓
Group by department
  ├─ HR: [50000, 60000]
  └─ IT: [75000]
  ↓
Calculate average of each group
  HR: (50000 + 60000) / 2 = 55000
  IT: 75000 / 1 = 75000
  ↓
Output: {HR=55000.0, IT=75000.0}
```

## Time Complexity
**O(n)** where n is the number of employees
- Grouping and averaging: **O(n)** (single pass)

## Space Complexity
**O(d)** where d is the number of departments
- Map stores one entry per department: **O(d)** (≤ n)

## Code Implementation
See [Main.java](./Main.java)
