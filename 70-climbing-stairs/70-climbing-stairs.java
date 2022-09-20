class Solution {
    int[] memo;
    public int climbStairs(int n) {
        memo = new int[n+1];
        return helper(n);
    }
    public int helper(int n)
    {
        if(n<2)
            return 1;
        if(memo[n]!=0)
            return memo[n];
        
        return memo[n] = helper(n-1) + helper(n-2);
    }
}