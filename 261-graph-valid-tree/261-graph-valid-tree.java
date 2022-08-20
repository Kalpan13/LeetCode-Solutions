class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        DisjointSet ds = new DisjointSet(n);
        for(int[] edge: edges)
        {
            int u = edge[0];
            int v = edge[1];
            if(!ds.union(u,v))
                return false;
        }
        int parent = ds.find(0);
        for(int i=1;i<n;i++)
        {
            if(parent!=ds.find(i))
                return false;
        }
        return true;
    }
    class DisjointSet{
        int[] parent;
        int[] rank;
        
        DisjointSet(int n)
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
            if(parent[x]==x)
                return x;
            return parent[x] = find(parent[x]);
        }
        public boolean union(int a, int b)
        {
            int parentA = find(a);
            int parentB = find(b);
            
            if(parentA==parentB)
                return false;
            if(rank[parentA]>=rank[parentB])
            {
                rank[parentA]+= rank[parentB];
                parent[parentB] = parentA;
            }
            else{
                rank[parentB] += rank[parentA];
                parent[parentA] = parentB;
            }
            return true;
        }
    }
}