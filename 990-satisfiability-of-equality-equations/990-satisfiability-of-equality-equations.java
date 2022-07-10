class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        
        for(String e : equations)
        {
            if(e.charAt(1)=='=')
            {
                int c1 = e.charAt(0)-'a';
                int c2 = e.charAt(3)-'a';
                if(c1!=c2)
                    uf.union(c1,c2);
            }
        }
        for(String e : equations)
        {
            if(e.charAt(1)=='!')
            {
                int c1 = e.charAt(0)-'a';
                int c2 = e.charAt(3)-'a';
                if(uf.find(c1)==uf.find(c2))
                    return false;
            }
        }
        return true;
    }
    class UnionFind{
        int parent[];
        int rank[];
        
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
                return parent[x]=find(parent[x]);
            return x;
        }
        public void union(int a, int b)
        {
            int pA = find(a);
            int pB = find(b);
            if(pA!=pB)
            {
                if(rank[pA]>rank[pB])
                    parent[pB] = pA;
                else if(rank[pB]>rank[pA])
                    parent[pA] = pB;
                else
                {
                    parent[pB] = pA;
                    rank[pA] += rank[pB];
                }
            }
        }
    }
}