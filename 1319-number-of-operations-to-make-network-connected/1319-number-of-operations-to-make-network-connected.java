class Solution {
    public int makeConnected(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n);
        int additionalEdges = 0;
        for(int[] connection : connections)
        {
            int u = connection[0];
            int v = connection[1];
            if(!uf.union(u,v))
                additionalEdges++;
        }
        int islands = 0;
        for(int i=0;i<n;i++)
        {
            // System.out.println("i : "+i + " parent :"+uf.parent[i]);
            if(uf.rank[i]==n)
                return 0;
            if(uf.parent[i]==i)
                islands++;
        }
        // System.out.println("Islands : "+islands+ " additionalEdges : "+ additionalEdges);
        return additionalEdges>=(islands-1)?(islands-1):-1;
        
    }
    class UnionFind{
        int[] parent;
        int[] rank;
        
        UnionFind(int n)
        {
            parent = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++)
            {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        public int find(int x)
        {
            if(x==parent[x])
                return x;
            return parent[x]=find(parent[x]);
        }
        public boolean union(int a, int b)
        {
            int parentA = find(a);
            int parentB = find(b);
            if(parentA==parentB)
                return false;
            if(rank[parentA]>=rank[parentB])
            {
                rank[parentA] += rank[parentB];
                parent[parentB] = parentA;
            }
            else
            {
                rank[parentB] += rank[parentA];
                parent[parentA] = parentB;
            }
            return true;
        }
    }
}