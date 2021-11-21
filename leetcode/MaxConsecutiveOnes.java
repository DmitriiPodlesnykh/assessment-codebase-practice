class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int currentCount = 0;
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] == 1 && i != nums.length -1) {
                currentCount++;
            } else if (nums[i] == 0 || i == nums.length -1 ) {
                if (nums[i] == 1) {
                   currentCount++;
                }
                if (result < currentCount) {
                    result = currentCount;
                }
                currentCount = 0;
            }
        }
        return result;
    }
}
