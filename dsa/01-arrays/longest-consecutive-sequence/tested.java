import java.util.*;
import java.util.stream.Collectors;

public class Main {

    // =========================================================
    // APPROACH 1: BRUTE FORCE
    // Time: O(n^2), Space: O(1)
    // When: Only for understanding
    // Why not: Too slow
    // =========================================================
    public static int longestConsecutiveBrute(int[] nums) {
        int longest = 0;

        for (int num : nums) {
            int current = num;
            int count = 1;

            while (contains(nums, current + 1)) {
                current++;
                count++;
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }

    private static boolean contains(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) return true;
        }
        return false;
    }

    // =========================================================
    // APPROACH 2: SORTING
    // Time: O(n log n), Space: O(1)
    // When: Easy implementation
    // Why not: Not optimal
    // =========================================================
    public static int longestConsecutiveSort(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);

        int longest = 1, current = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) continue;

            if (nums[i] == nums[i - 1] + 1) {
                current++;
            } else {
                longest = Math.max(longest, current);
                current = 1;
            }
        }

        return Math.max(longest, current);
    }

    // =========================================================
    // APPROACH 3: HASHSET (OPTIMAL 🔥)
    // Time: O(n), Space: O(n)
    // When: BEST choice for interviews
    // Why: Avoids re-processing using "start of sequence"
    // =========================================================
    public static int longestConsecutiveSet(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) set.add(num);

        int longest = 0;

        for (int num : set) {

            // Only start if it's beginning
            if (!set.contains(num - 1)) {

                int current = num;
                int count = 1;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    // =========================================================
    // APPROACH 4: HASHMAP (DP / MERGE)
    // Time: O(n), Space: O(n)
    // When: When interviewer asks for optimization or merging logic
    // Why: Efficient boundary merging
    // =========================================================
    public static int longestConsecutiveMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (int num : nums) {
            if (!map.containsKey(num)) {

                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);

                int sum = left + right + 1;

                map.put(num, sum);

                // update boundaries
                map.put(num - left, sum);
                map.put(num + right, sum);

                max = Math.max(max, sum);
            }
        }

        return max;
    }

    // =========================================================
    // APPROACH 5: UNION-FIND (ADVANCED 🔥)
    // Time: ~O(n) (amortized)
    // Space: O(n)
    // When: When problem is about connectivity / components
    // Why: Treat sequence as connected graph
    // Why NOT: Overkill for this problem (HashSet is simpler)
    // =========================================================
    public static int longestConsecutiveUF(int[] nums) {
        if (nums.length == 0) return 0;

        Map<Integer, Integer> indexMap = new HashMap<>();
        UnionFind uf = new UnionFind(nums.length);

        // map value -> index
        for (int i = 0; i < nums.length; i++) {
            if (!indexMap.containsKey(nums[i])) {
                indexMap.put(nums[i], i);
            }
        }

        for (int num : indexMap.keySet()) {

            if (indexMap.containsKey(num + 1)) {
                uf.union(indexMap.get(num), indexMap.get(num + 1));
            }
        }

        return uf.getMaxSize();
    }

    // =========================================================
    // UNION-FIND CLASS
    // =========================================================
    static class UnionFind {
        int[] parent;
        int[] size;
        int maxSize = 1;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // path compression
            }
            return parent[x];
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) return;

            // union by size
            if (size[rootA] < size[rootB]) {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
                maxSize = Math.max(maxSize, size[rootB]);
            } else {
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
                maxSize = Math.max(maxSize, size[rootA]);
            }
        }

        public int getMaxSize() {
            return maxSize;
        }
    }

    // =========================================================
    // APPROACH 6: STREAM
    // Time: O(n), Space: O(n)
    // When: Java functional style
    // Why not: Less readable in interviews
    // =========================================================
    public static int longestConsecutiveStream(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        return set.stream()
                .filter(num -> !set.contains(num - 1))
                .mapToInt(num -> {
                    int current = num;
                    int count = 1;

                    while (set.contains(current + 1)) {
                        current++;
                        count++;
                    }

                    return count;
                })
                .max()
                .orElse(0);
    }

    // =========================================================
    // MAIN METHOD
    // =========================================================
    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println("Brute: " + longestConsecutiveBrute(nums));
        System.out.println("Sort: " + longestConsecutiveSort(nums));
        System.out.println("HashSet (Best): " + longestConsecutiveSet(nums));
        System.out.println("HashMap: " + longestConsecutiveMap(nums));
        System.out.println("UnionFind: " + longestConsecutiveUF(nums));
        System.out.println("Stream: " + longestConsecutiveStream(nums));
    }
}
