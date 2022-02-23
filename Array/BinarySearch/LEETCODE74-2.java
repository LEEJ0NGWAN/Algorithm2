class Solution {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        final int col = matrix[0].length;
        
        int left = 0;
        int right = matrix.length * col - 1;
        int pivot = (left + right) / 2;
        
        while (left < right) {
            
            final int y = pivot / col;
            final int x = pivot % col;
            
            if (matrix[y][x] == target) return true;
            
            else if (target < matrix[y][x]) right = pivot - 1;
            else /* matrix[y][x] < target*/ left = pivot + 1;
            
            pivot = (left + right) / 2;
        }
        
        return matrix[pivot / col][pivot % col] == target;
    }
}