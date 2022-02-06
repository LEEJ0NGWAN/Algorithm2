class Solution {
    public int pivotIndex(int[] nums) {
        
        int sum = 0, sum2 = 0;
        
        for (int i = 0; i < nums.length; sum += nums[i++]);
        for (int i = 0; i < nums.length; i++) {
            
            if ((sum - nums[i]) == sum2) return i;
            else {
                sum -= nums[i];
                sum2 += nums[i];
            }
        }
        
        return -1;
    }
}