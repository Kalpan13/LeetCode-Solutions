class Solution {
    public int maximumDetonation(int[][] bombs) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i=0;i<bombs.length;i++)
        {
            graph.add(new ArrayList<>());
            for(int j=0;j<bombs.length;j++)
            {
                if(i!=j && canDetonate(i,j,bombs))
                    graph.get(i).add(j);
            }
        }
        int maxCount = 0;
        for(int i=0;i<bombs.length;i++)
        {    
            maxCount = Math.max(maxCount,dfs(graph,i,new boolean[bombs.length]));   
        }
        return maxCount;
    }
    private boolean canDetonate(int i, int j, int[][] bombs)
    {
        long x = bombs[j][0] - bombs[i][0], y = bombs[j][1] - bombs[i][1];
        return x * x + y * y <= (long) bombs[i][2] * bombs[i][2];
    }
    public int dfs(List<List<Integer>> g, int node, boolean[] visited)
    {
        
        int count = 0;
        visited[node] = true;
        
        for(int i=0;i<g.get(node).size();i++)
        {
            if(!visited[g.get(node).get(i)])
            {
                count+= dfs(g,g.get(node).get(i), visited);
            }
        }
        return count+1;
    }
}