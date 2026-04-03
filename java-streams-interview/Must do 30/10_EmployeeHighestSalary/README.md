# Employee Highest Salary

## Problem Statement
Find the employee with the highest salary from a list of employees. Each employee has a name and salary.

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
Employee("Bob", 75000)
```

## Approach

### Using Java Streams
1. **Create comparator** - Use `Comparator.comparingDouble(Employee::getSalary)`
2. **Find maximum** - Use `max()` with the comparator
3. **Return result** - Use `orElse()` for null safety

**Alternative approaches:**
1. Sort by salary descending and get first element
2. Use `reduce()` to find max
3. Use `max()` with custom comparator

**Step-by-step execution:**
```
Input: [Alice(50000), Bob(75000), Charlie(60000)]
  ↓
Compare salaries
  ↓
Find maximum: Bob(75000)
  ↓
Output: Bob(75000)
```

## Time Complexity
**O(n)** where n is the number of employees
- Stream through all employees: **O(n)**
- Max operation: **O(n)** (single pass)

## Space Complexity
**O(1)** - Only storing the result

## Code Implementation
See [Main.java](./Main.java)
