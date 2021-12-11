/**
 * Source: https://leetcode.com/problems/maximum-subarray
 *
 */
public class MaximumSubarraySolution {
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
  
  
 
