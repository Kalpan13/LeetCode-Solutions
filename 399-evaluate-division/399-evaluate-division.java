class Solution {
    Set<String> visited;
    Map<String,Map<String,Double>> graph;
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        graph = new HashMap<>();
        int n = values.length;
        for(int i=0;i<n;i++)
        {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double quotient = values[i];
            
            graph.putIfAbsent(dividend, new HashMap<>());
            graph.putIfAbsent(divisor, new HashMap<>());
            
            graph.get(dividend).put(divisor, quotient);
            graph.get(divisor).put(dividend, 1 / quotient);
        }
        int numQueries = queries.size();
        double ans[] = new double[numQueries];
        int i = 0;
        visited = new HashSet<>();
        for(List<String> query: queries)
        {
            String dividend = query.get(0);
            String divisor = query.get(1);
            if(!graph.containsKey(dividend) || !graph.containsKey(divisor))
                ans[i++] = -1;
            else if(dividend==divisor)
                ans[i++] = 1;
            else
            {
                ans[i++] = evaluateDivision(dividend,divisor,1); 
                visited.clear();    
            }
            
        }
        return ans;
    }
    public double evaluateDivision(String dividend, String divisor, double currProduct)
    {
        visited.add(dividend);
        double ans = -1;
        
        Map<String,Double> neighbors = graph.get(dividend);
        if(neighbors.containsKey(divisor))
            ans = currProduct * neighbors.get(divisor);
        else
        {
            for(Map.Entry<String,Double> neighbor : neighbors.entrySet())
            {
                if(!visited.contains(neighbor.getKey()))
                {
                    ans = evaluateDivision(neighbor.getKey(), divisor, neighbor.getValue()*currProduct);
                    if(ans!=-1)
                        return ans;
                }
                
            }
        }
        return ans;
        
    }
}