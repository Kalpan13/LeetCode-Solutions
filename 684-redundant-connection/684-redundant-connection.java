class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length+1;
        UnionFind uf = new UnionFind(n);
        for(int edge[] : edges)
        {
            int u = edge[0];
            int v = edge[1];
            if(!uf.union(u,v))
                return edge;
        }
        return new int[]{-1,-1};
    }
    
    class UnionFind{
        int[] parent;
        int[] rank;
        
        UnionFind(int n)
        {
            parent = new int[n];
            rank = new int[n];
            Arrays.fill(rank,1);
            for(int i=0;i<n;i++)
                parent[i] = i;
        }
        public int find(int x)
        {
            if(parent[x]!=x)
                return parent[x] = find(parent[x]);
            return parent[x];
        }
        public boolean union(int a, int b)
        {
            int parentA = find(a);
            int parentB = find(b);
            
            if(parentA!=parentB)
            {
                if(rank[parentA]>rank[parentB])
                {
                    parent[parentB] = parentA;
                }
                else if(rank[parentA]<rank[parentB])
                {
                    parent[parentA] = parentB;
                }
                else
                {
                    rank[parentA] += rank[parentB];
                    parent[parentB] = parentA;
                }
                return true;
            }
            else
                return false;
        }
    }
}