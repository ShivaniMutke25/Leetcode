# Binary Search Problems - DSA Master Collection

This folder contains comprehensive solutions for binary search problems asked in technical interviews, with multiple approaches for each problem including time/space complexity analysis and usage guidelines.

## 📋 Problem List

| # | Problem | LeetCode ID | Difficulty | Best Approach | Time | Space |
|---|---------|-------------|------------|---------------|------|-------|
| 1 | [Binary Search](./01-binary-search/) | 704 | Easy | Binary Search | O(log n) | O(1) |
| 2 | [Search Insert Position](./02-search-insert-position/) | 35 | Easy | Binary Search | O(log n) | O(1) |
| 3 | [Find First and Last Position](./03-find-first-and-last-position/) | 34 | Medium | Two Binary Searches | O(log n) | O(1) |
| 4 | [Search in Rotated Sorted Array](./04-search-in-rotated-sorted-array/) | 33 | Medium | Modified Binary Search | O(log n) | O(1) |
| 5 | [Find Minimum in Rotated Sorted Array](./05-find-minimum-in-rotated-sorted-array/) | 153 | Medium | Modified Binary Search | O(log n) | O(1) |
| 6 | [Koko Eating Bananas](./06-koko-eating-bananas/) | 875 | Medium | Binary Search + Math | O(n log max) | O(1) |
| 7 | [Capacity to Ship Packages](./07-capacity-to-ship-packages-within-d-days/) | 1011 | Medium | Binary Search | O(n log sum) | O(1) |
| 8 | [Minimum Days to Make m Bouquets](./08-minimum-days-to-make-m-bouquets/) | 1482 | Medium | Binary Search | O(n log days) | O(1) |
| 9 | [Find Peak Element](./09-find-peak-element/) | 162 | Medium | Binary Search | O(log n) | O(1) |
| 10 | [Search a 2D Matrix](./10-search-a-2d-matrix/) | 74 | Medium | 2D Binary Search | O(log m + log n) | O(1) |
| 11 | [Split Array Largest Sum](./11-split-array-largest-sum/) | 410 | Hard | Binary Search + Prefix Sum | O(n log n) | O(n) |
| 12 | [Search a 2D Matrix II](./12-search-a-2d-matrix-ii/) | 240 | Hard | 2D Binary Search | O(log m + log n) | O(1) |
| 13 | [Peak Index in a Mountain Array](./13-peak-index-in-a-mountain-array/) | 851 | Medium | Binary Search | O(log n) | O(1) |
| 14 | [Median of Two Sorted Arrays](./14-median-of-two-sorted-arrays/) | 4 | Hard | Binary Search | O(log (m+n)) | O(1) |

## 🎯 Key Patterns & Techniques

### 1. **Standard Binary Search**
- **When to use**: Sorted array, find target element
- **Problems**: Binary Search, Search Insert Position
- **Time**: O(log n), **Space**: O(1)
- **Key**: Standard divide and conquer approach

### 2. **Modified Binary Search**
- **When to use**: Rotated sorted arrays, modified conditions
- **Problems**: Search in Rotated Array, Find Minimum in Rotated Array
- **Time**: O(log n), **Space**: O(1)
- **Key**: Adapt binary search to modified conditions

### 3. **Binary Search with Constraints**
- **When to use**: Find element within constraints/conditions
- **Problems**: Koko Eating Bananas, Capacity to Ship Packages
- **Time**: O(n log max), **Space**: O(1)
- **Key**: Use binary search to find optimal value

### 4. **Two Binary Searches**
- **When to use**: Find range or boundaries
- **Problems**: Find First and Last Position
- **Time**: O(log n), **Space**: O(1)
- **Key**: Search for leftmost and rightmost positions

### 5. **2D Binary Search**
- **When to use**: Matrix search problems
- **Problems**: Search a 2D Matrix, Search a 2D Matrix II
- **Time**: O(log m + log n), **Space**: O(1)
- **Key**: Apply binary search on rows and columns

### 6. **Binary Search + Prefix Sum**
- **When to use**: Array problems with sum constraints
- **Problems**: Split Array Largest Sum
- **Time**: O(n log n), **Space**: O(n)
- **Key**: Combine with other techniques for complex problems

## 🛠️ Core Components

### 1. **Binary Search Algorithm**
```java
int binarySearch(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return -1; // Not found
}
```

### 2. **Modified Binary Search**
```java
int searchRotated(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        // Check if mid is the rotation point
        if (nums[mid] >= nums[left]) {
            // Left half is sorted
            if (nums[left] <= target && target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        } else {
            // Right half is sorted
            if (nums[mid] <= target && target <= nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
    
    return -1;
}
```

### 3. **Binary Search with Constraints**
```java
int minEatingSpeed(int[] piles, int h) {
    int maxSpeed = 0;
    
    for (int pile : piles) {
        maxSpeed = Math.max(maxSpeed, pile);
    }
    
    int left = 1, right = maxSpeed;
    
    while (left < right) {
        int mid = left + (right - left) / 2;
        
        if (canEatAll(piles, h, mid)) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    
    return left;
}
```

## 📚 Usage Instructions

### For Each Problem:
1. **Read the README.md** for problem description and approach comparison
2. **Study multiple approaches** from brute force to optimal
3. **Understand complexity analysis** and when to use each approach
4. **Practice interview talking points** provided in each README
5. **Master the pattern** for similar problems

### Learning Path:
1. **Start with easy problems** - Binary Search, Search Insert Position
2. **Progress to medium** - Modified binary search, constraints
3. **Tackle hard problems** - 2D search, prefix sum combinations
4. **Master all patterns** - Standard, modified, constrained, 2D

## 🏆 Interview Strategy

### How to Approach Binary Search Problems:
1. **Identify if binary search applies** - Sorted array, monotonic function
2. **Choose the right variant** - Standard, modified, constrained
3. **Implement carefully** - Handle edge cases, overflow, boundaries
4. **Explain your reasoning** - Why binary search, time/space complexity
5. **Discuss trade-offs** - When to use vs other approaches

### Common Follow-up Questions:
- "Why binary search?" → O(log n) vs O(n) linear search
- "What if array is not sorted?" → Sort first, then apply binary search
- "Can we optimize further?" → No, O(log n) is optimal for search problems
- "What about duplicates?" → Handle carefully in binary search logic

## 📈 Progress Tracking

- ✅ **Problems with complete solutions**: 0/14
- 🔄 **Currently working on**: Folder structure setup
- 📋 **Next steps**: Create individual problem folders with comprehensive solutions

---

## 🎯 Key Insights

- **Binary search** is fundamental for O(log n) search in sorted arrays
- **Modified binary search** handles rotated or partially sorted arrays
- **Constraint-based binary search** finds optimal values within conditions
- **2D binary search** extends the concept to matrix problems
- **Combination approaches** solve complex problems using binary search + other techniques

Master these patterns and you'll be well-prepared for any binary search interview question!
