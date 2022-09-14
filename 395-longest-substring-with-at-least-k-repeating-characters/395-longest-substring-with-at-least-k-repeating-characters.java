class Solution {
    
    public int longestSubstring(String s, int k) {
        int frq[] = new int[26];
        int n = s.length();
        int maxLen = 0;
        for(int i=0;i<n;i++)
        {
            Arrays.fill(frq,0);
            for(int j=i;j<n;j++)
            {
                frq[s.charAt(j)-'a']++;
                if(isValid(frq,k))
                    maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }
    public boolean isValid(int[] frq, int k)
    {
        for(int i=0;i<26;i++)
        {
            if(frq[i]<k && frq[i]>0)
                return false;
        }
        return true;
    }
}