class Solution {
    int[][] memo;
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        
        if(n<d)
            return -1;
        
        memo = new int[n][d+1];
        for(int[] a: memo)
            Arrays.fill(a,-1);
        
        int min = helper(0, jobDifficulty, d);  
        return min;
    }
    public int helper(int day, int[] jobDifficulty, int daysRemaining)
    {
        if(memo[day][daysRemaining]!=-1)
            return memo[day][daysRemaining];
        
        if(daysRemaining==1)
        {
            int res = 0;
            for(int i=day; i<jobDifficulty.length;i++)
                res = Math.max(res, jobDifficulty[i]);
            
            return res;
        }
        int res = Integer.MAX_VALUE;
        int runningMaxDifficulty = jobDifficulty[day];
        for(int i=day;i<jobDifficulty.length-daysRemaining+1;i++)
        {
            runningMaxDifficulty = Math.max(runningMaxDifficulty, jobDifficulty[i]);
            
            int resRemaining = helper(i+1, jobDifficulty, daysRemaining-1);
            res = Math.min(resRemaining+runningMaxDifficulty, res);
        }
        return memo[day][daysRemaining] = res;
    }   
}