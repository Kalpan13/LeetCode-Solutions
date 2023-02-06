class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> hm = new HashMap<>();
        String ans = null;
        if(s.length()<t.length())
            return "";
        for(char c: t.toCharArray())
        {
            hm.put(c, hm.getOrDefault(c, 0)+1);
        }
        int remaining = t.length();
        int start = 0;
        for(int end=0;end<s.length();end++)
        {
            char c = s.charAt(end);
            if(hm.containsKey(c))
            {
                hm.put(c, hm.get(c)-1);
                if(hm.get(c)>=0)
                    remaining--;
            }
            while(remaining==0)
            {
                
                if(ans == null || ans.length()>(end-start+1))
                {
                    ans = s.substring(start,end+1);
                }
                char stC = s.charAt(start);
                if(hm.containsKey(stC))
                {
                    hm.put(stC, hm.get(stC)+1);
                    if(hm.get(stC)>0)
                        remaining++;
                }
                start++;
            }
        }
        return ans==null?"":ans;
    }
}