class Solution {
    int[] sum;
    int[] count;
    int[] sbtSum;
    List<Set<Integer>> graph;
    int N;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        sbtSum = new int[n];
        count = new int[n];
        Arrays.fill(count, 1);
        sum = new int[n];
        N = n;
        graph = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            graph.add(new HashSet<>());
        }
        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        populateSubTreeSum(0, -1);
        populateAnswer(0, -1);
        
        return sum;
        
    }
    public void populateSubTreeSum(int root, int parent)
    {
        for(int child: graph.get(root))
        {
            if(child==parent)
                continue;

            populateSubTreeSum(child, root);
            count[root]+= count[child];
            sbtSum[root] += count[child]+sbtSum[child];
        }
    }
    public void populateAnswer(int root, int parent)
    {
        if(parent==-1) // root
        {
            sum[root] = sbtSum[root];
        }
        else
            sum[root] = sum[parent] - count[root] + (N-count[root]);
        
        for(int child : graph.get(root))
        {
            if(child!=parent)
            populateAnswer(child, root);
        }
            
    }
}