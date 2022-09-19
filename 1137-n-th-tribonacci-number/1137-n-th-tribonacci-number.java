class Solution {
    int memo[];
    public int tribonacci(int n) {
        memo = new int[n+1];
        Arrays.fill(memo,-1);
        if(n<2)
            return n;
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;
        return helper(n);
    }
    
    public int helper(int n)
    {
    
        if(memo[n]!=-1)
            return memo[n];
        
        memo[n] = helper(n-1)+helper(n-2)+helper(n-3);
        return memo[n];
    }
}