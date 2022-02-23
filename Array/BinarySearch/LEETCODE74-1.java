class Solution {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        final int r = matrix.length;
        final int c = matrix[0].length;
        
        int top = 0, bottom = r-1, pivot = (top+bottom)/2;
        
        while (top < bottom) {
            
            if (matrix[pivot][0] <= target && target <= matrix[pivot][c-1]) break;
            
            else if (matrix[pivot][c-1] < target) top = pivot+1;
            else /* matrix[pivot][0] > target */ bottom = pivot-1;
            
            pivot = (top+bottom)/2;
        }
        
        int left = 0, right = c-1, center = (left + right)/2;
        
        while (left < right) {
            
            if (matrix[pivot][center] == target) return true;
            
            else if (target < matrix[pivot][center]) right = center-1;
            else /* matrix[pivot][center] < target*/ left = center+1;
            
            center = (left+right)/2;
        }
        
        return matrix[pivot][center] == target;
    }
}