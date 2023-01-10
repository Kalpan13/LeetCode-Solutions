class Solution {
    int[][] memo;
    
    public int minDifficulty(int[] jD, int d) {
        int n = jD.length;
        if(d>n)
            return -1;
        
        memo = new int[n][d];
        for(int []m : memo)
            Arrays.fill(m, -1);
        return helper(jD, d, 0, 0);
    }
    public int helper(int[] jD, int d, int cur, int curD)
    {
        
        if(cur==jD.length)
        {
            return 0;
        }
        if(curD==d-1)
        {
            int max = jD[cur];
            for(int i=cur+1;i<jD.length;i++)
            {
                max = Math.max(jD[i],max);
            }
            return max;
        }
        if(memo[cur][curD]!=-1)
        {
            return memo[cur][curD];
        }
        int pendingDays = d-curD-1;
        int maxSoFar = 0;
        int minSum = Integer.MAX_VALUE;
        for(int i=cur;i<jD.length-pendingDays;i++)
        {
            maxSoFar = Math.max(jD[i],maxSoFar);
            int sum = helper(jD, d, i+1, curD+1);
            minSum = Math.min(sum+maxSoFar, minSum);
        }
        return memo[cur][curD] = minSum;
        
    }
}