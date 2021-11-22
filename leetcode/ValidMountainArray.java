class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length <3) {
            return false;
        }
        final int maxIndex = findMaxIndex(arr);
        final int maxValue = arr[maxIndex];
        if (maxValue == arr[0]) {
            return false;
        }
        int leftCheck = arr[0];
        for (int i = 1; i<= maxIndex; i++) {
            if (arr[i] >maxValue || arr[i] < leftCheck || arr[i] == arr[i-1]) {
                return false;
            } else if (leftCheck < arr[i]) {
                leftCheck = arr[i];
            }
        }
        int rightCheck = maxValue;
        if (maxIndex >= (arr.length-1)) { 
            return false;
        }
        for (int i = maxIndex+1; i< arr.length; i++) {
            if (arr.length-1 == i) {
                if (arr[i] == maxValue) {
                    return false;
                }
                
            }
            if (i<arr.length) {
               if ( arr[i] >= maxValue || arr[i] > rightCheck || arr[i] == arr[i-1]) {
                    return false;
                } else if (arr[i] < rightCheck) {
                    rightCheck = arr[i];
                } 
            }
        }
        return true;
    }
    
    private int findMaxIndex(int[] arr) {
        int max = arr[0];
        int maxIndex = 0;
        for (int i=1; i<arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
