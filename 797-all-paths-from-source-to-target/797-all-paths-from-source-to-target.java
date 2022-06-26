class Solution {
    List<List<Integer>> paths;
    boolean[] visited;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph)      {
        int n = graph.length;
        visited = new boolean[n];
        paths = new ArrayList<>();
        
        List<Integer> curPath = new ArrayList<>();
        // curPath.add(0);
        
        findPaths(0, curPath, graph, n);
        return paths;
        
    }
    public void findPaths(int root, List<Integer> curPath, int[][] graph, int n)
    {
        
        // System.out.println("Current Node : "+root + " Curpath : "+curPath);
        
        if(visited[root])
            return;
        
        if(root == n-1)  // Desitnation Reached
        {
            // System.out.println("Target Reached. Adding Path to answer");
            curPath.add(root);
            paths.add(new ArrayList(curPath));
            curPath.remove(curPath.size()-1);
            
            return;
        }
        
        visited[root] = true;  // Visit the node
        curPath.add(root);    // Add to path
        for(int neigh : graph[root]) // Explore neighbors
        {
            // System.out.println("Exploring neighbor : "+neigh);
            findPaths(neigh, curPath, graph, n);
        }
        curPath.remove(curPath.size()-1);
        visited[root] = false;
        // System.out.println("Completed Visiting : "+root + " CurPath : "+curPath);
        return;
            
    }
}