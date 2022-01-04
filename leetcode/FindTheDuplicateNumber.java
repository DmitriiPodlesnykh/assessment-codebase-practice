/**
  * https://leetcode.com/problems/find-the-duplicate-number/submissions/
  */
class FindTheDuplicateNumber {
  
    /**
      * Runtime: 23 ms, faster than 24.28% of Java online submissions for Find the Duplicate Number.
      * Memory Usage: 52.2 MB, less than 92.93% of Java online submissions for Find the Duplicate Number.
      */
    public int findDuplicate(int[] nums) {
        final Set<Integer> numberSet = new HashSet<>();
        
        for (int i=0; i<nums.length; i++) {
            if (numberSet.contains(nums[i])) {
                return nums[i];
            } else {
                numberSet.add(nums[i]);
            }
        }
        return 0;
    }
}
