class Solution {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int left = 0;
        int up = 0;
        int right = matrix[0].length - 1;
        int down = matrix.length - 1;
        
        while (left < right && up < down) {
            
            if (matrix[down][left] == target || matrix[up][right] == target) return true;
            
            // left
            if (matrix[down][left] < target) left++;
            
            else
            // up
            if (matrix[up][right] < target) up++;
            
            else
            // right
            if (target < matrix[up][right]) right--;
            
            else
            // down
            if (target < matrix[down][left]) down--;
        }
        
        if (left == right) {
            
            for (int i = up; i <= down; i++) if (matrix[i][left] == target) return true;
        }
            
        else {
            
            for (int i = left; i <= right; i++) if (matrix[up][i] == target) return true;
        }
        
        return false;
    }
}