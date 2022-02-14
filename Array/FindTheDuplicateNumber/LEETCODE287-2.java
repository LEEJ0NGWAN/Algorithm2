class Solution {
    
    public int findDuplicate(int[] nums) {
        
        for (int num: nums)
            if (nums[(num = Math.abs(num))] < 0) return num;
            else nums[num] *= -1;
        
        return 0;
    }
}
