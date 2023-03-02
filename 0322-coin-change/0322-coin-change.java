class Solution {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length;
        if(amount==0)
            return 0;
        dp = new int[amount+1];
        Arrays.fill(dp, -1);
        helper(coins, 0, amount, 0);
        return dp[0]==Integer.MAX_VALUE?-1:dp[0];
    }
    public int helper(int[] coins, int ind, int amount, int curAmount)
    {
        if(curAmount==amount)
        { 
            return 0;
        }
        if(dp[curAmount]!=-1)
            return dp[curAmount];
        
        int reqCoins = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++)
        {
            if(coins[i]>amount)
                break;
            if(curAmount+coins[i]<=amount)
            {
                int count = helper(coins, ind, amount, curAmount+coins[i]);
                if(count!=Integer.MAX_VALUE)
                    reqCoins = Math.min(count+1, reqCoins);
            }
            else
                break;
        }
        return dp[curAmount] = reqCoins;
    }
}