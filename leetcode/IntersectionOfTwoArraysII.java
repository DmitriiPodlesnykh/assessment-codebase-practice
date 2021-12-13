/**
 * Source: https://leetcode.com/problems/intersection-of-two-arrays-ii/submissions/
 *
 * Time Submitted   | Status   | Runtime| Memory
 * 12/14/2021 00:32	|Accepted  |	4 ms	| 38.9 MB
 *
 * Runtime: faster than 38.60% of submissions. Memory Usage: less than 96.09% of submissions.
 *
 */
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return removeNotDuplicates(nums1, nums2);
        } else {
            return removeNotDuplicates(nums2, nums1);
        }
    }
    
    private int[] removeNotDuplicates(int[] biggerArray, int[] smallerArray) {
        int resultLength = 0;
        for (int i=0; i<biggerArray.length; i++) {
                int iValue = biggerArray[i];
                boolean isMatch = false;
                for (int j=0; j<smallerArray.length; j++) {
                    if (iValue == smallerArray[j]) {
                        smallerArray[j] = -1;
                        isMatch = true;
                        resultLength++;
                        break;
                    }
                }
            if (isMatch) {
                isMatch = false;
            } else {
                biggerArray[i] = -1;
            }
        }
        
        
        int[] result = new int[resultLength];
        
        int resultIndex = 0;
        for (int i=0; i<biggerArray.length; i++) {
            if (biggerArray[i] != -1) {
                
                result[resultIndex] = biggerArray[i];
                resultIndex++;
            }
        }
        return result;
    }
}
