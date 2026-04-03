# Count Employees by Department

## Problem Statement
Count the number of employees in each department. Return a map where key is department name and value is the count.

### Input
```
List<Employee> employees = [
    Employee("Alice", "HR"),
    Employee("Bob", "IT"),
    Employee("Charlie", "HR")
]
```

### Output
```
{HR=2, IT=1}
```

## Approach

### Using Java Streams
1. **Stream employees** - Create a stream of employees
2. **Group by department** - Use `groupingBy(Employee::getDepartment)`
3. **Count** - Use `Collectors.counting()` as the downstream collector
4. **Return map** - Result is a map of department -> count

**Step-by-step execution:**
```
Input: [Alice(HR), Bob(IT), Charlie(HR)]
  ↓
Group by department
  ├─ HR: [Alice, Charlie]
  └─ IT: [Bob]
  ↓
Count each group
  {HR=2, IT=1}
```

## Time Complexity
**O(n)** where n is the number of employees
- Grouping and counting: **O(n)** (single pass)

## Space Complexity
**O(d)** where d is the number of departments
- Map stores one entry per department: **O(d)** (≤ n)

## Code Implementation
See [Main.java](./Main.java)
