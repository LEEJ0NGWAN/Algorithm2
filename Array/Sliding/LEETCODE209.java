class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int l = 0, r = 0, sum = nums[0];
        
        int minLength = 100001;
        
        while (r < nums.length) {
            
            if (target <= sum) {
                
                int length = r - l + 1;
                
                if (minLength > length)
                    minLength = length;
                
                if (minLength == 1) break;
                
                if (l < r)
                sum -= nums[l++];
                
                continue;
            }

            r++;
            if (r < nums.length) sum += nums[r];
        }
        
        return minLength == 100001? 0: minLength;
    }
}