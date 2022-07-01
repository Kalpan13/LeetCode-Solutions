class Solution {
    public int countComponents(int n, int[][] edges) {
        
        UnionFind uf = new UnionFind(n);
        for(int edge[] : edges)
        {
            int u = edge[0];
            int v = edge[1];
            uf.union(u,v);
        }
        int connectedComponents = 0;
        for(int i=0;i<n;i++)
        {
            if(uf.find(i)==i)
                connectedComponents++;
        }
        return connectedComponents;
        
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
        public void union(int a, int b)
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
            }
        }
    }
}