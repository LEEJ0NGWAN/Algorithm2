class Solution {
    
    public int findDuplicate(int[] nums) {
        
        int slow = nums[0], fast = nums[nums[0]];
        
        while (slow != fast) {
            
            slow = nums[slow];       // x1 speed
            fast = nums[nums[fast]]; // x2 speed
        }
        
        slow = 0;
        while (slow != fast) {
            
            slow = nums[slow]; // x1 speed
            fast = nums[fast]; // x1 speed
        }
        return slow;
    }
}
