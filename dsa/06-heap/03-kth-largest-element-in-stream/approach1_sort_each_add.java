/**
 * Sort on Each Add Approach - Kth Largest Element in a Stream
 * 
 * Logic:
 * - Maintain array of elements
 * - On each add, insert element and sort array
 * - Return kth largest element
 * 
 * When to use: Simple implementation, few add operations
 * When NOT to use: Many add operations, streaming data
 * 
 * Time Complexity: O(n log n) - sorting on each add
 * Space Complexity: O(n) - storing all elements
 */
class KthLargest {
    private int k;
    private List<Integer> elements;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.elements = new ArrayList<>();
        for (int num : nums) {
            elements.add(num);
        }
    }
    
    public int add(int val) {
        elements.add(val);
        Collections.sort(elements);
        return elements.get(elements.size() - k);
    }
}

/*
Example Walkthrough:
k = 3, nums = [4,5,8,2]

Initialize: elements = [4,5,8,2]

add(3):
  elements.add(3) → [4,5,8,2,3]
  Collections.sort() → [2,3,4,5,8]
  return elements.get(5-3) = elements.get(2) = 4

add(5):
  elements.add(5) → [2,3,4,5,8,5]
  Collections.sort() → [2,3,4,5,5,8]
  return elements.get(6-3) = elements.get(3) = 5

add(10):
  elements.add(10) → [2,3,4,5,5,8,10]
  Collections.sort() → [2,3,4,5,5,8,10]
  return elements.get(7-3) = elements.get(4) = 5

add(9):
  elements.add(9) → [2,3,4,5,5,8,10,9]
  Collections.sort() → [2,3,4,5,5,8,9,10]
  return elements.get(8-3) = elements.get(5) = 8

add(4):
  elements.add(4) → [2,3,4,5,5,8,9,10,4]
  Collections.sort() → [2,3,4,4,5,5,8,9,10]
  return elements.get(9-3) = elements.get(6) = 8

Result: [null, 4, 5, 5, 8, 8]

Why this works:
- Sorting puts elements in order
- kth largest is at position n-k from start
- Simple to implement and understand
- Works for any valid input

Why this is not optimal:
- Time complexity is O(n log n) per add operation
- For many add operations, this is very expensive
- Sorting entire array when we only need kth element
- Space is O(n) but time is too high

Key limitation: Sorting entire array on each add operation
*/
