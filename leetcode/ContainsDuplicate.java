class Solution {
    
    public boolean containsDuplicate(int[] nums) {
        int uniqueNumsIndex = 0;
        for (int i=0; i< nums.length; i++) {
            final int currentElement = nums[i];
            for(int j=i+1; j<nums.length; j++) {
                if (nums[i] == nums[j]) {
                     return true;
                }  
            }
        }
        return false;
    }
}
