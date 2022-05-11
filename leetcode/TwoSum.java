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
    
    public int[] twoSum(int[] nums, int target) {
        
    }
}
