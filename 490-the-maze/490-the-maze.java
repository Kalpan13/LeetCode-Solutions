class Solution {
    boolean[][] visited;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        visited = new boolean[maze.length][maze[0].length];
        // if(destination[0]>=maze[0].length || destination[1]>=maze.length)
        //     return false;
        return dfs(maze, start[0], start[1],destination);
    }
    public boolean dfs(int[][] maze, int x, int y, int[] dest)
    {
        if(visited[x][y])
            return false;
        if(dest[0]==x && dest[1]==y)
            return true;
        
        visited[x][y] = true;
        int ry = y+1;
        int ly = y-1;
        int ux = x-1;
        int dx = x+1;
        
        // move right
        while(ry<maze[0].length && maze[x][ry]==0)
            ry++;
        if(dfs(maze, x, ry-1, dest))
            return true;
        
        // move left
        while(ly>=0 && maze[x][ly]==0)
            ly--;
        if(dfs(maze, x, ly+1, dest))
            return true;
        
        // move up
        while(ux>=0 && maze[ux][y]==0)
            ux--;
        
        if(dfs(maze, ux+1, y, dest))
            return true;
        
        // move right
        while(dx<maze.length && maze[dx][y]==0)
            dx++;
        if(dfs(maze, dx-1, y, dest))
            return true;
        return false;
    }
    
    
}