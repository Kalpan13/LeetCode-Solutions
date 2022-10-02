class Solution {
    int memo[];
    public int numDecodings(String s) {
        int n = s.length();
        memo = new int[n];
        Arrays.fill(memo, -1);
        int ways = countWays(s, 0, new StringBuffer());
        return memo[0]==-1?0:memo[0];
    
    }
    public int countWays(String s, int ind, StringBuffer cur)
    {
        if(ind>=s.length())
        {
            return 1;
        }
        if(memo[ind]!=-1)
            return memo[ind];
        if(s.charAt(ind)>='1' && s.charAt(ind)<='9')
        {
            if(ind<s.length()-1 && ((s.charAt(ind)=='2' && s.charAt(ind+1)>='0' && s.charAt(ind+1)<='6') || s.charAt(ind)=='1'))
            {
                
                int c1 = countWays(s, ind+1, cur);
                int c2 = countWays(s, ind+2, cur);
                
                return memo[ind] = (c1+c2);    
            }
            else
            {
                int c1 = countWays(s, ind+1, cur);
                return memo[ind] = (c1);
            }  
        }   
        return 0;
    }
}