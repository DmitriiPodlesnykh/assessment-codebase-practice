/**
 * Source: https://leetcode.com/problems/squares-of-a-sorted-array
 *
 * Time Submitted   | Status   | Runtime| Memory
 * 12/12/2021 12:06	|Accepted	 |3 ms	  |41.1 MB
 *
 * Runtime: 3 ms, faster than 32.36% of submissions. Memory Usage: 41.1 MB, less than 48.27% of submissions.
 *
 */
public class SquaresOfASortedArray {
  
  public int[] sortedSquares(int[] nums) {
        for(int index=0; index<nums.length; index++) {
            nums[index] = nums[index] * nums[index];
        }
        
        Arrays.sort(nums);
        return nums;
    }
}
