/**
 * Merge One by One Approach - Merge K Sorted Lists
 * 
 * Logic:
 * - Start with first list as result
 * - Iteratively merge each remaining list into result
 * - Use standard two-list merge algorithm
 * 
 * When to use: Small k, simple implementation
 * When NOT to use: Large k, many lists
 * 
 * Time Complexity: O(kn) - merge each list into result
 * Space Complexity: O(1) - in-place merging
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        ListNode result = lists[0];
        
        for (int i = 1; i < lists.length; i++) {
            result = mergeTwoLists(result, lists[i]);
        }
        
        return result;
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        current.next = (l1 != null) ? l1 : l2;
        
        return dummy.next;
    }
}

/*
Example Walkthrough:
lists = [[1,4,5],[1,3,4],[2,6]]

result = [1,4,5]

Merge with [1,3,4]:
  Compare 1 vs 1 → take 1 from first list
  Compare 4 vs 1 → take 1 from second list
  Compare 4 vs 3 → take 3 from second list
  Compare 4 vs 4 → take 4 from first list
  Compare 5 vs 4 → take 4 from second list
  Compare 5 vs null → take 5 from first list
  Result: [1,1,3,4,4,5]

Merge with [2,6]:
  Compare 1 vs 2 → take 1
  Compare 1 vs 2 → take 1
  Compare 3 vs 2 → take 2
  Compare 3 vs 6 → take 3
  Compare 4 vs 6 → take 4
  Compare 4 vs 6 → take 4
  Compare 5 vs 6 → take 5
  Compare null vs 6 → take 6
  Result: [1,1,2,3,4,4,5,6]

Why this works:
- Standard merge algorithm works correctly
- Simple to understand and implement
- Each merge maintains sorted order
- Works for any valid input

Why this is not optimal:
- Time complexity is O(kn) - merging repeatedly
- For large k, this becomes very expensive
- Each element is processed multiple times
- Doesn't leverage that we can merge all at once

Key limitation: Merging lists sequentially instead of all at once
*/
