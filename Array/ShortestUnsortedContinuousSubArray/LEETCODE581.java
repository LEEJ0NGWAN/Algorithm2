import java.util.*;

class Solution {
    
    public int findUnsortedSubarray(int[] nums) {
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int left = 0, right = 0;
        
        for (int i = 0, pre = nums[0]; i < nums.length; pre = nums[i++]) {
            
            int num = nums[i];
            
            if (pre > nums[i]) {
                
                if (max <= pre) {
                    
                    max = pre;
                    right = i+1;
                }
                if (min > num)
                    min = num;
            }
        }
        
        while (left < right && nums[left] <= min) left++;
        while (right < nums.length && nums[right] < max) right++;
        
        return right-left;
    }
}