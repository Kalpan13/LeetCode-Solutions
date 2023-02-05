class Solution {
    public List<Integer> findAnagrams(String s, String s2) {
        
        Map<Character,Integer> p = new HashMap<>();
        for(char c: s2.toCharArray())
        {
            p.put(c, p.getOrDefault(c,0)+1);
        }
        int resolved = s2.length();
        
        List<Integer> result = new ArrayList<>();
        int start = 0;
        for(int end=0;end<s.length();end++)
        {
            char endC = s.charAt(end);
            if(p.containsKey(endC))
            {
                p.put(endC, p.get(endC)-1);
                if(p.get(endC)>=0)
                    resolved--;
            }
            while(resolved==0)
            {
                if(end-start+1==s2.length())
                {
                    result.add(start);
                }
                char startC = s.charAt(start);
                if(p.containsKey(startC))
                {
                    p.put(startC, p.get(startC)+1);
                    if(p.get(startC)>0)
                        resolved++;
                }
                start++;
            }
        }
        return result;
    }
        
    }