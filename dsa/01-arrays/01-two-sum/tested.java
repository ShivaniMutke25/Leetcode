class Solution {
    //bruteforce
    /** 
    public int[] twoSum(int[] nums, int target) {
       for(int i=0;i<nums.length;i++){
        for(int j=i+1;j<nums.length;j++){
            if(nums[i]+nums[j]==target){
                return new int[]{i,j};
            }
        }
       } 
       return new int[]{-1,-1};
    }
    **/
    //Hashmap
    /** 
    public static int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int  complement = target -nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }*/
    //two pointer - only if array is sorted 
    /** 
    public static int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[] { left, right };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] { -1, -1 };
    }*/
    //return all valid pairs
    public static List<List<Integer>> twoSumAllPairs(int[] nums, int target) {
    
    // Map to store: number -> list of indices where it appears
    Map<Integer, List<Integer>> map = new HashMap<>();
    
    // Final result: list of index pairs
    List<List<Integer>> result = new ArrayList<>();

    // Traverse the array
    for (int i = 0; i < nums.length; i++) {
        
        // Find the required number to reach target
        int complement = target - nums[i];

        // 🔍 Check if complement already exists in map
        if (map.containsKey(complement)) {
            
            // There may be multiple indices for the complement
            for (int index : map.get(complement)) {
                
                // Add all valid pairs (previous index, current index)
                result.add(Arrays.asList(index, i));
            }
        }

        // 🧠 Store current number with its index
        // If number already exists → append index
        // Else → create new list
        map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
    }

    return result;
}
}
