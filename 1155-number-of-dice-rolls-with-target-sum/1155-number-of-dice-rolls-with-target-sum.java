class Solution {
    int memo[][];
    int MOD = 1_000_000_007;
    public int numRollsToTarget(int n, int k, int target) {
        memo = new int[n+1][target+1];
        for(int[] a : memo)
            Arrays.fill(a, -1);
        
        return helper(n, k, target, target);
        
    }
    public int helper(int n, int k, int target, int pendingSum)
    {
        if(n==0)
            return 0;
        if(n==1)
        {
            if(k>=pendingSum && pendingSum>0)
                return 1;
            return 0;
        }
        if(memo[n][pendingSum]!=-1)
            return memo[n][pendingSum];
        
        int count = 0;
        for(int face=1;face<=k;face++)
        {
            if(face>pendingSum)
                break;
            // System.out.println("Tar")
            count = (count + (helper(n-1, k, target, pendingSum-face)% MOD))%MOD;
        }
        return memo[n][pendingSum] = count;
    }
}