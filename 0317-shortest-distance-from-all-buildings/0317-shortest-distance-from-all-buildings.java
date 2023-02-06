class Solution {
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>();
        int b = 0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                    q.offer(new int[]{i, j, b++});
            }
        }
        int nB = q.size();
        // System.out.println("Num buidings : "+nB);
        int[][][] dist = new int[m][n][nB];
         for(int[][] tp1 : dist)
            for(int [] tp2: tp1)
                Arrays.fill(tp2, Integer.MAX_VALUE);
       
        int k = 1;
        while(!q.isEmpty())
        {
            int qSize = q.size();
            while(qSize-->0)
            {
                int[] coords = q.poll();
                int x = coords[0];
                int y = coords[1];
                int building = coords[2];
                
                for(int i=0;i<4;i++)
                {
                    int x1 = x+dx[i];
                    int y1 = y+dy[i];
                    
                    if(x1>=0 && x1<m && y1>=0 && y1<n && grid[x1][y1]==0 && dist[x1][y1][building]==Integer.MAX_VALUE)
                    {
                        dist[x1][y1][building] = k;
                        q.offer(new int[]{x1, y1, building});
                    }
                }
            }
            k++;
        }
        int minSum = Integer.MAX_VALUE;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]!=0)
                    continue;
                int sum = 0;
                for(b=0;b<nB;b++)
                {
                    // System.out.print(dist[i][j][b]+",");
                    if(dist[i][j][b]==Integer.MAX_VALUE)
                    {
                        sum = Integer.MAX_VALUE;
                        break;
                    }
                    sum += dist[i][j][b];
                        // break
                    
                    
                }
                // System.out.print("  ");
                if(sum==0)
                    sum = Integer.MAX_VALUE;
                minSum = Math.min(sum, minSum);
            }
            // System.out.println();
        }
        return minSum==Integer.MAX_VALUE?-1:minSum;
    }
}