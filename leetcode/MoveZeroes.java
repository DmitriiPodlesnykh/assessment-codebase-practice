class Solution {
    public void moveZeroes(int[] nums) {
        for (int i=0; i< nums.length; i++) {
            if (nums[i] != 0) {
                continue;
            }
            int nextNot0Index = findNextNot0Index(i, nums);
            if (nextNot0Index == -1) {
                break;
            }
            
            if (i < nums.length-1) {
                nums[i] = nums[nextNot0Index];
                nums[nextNot0Index] = 0;
            }
        }
    }
    
    private int findNextNot0Index(int currentIndex, int[] nums) {
        for (int i=currentIndex; i< nums.length; i++) {
            if (nums[i] != 0) {
                return i;
            }
        }
        return -1;
    }
}
