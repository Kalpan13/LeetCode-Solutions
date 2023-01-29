class Solution {
    int[][] memo;
    static int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        memo = new int[m][n];
        int ans = 0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                ans = Math.max(ans, findMaxPath(matrix, i, j, m, n));
            }
        }
        return ans;
    }
    public int findMaxPath(int[][] matrix, int i, int j, int m, int n)
    {
        
        if(memo[i][j]!=0)
            return memo[i][j];
        
        for(int d[]: dirs)
        {
            int i1 = i+d[0];
            int j1 = j+d[1];
            if(i1>=0 && j1>=0 && i1<m && j1<n && matrix[i1][j1]>matrix[i][j])
            {
                int ans = findMaxPath(matrix, i+d[0], j+d[1], m, n);
                memo[i][j] = Math.max(ans, memo[i][j]);      
            } 
        }
        return ++memo[i][j];
        
    }
}