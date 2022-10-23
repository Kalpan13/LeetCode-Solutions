class Solution {
    Map<Integer,List<String>> memo;
    Set<String> wordDictSet;
    List<String> ans;
    public List<String> wordBreak(String s, List<String> wordDict) {
        memo = new HashMap<>();
        ans = new ArrayList<>();
        wordDictSet = new HashSet<>(wordDict);
        
        List<String> sentences = traverse(0, s);   
        if(sentences==null)
            return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        for(String sentence : sentences)
        {
            ans.add(sentence.substring(0, sentence.length()-1));
        }
        return ans;
    }
    public List<String> traverse(int i, String s)
    {
        if(i==s.length()) // End of String
        {
            
            List<String> temp = new ArrayList<>();
            temp.add("");
            return temp;
        }
            
        if(memo.containsKey(i)) // Index already visited
        {
            return memo.get(i);
        }
        for(int j=i;j<s.length();j++)
        {
            String curStr = s.substring(i, j+1);
            if(wordDictSet.contains(curStr))
            {
                // if current substring exist in words set check for the remaining substring
                memo.putIfAbsent(i, new ArrayList<>());
                List<String> sentences = traverse(j+1, s);
                if(sentences==null)
                    continue;
                for(String sentence: sentences)
                {
                    memo.get(i).add(curStr+" "+sentence);
                }
            }
        }
        return memo.get(i);
    }
}