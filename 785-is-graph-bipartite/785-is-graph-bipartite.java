class Solution {
    private final int[] possibleColors = {0,1};
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        
        int[] colors = new int[n];
        Arrays.fill(colors,-1);
        for(int i=0;i<n;i++)
        {
            if(colors[i]==-1 && !canColor(graph, colors, i, 0))
                return false;
        }
        return true;
    }
    public boolean canColor(int[][] graph,int[]colors,int node, int color)
    {
        if(colors[node]!=-1)
        {
            return colors[node]==color;
        }
        colors[node] = color;
        for(int neighbor : graph[node])
        {
            if(!canColor(graph,colors,neighbor,1-color))
                return false;
        }
        return true;
    }
}