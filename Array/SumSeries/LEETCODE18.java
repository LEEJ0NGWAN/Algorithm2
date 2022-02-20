import java.util.*;

class Solution {
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        
        final Set<List<Integer>> answer = new HashSet<>();
        
        for (int i=0; i < nums.length-3; i++)
        for (int j=i+1; j < nums.length-2; j++) {
            
            int k = j+1, l = nums.length-1;
            
            while (k < l) {
                
                int sum = nums[i] + nums[j] + nums[k] + nums[l];
                
                if (sum == target) {
                    
                    final List<Integer> list = new ArrayList<>();
                    
                    list.add(nums[i]); list.add(nums[j]); list.add(nums[k]); list.add(nums[l]);
                    
                    answer.add(list);
                    k++; l--;
                }
                else if (sum < target) k++;
                else /* sum > target*/ l--;
            }
        }
        
        return new ArrayList<>(answer);
    }
}