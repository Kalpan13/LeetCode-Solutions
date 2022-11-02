class Solution {
    public int minMutation(String start, String end, String[] bank) {
        
        Queue<String> genes = new LinkedList<>();
        genes.add(start);
        Set<String> set = new HashSet<>();
        for(String gene : bank)
            set.add(gene);
        int count = 0;
        char[] mutations = {'A','C','G','T'};
        Set<String> visited = new HashSet<>();
        while(!genes.isEmpty())
        {
            int qSize = genes.size();
            while(qSize-->0)
            {
                String cur = genes.poll();
                visited.add(cur);
                if(cur.equals(end))
                    return count;    
                
                for(int i=0;i<cur.length();i++)
                {
                    char prevChar = cur.charAt(i);
                    for(char c: mutations)
                    {
                        if(prevChar==c)
                            continue;
                        String neigh = cur.substring(0, i)+ c + cur.substring(i+1);
                        
                        if(set.contains(neigh) && !visited.contains(neigh))
                        {
                            genes.offer(neigh);
                        }
                            
                    }
                }
            }
            count++;
        }
        return -1;
    }
}