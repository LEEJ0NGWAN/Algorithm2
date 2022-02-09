class Solution {
        
    private boolean isPeak(int[] nums, int pivot) {
        
        if (pivot == 0) return nums[0] > nums[1];

        if (pivot == (nums.length-1)) return nums[pivot-1] < nums[pivot];
        
        return nums[pivot-1] < nums[pivot] && nums[pivot] > nums[pivot+1];
    }
    
    private int binarySearch(int[] nums, int l, int r) {
                
        int pivot = (l+r) / 2;
        
        if (isPeak(nums, pivot)) return pivot;
        
        if (l != r) {
            
            int result1 = binarySearch(nums, l, pivot);
            
            if (result1 != -1) return result1;
            
            int result2 = binarySearch(nums, pivot+1, r);
            
            if (result2 != -1) return result2;
        }
        
        return -1;
    }
    
    public int findPeakElement(int[] nums) {
        
        return nums.length == 1? 0: binarySearch(nums, 0, nums.length-1);
    }
}