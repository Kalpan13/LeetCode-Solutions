class NumMatrix {

    int[][] dp;
    int m;
    int n;
    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n+1];
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j+1] = dp[i][j] + matrix[i][j]; 
            }
        }
    }
    
    public void update(int row, int col, int val) {
        
        int prev = dp[row][col+1] - dp[row][col];
        
        for(int j=col;j<n;j++)
        {
            dp[row][j+1] += (val - prev);
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        int sum = 0;
        for(int i=row1;i<=row2;i++)
        {
            sum+= (dp[i][col2+1]-dp[i][col1]);
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */