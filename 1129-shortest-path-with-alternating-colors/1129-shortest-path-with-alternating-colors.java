class Solution {
    final int RED = 1;
    final int BLUE = -1;
    final int BOTH = 0;
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer,List<Integer>> rG = new HashMap<>();
        Map<Integer,List<Integer>> bG = new HashMap<>();
        for(int edge[] : redEdges)
        {
            int u = edge[0];
            int v = edge[1];
            rG.putIfAbsent(u,new ArrayList<>());
            rG.putIfAbsent(v,new ArrayList<>());
            rG.get(u).add(v);
        }
        for(int edge[] : blueEdges)
        {
            int u = edge[0];
            int v = edge[1];
            bG.putIfAbsent(u,new ArrayList<>());
            bG.putIfAbsent(v,new ArrayList<>());
            bG.get(u).add(v);
        }
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{0,0});
        int distance = 0;
        int[] distances = new int[n];
        Arrays.fill(distances, -1);
        Set<String> visited = new HashSet<>();
        while(!q.isEmpty())
        {
            int qSize = q.size();
            for(int i=0;i<qSize;i++)
            {
                int[] cur = q.poll();
                int node = cur[0];
                int color = cur[1];
                if(distances[node]==-1)
                    distances[node] = distance;
                String key = node + "," + color;
                
                if(visited.contains(key))
                    continue;
                
                visited.add(key);
                
                if(color==RED || color==BOTH)
                {
                    for(int neigh: bG.getOrDefault(node,new ArrayList<>()))
                    {
                        q.offer(new int[]{neigh,BLUE});
                    }
                }
                if(color==BLUE || color==BOTH)
                {
                    for(int neigh: rG.getOrDefault(node,new ArrayList<>()))
                    {
                        q.offer(new int[]{neigh,RED});
                    }
                }
            }
            distance++;
        }
        return distances;
    }
}