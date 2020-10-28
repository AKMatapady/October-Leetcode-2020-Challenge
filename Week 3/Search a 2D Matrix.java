class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return false;
        int r = matrix.length;
        int c = matrix[0].length;
        
        System.out.println(r + " " + c);
        
        if(target > matrix[r-1][c-1] || target < matrix[0][0])
            return false;
        
        int i = r-1, j = 0;
        
        while(i >=0 && j < c)
        {
            if(matrix[i][j] == target)
                return true;
            if(matrix[i][j] > target)
                i--;
            else if(matrix[i][j] < target)
                j++;            
        }
        return false;
    }
}