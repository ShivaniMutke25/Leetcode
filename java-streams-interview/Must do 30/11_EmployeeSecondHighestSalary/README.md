# Employee Second Highest Salary

## Problem Statement
Find the employee with the second highest salary from a list of employees.

### Input
```
List<Employee> employees = [
    Employee("Alice", 50000),
    Employee("Bob", 75000),
    Employee("Charlie", 60000)
]
```

### Output
```
Employee("Charlie", 60000)
```

## Approach

### Using Java Streams
1. **Get distinct salaries** - Stream employees and extract unique salary values
2. **Sort descending** - Sort salaries in descending order
3. **Skip first** - Skip the highest salary
4. **Get second** - Return the next highest salary
5. **Find employee** - Find employee with that salary

**Step-by-step execution:**
```
Input: [Alice(50000), Bob(75000), Charlie(60000)]
  ↓
Get salaries: [50000, 75000, 60000]
  ↓
Get distinct: [50000, 75000, 60000]
  ↓
Sort descending: [75000, 60000, 50000]
  ↓
Skip 1: [60000, 50000]
  ↓
Get first: 60000
  ↓
Find employee: Charlie(60000)
```

## Time Complexity
**O(n log n)** where n is the number of employees
- Sorting salaries: **O(n log n)** ← dominant
- Finding employee: **O(n)**

## Space Complexity
**O(n)** for storing distinct salaries and sorted stream

## Code Implementation
See [Main.java](./Main.java)
