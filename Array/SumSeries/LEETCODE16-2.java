import java.util.Arrays;

class Solution {
    
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        
        int sum = Integer.MAX_VALUE, sum_diff = Integer.MAX_VALUE;
        
        loop:
        for (int i = 0, len = nums.length-2; i < len; i++) {
            
            int l = i+1, r = nums.length-1;
            
            while (l < r) {
                
                final int tmp = nums[i] + nums[l] + nums[r];
                final int tmp_diff = Math.abs(target - tmp);
                
                if (tmp_diff < sum_diff) {
                    
                    sum = tmp; sum_diff = tmp_diff;
                }
                
                if (tmp == target) break loop;
                else if (tmp < target) l++;
                else /* tmp > target*/ r--;
            }
        }
        
        return sum;
    }
}