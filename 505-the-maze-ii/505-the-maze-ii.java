class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dist = new int[m][n];
        for(int[] d : dist)
            Arrays.fill(d, Integer.MAX_VALUE);
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0],start[1]});
        dist[start[0]][start[1]] = 0;
        int dirs[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty())
        {
            int[] cur = q.poll();
            
            for(int[] dir : dirs)
            {
                int x = cur[0];
                int y = cur[1];
                int step = 0;
                while(x+dir[0]>=0 && x+dir[0]<m && y+dir[1]>=0 && y+dir[1]<n && maze[x+dir[0]][y+dir[1]]!=1)
                {
                    x+= dir[0];
                    y+= dir[1];
                    step++;
                }
                if(dist[cur[0]][cur[1]] + step < dist[x][y])
                {
                    dist[x][y] = dist[cur[0]][cur[1]] + step;
                    q.offer(new int[]{x,y});
                }
            } 
        }   
        return dist[dest[0]][dest[1]]==Integer.MAX_VALUE?-1:dist[dest[0]][dest[1]];
    }
}