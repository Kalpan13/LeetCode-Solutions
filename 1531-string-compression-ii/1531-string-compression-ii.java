class Solution {
    int dp[][][][];
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        dp = new int[n][27][n+1][k+1];
        for(int[][][] a: dp)
        {
            for(int b[][]:a)
            {
                for(int c[]:b)
                    Arrays.fill(c,-1);
            }
        }
        int ans  = solve(0,0,0,k,s);
        return ans;
    }
    public int solve(int i, int count, int cInd, int k, String s)
    {
        
        if(i>=s.length())
            return 0;
        if(k>=(s.length()-i))
            return 0;
        if(dp[i][cInd][count][k]!=-1)
            return dp[i][cInd][count][k];
        char c = s.charAt(i);
        int newCInd = (int)(c-'a');
        int len1 = Integer.MAX_VALUE;
        int len2 = k>0?solve(i+1, count, cInd, k-1, s):Integer.MAX_VALUE;
        
        if(newCInd==cInd)
        {
            // Take it
            len1 = findNewLength(count);
            len1 += solve(i+1, count+1, cInd, k, s);
        }
        else
        {
            // Take it
            len1 = solve(i+1, 1, newCInd, k, s)+1; 
         }
    
        dp[i][cInd][count][k] = Math.min(len1, len2);
        
        return dp[i][cInd][count][k];
    }
    private int findNewLength(int count)
    {
        if(count<=1 || count==9 || count==99)
            return 1;
        return 0;
    }

}