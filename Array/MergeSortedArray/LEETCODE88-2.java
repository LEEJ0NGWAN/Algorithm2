class Solution {
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int index1 = m-1;
        int index2 = n-1;
        int index3 = m+n-1;
        
        while (0 <= index1 && 0 <= index2)
            nums1[index3--] = nums1[index1] > nums2[index2]? nums1[index1--]: nums2[index2--];
        
        while (0 <= index1) nums1[index3--] = nums1[index1--];
        while (0 <= index2) nums1[index3--] = nums2[index2--];
    }
}