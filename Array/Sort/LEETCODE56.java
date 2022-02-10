import java.util.*;

class Solution {
    
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (arr1, arr2) -> {
            
            if (arr1[0] < arr2[0]) return -1;
            if (arr1[0] > arr2[0]) return 1;
            
            if (arr1[1] < arr2[1]) return -1;
            if (arr1[1] > arr2[1]) return 1;
            
            return 0;
        });
        
        List<int[]> list = new LinkedList<int[]>();
        
        int left = intervals[0][0], right = intervals[0][1];
        for (int[] interval: intervals) {
            
            if (right < interval[0]) {
                
                list.add(new int[] {left, right});
                
                left = interval[0];
                right = interval[1];
            }
            else right = Math.max(right, interval[1]);
        }
        list.add(new int[] {left, right});
        
        return list.toArray(new int[0][]);
    }
}