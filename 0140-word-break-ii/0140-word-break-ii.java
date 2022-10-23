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
            //sentence = sentence
            
            ans.add(sentence.substring(0, sentence.length()-1));
        }
        return ans;
    }
    public List<String> traverse(int i, String s)
    {
        // System.out.println("i : "+i);
        //System.out.println("New i : "+i);
        if(i==s.length()) // End of String
        {
            
            List<String> temp = new ArrayList<>();
            temp.add("");
            // System.out.println("temp " +temp);
            return temp;
        }
            
        if(memo.containsKey(i)) // Index already visited
        {
            return memo.get(i);
        }
        for(int j=i;j<s.length();j++)
        {
            String curStr = s.substring(i, j+1);
            // System.out.println("curStr : "+curStr);
            if(wordDictSet.contains(curStr))
            {
                //System.out.println("curStr found in str : "+curStr);
                
                memo.putIfAbsent(i, new ArrayList<>());
                List<String> sentences = traverse(j+1, s);
                //System.out.println("Sentences :"+sentences);
                if(sentences==null)
                    continue;
                //String 
                for(String sentence: sentences)
                {
                    // if(sentence.length()==0)
                    // {
                    //     sentence+= curStr;
                    // }
                    // else
                    // {
                    //     sentence+=(" "+(curStr));
                    // }
                    memo.get(i).add(curStr+" "+sentence);
                }
            }
        }
        return memo.get(i);
        
    }
}