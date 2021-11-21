class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=0; i<prices.length-1; i++) {
            i = findNextMinIndex(i, prices);
            
            if (i == -1) {
                return profit;
            }
            final int firstPoint = prices[i];
            
            i++;
            i = findNextMaxIndex(i, prices);
            if (i == -1) {
                return profit;
            }
            final int secondPoint = prices[i];
            
            profit = profit + secondPoint - firstPoint;
        }
        return profit;
    }
    
    private int findNextMaxIndex(int currentIndex, int[] nums) {
        for (int i=currentIndex; i<nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                return i;
            } 
        }
        return nums.length-1;
    }
    
    private int findNextMinIndex(int currentIndex, int[] nums) {
        for (int i=currentIndex; i<nums.length-1; i++) {
            if (nums[i] < nums[i+1] ) {
                return i;
            }
        }
        return -1;
    }
}
