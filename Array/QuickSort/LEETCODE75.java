class Solution {
    
    private static void swap(int[] arr, int i, int j) {
        
        if (i != j) {
            
            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];
        }
    }
    
    private static int partition(int[] arr, int l, int r) {
        
        int pivot = arr[(l + r) / 2];
        
        while (l <= r) {
            
            while (arr[l] < pivot) l++;
            while (pivot < arr[r]) r--;
            
            if (l <= r) swap(arr, l++, r--);
        }
        
        return l;
    }
    
    public static void qSort(int[] arr, int l, int r) {
        
        if (l >= r) return;
        
        int pivot = partition(arr, l, r);
        
        qSort(arr, l, pivot-1);
        qSort(arr, pivot, r);
    }
    
    public void sortColors(int[] nums) {
        
        qSort(nums, 0, nums.length-1);
    }
}