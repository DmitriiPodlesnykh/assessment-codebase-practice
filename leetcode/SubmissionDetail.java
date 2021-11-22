class Solution {
    public void duplicateZeros(int[] arr) {
        for (int i = 0; i<arr.length; i++) {
            if (arr[i] == 0) {
                i++;
                final int lastArrIndex = arr.length-1;
                for(int j=lastArrIndex; j>i-1; j--) {
                    arr[j] = arr[j-1]; 
                }
                
            }
        }
    }
}
