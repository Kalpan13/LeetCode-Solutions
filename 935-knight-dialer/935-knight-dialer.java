class Solution {
    int MOD = 1000000007;
    Integer[][][] memo;
    public int knightDialer(int n) {
        memo = new Integer[4][3][n];
        int ans = 0;
        
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<3;j++)
                ans = (ans + hop(n-1,i,j))%MOD;
        }
        return ans;
    }
    public int hop(int n, int i, int j)
    {
        if(i<0 || j<0 || i>3 || j>2)
            return 0 ;
        if(i==3 && j!=1)
            return 0;
        if(n==0)
            return 1;
        
        if(memo[i][j][n]!=null)
            return memo[i][j][n];
        
        int ans = (hop(n-1, i-1,j+2))%MOD;
        ans = (ans+hop(n-1, i-1,j-2))%MOD;
        ans = (ans+hop(n-1, i+1,j+2))%MOD;
        ans = (ans+hop(n-1, i+1,j-2))%MOD;
        ans = (ans+hop(n-1, i-2,j+1))%MOD;
        ans = (ans+hop(n-1, i-2,j-1))%MOD;
        ans = (ans+hop(n-1, i+2,j+1))%MOD;
        ans = (ans+hop(n-1, i+2,j-1))%MOD;
        memo[i][j][n] = ans;
        return memo[i][j][n]; 
    }
}