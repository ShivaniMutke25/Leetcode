import java.util.*;

public class Main {

    // 1. Brute Force
    public static int majorityElementBrute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int count = 0;

            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i]) count++;
            }

            if (count > nums.length / 2) return nums[i];
        }
        return -1;
    }

    // 2. Sorting
    public static int majorityElementSort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // 3. HashMap
    public static int majorityElementMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }

    // 4. Boyer-Moore (BEST 🔥)
    public static int majorityElementOptimal(int[] nums) {

        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) candidate = num;

            if (num == candidate) count++;
            else count--;
        }

        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};

        System.out.println("Brute: " + majorityElementBrute(nums));
        System.out.println("Sort: " + majorityElementSort(nums));
        System.out.println("Map: " + majorityElementMap(nums));
        System.out.println("Optimal: " + majorityElementOptimal(nums));
    }
}
