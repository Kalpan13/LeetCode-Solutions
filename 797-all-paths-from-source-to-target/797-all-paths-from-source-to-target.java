class Solution {
    List<List<Integer>> paths;
    boolean[] visited;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph){
        
        int n = graph.length;
        visited = new boolean[n];
        paths = new ArrayList<>();
        List<Integer> curPath = new ArrayList<>();
        
        findPaths(0, curPath, graph, n);
        return paths;
        
    }
    public void findPaths(int root, List<Integer> curPath, int[][] graph, int n)
    {
        
        if(visited[root])
            return;
        
        if(root == n-1)  // Desitnation Reached
        {
            curPath.add(root);
            paths.add(new ArrayList(curPath));
            curPath.remove(curPath.size()-1);
            
            return;
        }
        
        visited[root] = true;  // Visit the node
        curPath.add(root);    // Add to path
        for(int neigh : graph[root]) // Explore neighbors
        {
            findPaths(neigh, curPath, graph, n);
        }
        curPath.remove(curPath.size()-1);  // Remove Current Node from path
        visited[root] = false; // Mark as unvisited
        return;
            
    }
}