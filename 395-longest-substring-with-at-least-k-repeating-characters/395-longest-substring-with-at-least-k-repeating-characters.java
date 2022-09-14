class Solution {
    public int longestSubstring(String s, int k) {
        int uniqChars = findUniqueChars(s);
        int[] frq = new int[26];
        int maxLen = 0;
        for(int i=1;i<=uniqChars;i++)
        {
            int start = 0;
            Arrays.fill(frq,0);
            int curUniqueChars = 0;
            for(int end=0;end<s.length();end++)
            {
                char c = s.charAt(end);
                if(frq[c-'a']==0)
                    curUniqueChars++;
                frq[c-'a']++;
                
                while(curUniqueChars>i)
                {
                    char startC = s.charAt(start);
                    frq[startC-'a']--;
                    if(frq[startC-'a']==0)
                        curUniqueChars--;
                    start++;
                }
                // System.out.println("Start : "+start+ "End : "+end + "isValid :"+);
                if(isValid(frq, k))
                    maxLen = Math.max(maxLen, end-start+1);
            }
            
        }
        return maxLen;
    }
    public int findUniqueChars(String s)
    {
        Set<Character> hs = new HashSet<>();
        int count = 0;
        for(char c:s.toCharArray())
        {
            if(hs.contains(c))
                continue;
            hs.add(c);
            count++;
        }
        return count;
    }
    public boolean isValid(int[] frq, int k)
    {
        for(int i=0;i<26;i++)
        {
            if(frq[i]>0 && frq[i]<k)
                return false;
        }
        return true;
    }
}
