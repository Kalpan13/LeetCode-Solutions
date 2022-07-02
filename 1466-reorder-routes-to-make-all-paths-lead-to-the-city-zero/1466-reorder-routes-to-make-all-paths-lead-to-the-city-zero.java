class Solution {
    Map<Integer,List<Integer>> graph;
    Map<Integer,List<Integer>> revGraph;
    int citiesConnected = 1; 
    int edgeCount = 0;
    boolean[] visited;
    public int minReorder(int n, int[][] connections) {
        graph = new HashMap<>();
        revGraph = new HashMap<>();
        visited = new boolean[n];
        for(int connection[] : connections)
        {
            int from = connection[0];
            int to = connection[1];
            
            graph.putIfAbsent(from, new ArrayList<>());
            revGraph.putIfAbsent(to, new ArrayList<>());
            graph.get(from).add(to);
            revGraph.get(to).add(from);
        }
        reverseEdge(0,n);
        return edgeCount;
            
    }
    public void reverseEdge(int node, int n)
    {
        if(visited[node])
            return;
        
        visited[node] = true;
        List<Integer> next = new ArrayList<>();
        
        // Reverse edges from node to X
        for(int neigh: graph.getOrDefault(node, new ArrayList<>()))
        {
            if(visited[neigh])
                continue;
            next.add(neigh);
            edgeCount++;
        }
        
        // Directly add edges from all Xs to node
        for(int neigh: revGraph.getOrDefault(node, new ArrayList<>()))
        {
            if(visited[neigh])
                continue;
            next.add(neigh);
        }
        for(int next_neigh : next)
            reverseEdge(next_neigh, n);
    }
}