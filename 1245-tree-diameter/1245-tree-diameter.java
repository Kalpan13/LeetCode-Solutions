class Solution {
    List<List<Integer>> graph;
    int farthestFromStart = -1;
    int maxDistanceFromStart = 0;
    boolean[] visited;
    int n;
    public int treeDiameter(int[][] edges) {
        // Start from random point. Find the farthest node (f1)
        // Start from f1. Find the farthest node (f2)
        
        // Answer = distance(f1,f2)
        if(edges.length==0)
            return 0;
        if(edges.length==1)
            return 1;
        n = edges.length+1;
        graph = new ArrayList<>();
        visited = new boolean[n];
        
        buildGraph(edges);
        findFarthest(0, 0);  // Farthest from any node
        Arrays.fill(visited,false);
        findFarthest(farthestFromStart,0); // Farthest from farthest node
        return maxDistanceFromStart;
    }
    public void buildGraph(int[][] edges)
    {
        for(int edge[] : edges)
        {
            int u = edge[0];
            int v = edge[1];
            while(graph.size()<=Math.max(u,v))
                graph.add(new ArrayList<>());
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
    }
    public void findFarthest(int startNode, int distance)
    {
        visited[startNode] = true;
        if(distance>maxDistanceFromStart)
        {
            farthestFromStart = startNode;
            maxDistanceFromStart = distance;
        }
            
        
        for(int neighbor:graph.get(startNode))
        {
            if(!visited[neighbor])
            {
                findFarthest(neighbor, distance+1);
            }
        }
        
    }
}