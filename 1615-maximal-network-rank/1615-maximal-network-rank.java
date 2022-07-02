class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] rank = new int[n][2];
        boolean[][] adm = new boolean[n][n];
        
        for(int[] road : roads)
        {
            rank[road[0]][0]++;
            rank[road[1]][0]++;
            rank[road[0]][1] = road[0];
            rank[road[1]][1] = road[1];
            adm[road[0]][road[1]] = true;
            adm[road[1]][road[0]] = true;
        }
        
        Arrays.sort(rank,(a,b)->b[0]-a[0]);
        
        List<int[]> rank1Cities = new ArrayList<>();
        int maxNetworkRank = 0;
        int maxRank = rank[0][0];
        int t = 0;
        for(int[] city : rank)
        {
            if(maxRank==city[0])
                rank1Cities.add(city);
        }
        int size1 = rank1Cities.size();
        if(size1>1)
        {
            maxNetworkRank = 2*rank1Cities.get(0)[0]-1;
            
            for(int i=0;i<size1;i++)
            {
                for(int j=i+1;j<size1;j++)
                {
                    int c1 = rank1Cities.get(i)[1];
                    int c2 = rank1Cities.get(j)[1];
                    if(!adm[c1][c2])
                        return maxNetworkRank+1;
                }
            }
            return maxNetworkRank;
        }
        else{
            
            int maxRankCity = rank[0][1];
            int maxRank2 = rank[size1][0];
            List<int[]> rank2Cities = new ArrayList<>();
        
            for(int[] city : rank)
            {
                if(maxRank2==city[0])
                    if(!adm[city[1]][maxRankCity])
                        return maxRank2+maxRank;
            }
            return maxRank2+maxRank-1;
        }  
    }
}