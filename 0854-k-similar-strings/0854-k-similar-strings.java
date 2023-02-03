class Solution {
    public int kSimilarity(String s1, String s2) {
     
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(s1);
        visited.add(s1);
        
        int k = 0;
        while(!q.isEmpty())
        {
            int qSize = q.size();
            while(qSize-->0)
            {
                String cur = q.poll();
                if(s2.equals(cur))
                    return k;
                List<String> neighbors = getNeighbors(cur, s2);
                for(String neighbor : neighbors)
                {
                    if(!visited.contains(neighbor))
                    {
                        visited.add(neighbor);
                        q.offer(neighbor);     
                    }    
                }
                
            }
            k++;
        }
        return -1;
    }
    public List<String> getNeighbors(String s1, String s2)
    {
        List<String> neighbors = new ArrayList<>();
        int i = 0;
        char[] s1Char = s1.toCharArray();
        
        for(;i<s1Char.length;i++)
        {
            if(s1Char[i]!=s2.charAt(i)) // find first mismatch
                break;
        }
        
        for(int j=i+1;j<s1Char.length;j++)
        {
            if(s1Char[j]==s2.charAt(i))
            {
                swap(s1Char, i, j);
                neighbors.add(new String(s1Char));
                swap(s1Char, i, j);
            }
        }
        return neighbors;
    }
    public void swap(char[] ch, int i, int j)
    {
        char tp = ch[i];
        ch[i] = ch[j];
        ch[j] = tp;
    }
}