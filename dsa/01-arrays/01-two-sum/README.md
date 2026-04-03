# Two Sum Problem Documentation

**LeetCode ID:** 1  

**Problem Description:**  
The Two Sum problem requires you to find two numbers in an array that add up to a specific target number. You will return the indices of these two numbers.

## Approaches:

### 1. Brute Force Solution  
- **Description:** Check each pair of numbers to see if they add up to the target.  
- **Time Complexity:** O(n^2)  
- **Space Complexity:** O(1)  
- **Use Cases:** Simple implementation; works for small arrays.

### 2. Hash Map Solution  
- **Description:** Use a hash map to store the difference between the target and current number as you iterate through the array.  
- **Time Complexity:** O(n)  
- **Space Complexity:** O(n)  
- **Use Cases:** More efficient for larger arrays.