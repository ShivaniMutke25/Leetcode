/**
 * Sort on Each Query Approach - Find Median from Data Stream
 * 
 * Logic:
 * - Maintain array of elements
 * - On each median query, sort array and return median
 * 
 * When to use: Simple implementation, few queries
 * When NOT to use: Many queries, streaming data
 * 
 * Time Complexity: O(n log n) - sorting on each query
 * Space Complexity: O(n) - storing all elements
 */
class MedianFinder {
    private List<Integer> elements;
    
    public MedianFinder() {
        this.elements = new ArrayList<>();
    }
    
    public void addNum(int num) {
        elements.add(num);
    }
    
    public double findMedian() {
        Collections.sort(elements);
        int n = elements.size();
        
        if (n % 2 == 1) {
            return elements.get(n / 2);
        } else {
            return (elements.get(n / 2 - 1) + elements.get(n / 2)) / 2.0;
        }
    }
}

/*
Example Walkthrough:
addNum(1): elements = [1]
addNum(2): elements = [1,2]
findMedian():
  Collections.sort() → [1,2]
  n = 2 (even)
  return (elements.get(0) + elements.get(1)) / 2.0 = (1 + 2) / 2.0 = 1.5

addNum(3): elements = [1,2,3]
findMedian():
  Collections.sort() → [1,2,3]
  n = 3 (odd)
  return elements.get(1) = 2

Result: [null, null, null, 1.5, null, 2.0]

Why this works:
- Sorting puts elements in order
- Median is middle element(s) based on odd/even size
- Simple to implement and understand
- Works for any valid input

Why this is not optimal:
- Time complexity is O(n log n) per query
- For many queries, this is very expensive
- Sorting entire array when we only need median
- Space is O(n) but time is too high

Key limitation: Sorting entire array on each median query
*/
