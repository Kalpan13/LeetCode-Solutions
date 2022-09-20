class Solution {
    int memo[];
    public int fib(int n) {
        memo = new int[n+1];
        Arrays.fill(memo,-1);
        return helper(n);
    }
    public int helper(int n)
    {
        if(n<2)
            return n;
        if(memo[n]!=-1)
            return memo[n];
        return memo[n]=helper(n-1)+helper(n-2);
        
    }
}