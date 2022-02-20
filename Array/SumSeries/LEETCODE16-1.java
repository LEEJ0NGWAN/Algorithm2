class Solution {
    
    private int dfs(int[] nums, int index, int count, int target, int sum, int ans) {
        
        if (count == 3) return Math.abs(target - sum) < Math.abs(target - ans)? sum: ans;
        
        for (int i = index; i < nums.length; i++)
        ans = dfs(nums, i+1, count+1, target, sum + nums[i], ans);
        
        return ans;
    }
    
    public int threeSumClosest(int[] nums, int target) {
        
        return dfs(nums, 0, 0, target, 0, 5000);
    }
}