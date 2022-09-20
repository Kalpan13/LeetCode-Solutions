class Solution {
    int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        memo = new int[n+1];
        int minCost = Math.min(helper(n-1, cost), helper(n-2, cost));
        return minCost;
    }
    public int helper(int n, int[] cost)
    {
        if(n<0)
            return 0;
        if(n==0)
            return cost[0];
        if(n==1)
            return cost[1];
        if(n==cost.length)
            return 0;
        if(memo[n]!=0)
            return memo[n];
        
        return memo[n]=Math.min(helper(n-1, cost),helper(n-2, cost))+cost[n];
    }
}