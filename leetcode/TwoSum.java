class Solution {
    public int[] twoSum(int[] nums, int target) {
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
}
