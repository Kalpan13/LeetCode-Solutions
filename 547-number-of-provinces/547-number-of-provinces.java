class Solution {
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isConnected[i][j]==1 && i!=j)
                {
                    uf.union(i,j);
                }              
            }
        }
        int provinces = 0;
    
        for(int i=0;i<n;i++)
        {
            if(uf.find(i)==i)
                provinces++;
        }
        return provinces;
    }
    class UnionFind{
        int rank[];
        int parent[];
        
        UnionFind(int n)
        {
            rank = new int[n];
            Arrays.fill(rank,1);
            parent = new int[n];
            for(int i=0;i<n;i++)
                parent[i] = i;
        }
        public int find(int x)
        {
            if(parent[x]==x)
                return x;
            else return parent[x] = find(parent[x]);
        }
        public void union(int a, int b)
        {
            int parentA = find(a);
            int parentB = find(b);
            
            if(parentA==parentB)
                return;
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
                rank[parentA]+= rank[parentB];
                parent[parentB] = parentA;
            }
        }
    }
}