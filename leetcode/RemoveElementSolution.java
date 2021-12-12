/**
 * Source: https://leetcode.com/problems/remove-element/
 *
 * Time Submitted   | Status   | Runtime| Memory
 * 12/12/2021 14:28	|Accepted	 |0 ms	  | 37.8 MB
 *
 * Runtime: faster than 100.00%. Memory Usage: less than 38.88% of submissions.
 *
 */
public class RemoveElementSolution {
  
   public int removeElement(int[] nums, int val) {
        int result = nums.length;
        int lastElementIndex = nums.length -1;
        for (int i = 0; i< nums.length; i++) {
            if (nums[i] == val) {
                while (nums[lastElementIndex] == val && lastElementIndex>1) {
                    lastElementIndex--;
                }
                
                if(nums[lastElementIndex] != val) {
                    nums[i] = nums[lastElementIndex];
                    if (lastElementIndex >1) {
                        lastElementIndex--;
                    }
                }
                result--;
            }
        }
        return result;
    }
  
}
