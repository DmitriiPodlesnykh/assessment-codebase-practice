/**
 * Source: https://leetcode.com/problems/maximum-subarray
 *
 * Time Submitted   | Status | Runtime| Memory
 * 12/11/2021 22:02	|Accepted|16 ms   |	49 MB
 * Runtime: 15 ms, faster than 6.23% of submissions. Memory Usage: 48.9 MB, less than 91.96% of submissions.
 */
public class MaximumSubarraySolution {
   public int maxSubArray(int[] nums) {
        
        int maxSumValue = nums[0];
        for (int i = 0; i< nums.length; i++) {
            
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                int startValue = nums[j];
                sum = sum + startValue;
                
                if (startValue > sum) {
                    break;
                } else if (maxSumValue < sum) {
                    maxSumValue = sum;
                }
                if (j == nums.length-1 ) {
                    return maxSumValue;
                }
            }
        }
        return maxSumValue;
    }
}

/**
 * Time Submitted   | Status             | Runtime| Memory
 * 12/11/2021 15:07 |Time Limit Exceeded	| N/A	   | N/A
 *
 */
class TimeLimitExceededMaximumSubarraySolution {
  
  public int maxSubArray(int[] nums) {
        
        int maxSumValue = nums[0];
        for (int i = 0; i< nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (maxSumValue < sum) {
                    maxSumValue = sum;
                }
            }
        }
        return maxSumValue;
    }
}
  
  
 
