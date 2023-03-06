class Solution {
    public int numberOfSubstrings(String s) {
        return atMostKDistinct(s, 3)-atMostKDistinct(s,2);
    }
    public int atMostKDistinct(String s, int k)
    {
        int start = 0;
        int[] count = new int[]{0,0,0};
        int uniqChar = 0;
        int res = 0;
        for(int end=0;end<s.length();end++)
        {
            int ind = s.charAt(end)-'a';
            count[ind]++;
            if(count[ind]==1)
                uniqChar++;
            
            while(start<end && uniqChar>k)
            {
                int indS = s.charAt(start)-'a';
                count[indS]--;
                if(count[indS]==0)
                    uniqChar--;
                start++;
            }
            res+= (end-start+1);
        }
        
        return res;
    }
}