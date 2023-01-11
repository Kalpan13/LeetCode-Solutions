class Solution {
    class Node
    {
        List<Node> neighbors;
        // int appleCount;
        boolean hasApple;
        int val;
        Node(int val, boolean hasApple)
        {
            this.val = val;
            this.neighbors = new ArrayList<>();
            this.hasApple = hasApple;
            // this.appleCount = hasApple?1:0;
        }
    }
    boolean[] visited;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        Map<Integer,Node> nodes = new HashMap<>();
        visited = new boolean[n];
        for(int[] edge: edges)
        {
            int u = edge[0];
            int v = edge[1];
            nodes.putIfAbsent(u, new Node(u, hasApple.get(u)));
            nodes.putIfAbsent(v, new Node(v, hasApple.get(v)));
            
            Node uNode = nodes.get(u);
            Node vNode = nodes.get(v);
            uNode.neighbors.add(vNode);
            vNode.neighbors.add(uNode);
        }
        int pathLength = traverse(nodes.get(0));
        return pathLength>0?pathLength-2:pathLength;
    }
    public int traverse(Node iNode)
    {
        if(iNode.neighbors.size()==0)
        {
            if(iNode.hasApple)
                return 2;
            else
                return -1;
        }
        visited[iNode.val] = true;
        int pathLength = 0;
        for(Node neighbor: iNode.neighbors)
        {
            if(visited[neighbor.val])
                continue;
            
            int neighborPathLength = traverse(neighbor);
            if(neighborPathLength!=-1)
            {
                pathLength += neighborPathLength;
            }
        }
        if(pathLength==0 && !iNode.hasApple)
            return 0;
        else
            return pathLength+2;
        // if(pathLength>0)
        //     return pathLength+2;
        // return 2;
        
    }
}