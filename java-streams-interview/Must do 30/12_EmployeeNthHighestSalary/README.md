# Employee Nth Highest Salary

## Problem Statement
Find the employee with the Nth highest salary, where N is a given parameter.

### Input
```
List<Employee> employees = [
    Employee("Alice", 50000),
    Employee("Bob", 75000),
    Employee("Charlie", 60000)
]
int n = 2
```

### Output
```
Employee("Charlie", 60000)
```

## Approach

### Using Java Streams
1. **Extract salaries** - Stream employees and map to get salary values
2. **Get distinct** - Remove duplicate salaries to get unique values
3. **Sort descending** - Sort in descending order (highest first)
4. **Skip N-1** - Skip all elements before the Nth position
5. **Get Nth salary** - Get the Nth highest salary
6. **Find employee** - Find the employee with that salary

**Step-by-step execution:**
```
Input: [Alice(50000), Bob(75000), Charlie(60000)], N=2
  ↓
Get salaries: [50000, 75000, 60000]
  ↓
Distinct: [50000, 75000, 60000]
  ↓
Sort descending: [75000, 60000, 50000]
  ↓
Skip 1 position: [60000, 50000]
  ↓
Get first: 60000
  ↓
Find employee: Charlie(60000)
```

## Time Complexity
**O(n log n)** where n is the number of employees
- Sorting: **O(n log n)** ← dominant
- Finding employee: **O(n)**

## Space Complexity
**O(n)** for storing distinct salaries

## Code Implementation
See [Main.java](./Main.java)
