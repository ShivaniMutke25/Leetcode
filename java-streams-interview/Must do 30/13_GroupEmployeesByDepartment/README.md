# Group Employees by Department

## Problem Statement
Group a list of employees by their department. Return a map where key is department name and value is list of employees in that department.

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
{
    HR: [Alice, Charlie],
    IT: [Bob]
}
```

## Approach

### Using Java Streams
1. **Stream employees** - Create a stream of employees
2. **Group by department** - Use `Collectors.groupingBy(Employee::getDepartment)`
3. **Configure collector** - Collect employees into a list
4. **Return map** - Result is a map with department as key and list of employees as value

**Step-by-step execution:**
```
Input: [Alice(HR), Bob(IT), Charlie(HR)]
  ↓
Group by department field
  ├─ HR: [Alice, Charlie]
  └─ IT: [Bob]
  ↓
Output: {HR=[Alice, Charlie], IT=[Bob]}
```

## Time Complexity
**O(n)** where n is the number of employees
- Grouping: **O(n)** (single pass, each employee processed once)

## Space Complexity
**O(n)** for storing all employees in the resulting map
- Map: **O(d)** where d is number of departments (≤ n)
- Total with values: **O(n)**

## Code Implementation
See [Main.java](./Main.java)
