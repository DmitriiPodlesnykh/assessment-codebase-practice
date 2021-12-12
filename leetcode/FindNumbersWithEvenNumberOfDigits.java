
/**
 * Source: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 *
 * Time Submitted   | Status   | Runtime| Memory
 * 12/12/2021 12:01	|Accepted	 |1 ms	  | 38.2 MB	
 *
 * Runtime: 1 ms, faster than 96.61% of submissions. Memory Usage: 38.2 MB, less than 97.88% of submissions.
 *
 */
public class FindNumbersWithEvenNumberOfDigits {
  
  public int findNumbers(int[] nums) {
        int result = 0;
        for (int index = 0; index<nums.length; index++) { 
            int numberCount = 0;
            int checkedValue = nums[index];
            while (checkedValue != 0) {
                checkedValue = checkedValue/10;
                numberCount++;
            }
            if (numberCount%2 == 0) {
                result++;
            }
        }
        
        return result;
    }
  
}
