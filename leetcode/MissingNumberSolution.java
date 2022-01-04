/** 
  * https://leetcode.com/problems/missing-number/submissions/
  */
class MissingNumberSolution {
  
    /** 
      * Runtime: 4 ms, faster than 28.29% of Java online submissions for Missing Number.
      * Memory Usage: 39.6 MB, less than 31.26% of Java online submissions for Missing Number.
      */
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i=0; i< nums.length; i++) { 
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
}
