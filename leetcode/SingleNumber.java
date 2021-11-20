class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int counter = 1;
        int prevNum = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] != prevNum) {
                if (counter == 1) {
                    return prevNum;
                } else {
                    counter = 1;
                    prevNum = nums[i];
                }
            } else {
                counter++;
            }
        }
        return nums[nums.length-1];
    }
}
