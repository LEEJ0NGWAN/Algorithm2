import java.util.*;

class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        
        final Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; map.put(nums[i], i++)) {
            
            final int expect = target - nums[i];
            
            if (map.containsKey(expect)) {
                
                expect = map.get(expect);
                
                return expect < i? new int[]{expect, i}: new int[]{i, expect};
            }
        }
        
        return null;
    }
}