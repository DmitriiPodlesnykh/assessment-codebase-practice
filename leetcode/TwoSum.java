class Solution {
    
    /**
     * Quadratic time complexity O(n2) solution
     * 
     * Runtime: 75 ms, faster than 25.72% of Java online submissions for Two Sum.
     * Memory Usage: 42.3 MB, less than 88.84% of Java online submissions for Two Sum.
     */
    public int[] twoSum_n2(int[] nums, int target) {
        int first;
        int second;
        for (int i=0; i< nums.length; i++) {
            first = nums[i];
            for (int j=i+1; j<nums.length; j++) {
                second = nums[j];
                final int resultSum = first + second;
                if (resultSum == target) {
                    return new int []{i, j};
                }
            }
        }
        return null;
    }
    
    
    /**
     * Liner time complexity O(n) solution
     * 
     * Runtime: 3 ms, faster than 85.25% of Java online submissions for Two Sum.
     * Memory Usage: 46.4 MB, less than 13.02% of Java online submissions for Two Sum.
     */
    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> firstArrayValueIndexMap = new HashMap<>();
        for (int i=0; i< nums.length; i++) {
            int calculation = target - nums[i];
            
            if (firstArrayValueIndexMap.containsKey(calculation)) {
                return new int[] {firstArrayValueIndexMap.get(calculation), i};
            }
            
            firstArrayValueIndexMap.put(nums[i], i);
        }
        return null;
    }
}
