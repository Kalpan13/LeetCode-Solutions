class Solution {
    public void wallsAndGates(int[][] rooms) {
        
        Queue<int[]> q = new LinkedList<>();
        
        int m = rooms.length;
        int n = rooms[0].length;
        boolean visited[][] = new boolean[m][n];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(rooms[i][j]==0)
                q.offer(new int[]{i, j});
                //visited[i][j] = true;
            }
        }
        int k = 1;
        while(!q.isEmpty())
        {
            int qSize = q.size();
            while(qSize-->0)
            {
                int[] coords = q.poll();
                int x = coords[0];
                int y = coords[1];
                // System.out.println("Coords : "+x + " , "+ y);
                for(int i=0;i<4;i++)
                {
                    int x1 = x + dx[i];
                    int y1 = y + dy[i];
                    if(x1>=0 && x1<m && y1>=0 && y1<n && rooms[x1][y1]==Integer.MAX_VALUE)
                    {
                        // System.out.println("Adding neighbor :"+x1 + " ," + y1 +" k :"+k);
                        rooms[x1][y1] = k;
                        q.offer(new int[]{x1, y1});
                    }
                }
            }
            k++;
        }
    }
}