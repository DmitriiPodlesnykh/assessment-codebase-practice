class Solution {
    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i< arr.length ; i++) {
            for (int j = 0; j< arr.length ; j++) {
                if (i != j) {
                    if (arr[j] != 0) {
                        final int result1 = arr[i]/arr[j];
                        final int result2 = arr[i]%arr[j];
                        
                        if (result1 == 2 && result2 == 0) {
                            return true;
                        } 
                        
                    } else if (arr[j] == 0 && arr[i] == 0){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
