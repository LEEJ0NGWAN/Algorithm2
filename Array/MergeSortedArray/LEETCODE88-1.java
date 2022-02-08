class Solution {
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if (n == 0) return;
        
        int length = m + n;
        int[] tmp = new int[length];
        
        int tmpIndex = 0, nums1Index = 0, nums2Index = 0;
        
        while (nums1Index < length) {
            
            tmp[nums1Index] = nums1Index < m? nums1[nums1Index]: Integer.MAX_VALUE;
            
            if (tmpIndex < m && nums2Index < n)
                nums1[nums1Index++] = tmp[tmpIndex] < nums2[nums2Index]?
                tmp[tmpIndex++]: nums2[nums2Index++];
                
            else if (tmpIndex < m)
                nums1[nums1Index++] = tmp[tmpIndex++];
            else // nums2Index < n
                nums1[nums1Index++] = nums2[nums2Index++];
        }
    }
}