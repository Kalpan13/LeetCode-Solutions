class Solution {
    int[][] memo;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        memo = new int[n][2];
        for(int[] a: memo)
            Arrays.fill(a,-1);
        return helper(prices, 0, 0);
    }
    public int helper(int[] prices, int day, int cond)
    {
        if(day>=prices.length)
            return 0;
        
        if(memo[day][cond]!=-1)
            return memo[day][cond];
        
        int val1 = 0;
        int val2 = 0;
        if(cond==0)
        {
            val1 = helper(prices, day+1, 1) - prices[day];
            val2 = helper(prices, day+1, 0);
        }
        else if(cond==1)
        {
            val1 = helper(prices, day+1, 1);
            val2 = helper(prices, day+2, 0) + prices[day];
        }
        memo[day][cond] = Math.max(val1, val2);
        return memo[day][cond];
        
    }
}