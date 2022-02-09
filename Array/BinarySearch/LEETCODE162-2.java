class Solution {
    
    public int findPeakElement(int[] nums) {
        
        if (nums.length == 1) return 0;
        
        int l = 0, r = nums.length-1;
        
        while (l < r) {
            
            int pivot = (l+r) / 2;
            
            if (nums[pivot] < nums[pivot+1]) l = pivot+1;
            else r = pivot;
        }
        
        return l;
    }
}