class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character,Integer> hm = new HashMap<>();
        
        int start = 0;
        int maxLen = 0;
        for(int end=0;end<s.length();end++)
        {
            char c = s.charAt(end);
            if(!hm.containsKey(c))
            {
                while(hm.size()>1)
                {
                    char st_char = s.charAt(start++);
                    hm.put(st_char, hm.get(st_char)-1);
                    if(hm.get(st_char)==0)
                    {
                        hm.remove(st_char);
                    }
                }
                hm.put(c,1);
                maxLen = Math.max(maxLen,end-start+1);
            }
            else
            {
                
                maxLen = Math.max(maxLen,end-start+1);
                hm.put(c, hm.get(c)+1);
            }
                
        }
        return maxLen;
    }
}