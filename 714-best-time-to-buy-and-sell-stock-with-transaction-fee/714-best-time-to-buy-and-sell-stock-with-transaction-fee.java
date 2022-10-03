class Solution {
    int[][] memo;
    final int BOUGHT = 0;
    final int SOLD = 1;
    
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        memo = new int[n][2];
        for(int[] a: memo)
            Arrays.fill(a, -1);
        return helper(prices, fee, n, 0, SOLD);
    }
    public int helper(int[] prices, int fee, int n, int day, int state)
    {
        if(day==n)
            return 0;
        
        if(memo[day][state]!=-1)
            return memo[day][state];
        
        int c1 = 0;
        if(state==SOLD)
        {
            c1 = -prices[day] + helper(prices, fee, n, day+1, BOUGHT);
        }
        else
        {
            c1 = (prices[day]-fee) + helper(prices, fee, n, day+1, SOLD);
        }
        int c2 = helper(prices, fee, n, day+1, state);
        return memo[day][state] = Math.max(c1, c2);
    }
}