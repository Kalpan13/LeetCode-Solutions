class Solution {
    Integer[][][] dp;
    int m;
    int n;
    int k;
    int MOD = (int) 1e9+7;
    public int ways(String[] pizza, int k) {
        this.m = pizza.length;
        this.n = pizza[0].length();
        this.k = k;
        int[][] sums = new int[m+1][n+1];
        
        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                sums[i][j] = sums[i+1][j] + sums[i][j+1] + (pizza[i].charAt(j)=='A'?1:0) - sums[i+1][j+1]; 
            }
        }
        dp = new Integer[m][n][k+1];
        return countWays(sums, 0, 0, 1);
    }
    public int countWays(int[][] sums, int i, int j, int cut)
    {
        if(dp[i][j][cut]!=null)
            return dp[i][j][cut];
        if(cut==k)
            return dp[i][j][cut]=(sums[i][j]>0)?1:0;
        int count = 0;
        for(int r=i;r<m-1;r++)
        {
            if(sums[i][j]-sums[r+1][j]>0)
                count = (count + countWays(sums, r+1, j, cut+1)) % MOD;
        }
        for(int c=j;c<n-1;c++)
        {
            if(sums[i][j]-sums[i][c+1]>0)
                count = (count + countWays(sums, i, c+1, cut+1)) % MOD;
        }
        return dp[i][j][cut] = count;
    }
}