class Solution {
    Boolean memo[];
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()];
        
        return helper(s, wordDict, 0);
    }
    public boolean helper(String s, List<String> wordDict, int idx)
    {
        if(idx>=s.length())
            return true;
        
        if(memo[idx]!=null)
            return memo[idx];
        
        for(int i=idx+1;i<=s.length();i++)
        {
            String curWord = s.substring(idx,i);
            // System.out.println(curWord)
            if(wordDict.contains(curWord))
            {
                
                if(helper(s, wordDict, i))
                    return memo[idx]=true;
            }
        }
        return memo[idx]=false;
    }
}