class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a,b)->(a[0]-a[1]-(b[0]-b[1])));
        
        int n = costs.length/2;
        
        int totalCost = 0;
        for(int i=0;i<n;i++)
            totalCost += (costs[i][0] + costs[2*n-i-1][1]);
        return totalCost;
    }
}