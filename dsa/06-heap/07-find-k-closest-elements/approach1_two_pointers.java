/**
 * Two Pointers Approach - Find K Closest Elements
 * 
 * Logic:
 * - Find position where x would be inserted
 * - Use two pointers to expand outward
 * - Compare distances and collect k closest
 * - Sort result at the end
 * 
 * When to use: Sorted arrays, simple implementation
 * When NOT to use: Unsorted arrays, multiple queries
 * 
 * Time Complexity: O(n) - linear scan
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        
        // Find insertion point for x
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                left = mid;
                break;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // Two pointers expanding from insertion point
        int i = left - 1, j = left;
        
        while (k-- > 0) {
            if (i < 0) {
                result.add(arr[j++]);
            } else if (j >= arr.length) {
                result.add(arr[i--]);
            } else {
                int distLeft = Math.abs(arr[i] - x);
                int distRight = Math.abs(arr[j] - x);
                
                if (distLeft <= distRight) {
                    result.add(arr[i--]);
                } else {
                    result.add(arr[j++]);
                }
            }
        }
        
        Collections.sort(result);
        return result;
    }
}

/*
Example Walkthrough:
arr = [1,2,3,4,5], k = 4, x = 3

Find insertion point for x=3:
Binary search finds left = 2 (arr[2] = 3)

Two pointers: i = 1, j = 2

k = 4:
Iteration 1:
  i=1, j=2: distLeft=|2-3|=1, distRight=|3-3|=0
  distRight < distLeft → add arr[2]=3, j=3
  result = [3]

Iteration 2:
  i=1, j=3: distLeft=|2-3|=1, distRight=|4-3|=1
  distLeft <= distRight → add arr[1]=2, i=0
  result = [3,2]

Iteration 3:
  i=0, j=3: distLeft=|1-3|=2, distRight=|4-3|=1
  distRight < distLeft → add arr[3]=4, j=4
  result = [3,2,4]

Iteration 4:
  i=0, j=4: distLeft=|1-3|=2, distRight=|5-3|=2
  distLeft <= distRight → add arr[0]=1, i=-1
  result = [3,2,4,1]

Sort result: [1,2,3,4]

Result: [1,2,3,4]

Why this works:
- Binary search finds where x would be inserted
- Two pointers expand outward comparing distances
- Collects k closest elements efficiently
- Final sort ensures ascending order

Why this is optimal:
- Time: O(n) - optimal for this problem
- Space: O(1) - constant extra space
- Leverages sorted array property
- Simple and efficient implementation

Key insights:
- Binary search to find insertion point
- Two pointers for outward expansion
- Distance comparison for tie-breaking
- Final sort for required order

This is perfect solution!
*/
