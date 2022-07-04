class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind uf = new UnionFind(n);
        
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1])
                    uf.union(i,j);
            }
        }
        int island = 0;
        for(int i=0;i<n;i++)
        {
            if(uf.parent[i]==i)
                island++;
        }
        return stones.length-island;
    }
    class UnionFind{
        int parent[];
        int rank[];
        public UnionFind(int n)
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
            if(parent[x]!=x)
                return parent[x] = find(parent[x]);
            return parent[x];
        }
        public void union(int a, int b)
        {
            int parentA = find(a);
            int parentB = find(b);
            
            if(parentA==parentB)
                return;
            else
            {
                if(rank[parentA]==rank[parentB])
                {
                    rank[parentA]+= rank[parentB];
                    parent[parentB] = parentA;
                }
                else if(rank[parentA]>rank[parentB])
                {
                    parent[parentB] = parentA;
                }
                else
                    parent[parentA] = parentB;
            }
        }
    }
}