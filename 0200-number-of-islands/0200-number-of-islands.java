class Solution {
    public int numIslands(char[][] grid) {
        int island = 0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    dfs(i,j,grid);
                    island++;
                }
            }
        }
        return island;
    }
    public void dfs(int i, int j, char[][] grid)
    {
       
        int dx[] = {1,0,-1,0};
        int dy[] = {0,1,0,-1};
        grid[i][j] = '2';
        for(int d=0;d<4;d++)
        {
            int x = i+dx[d];
            int y = j+dy[d];
            
            if(isValid(x,y,grid) && grid[x][y]=='1')
                dfs(x,y,grid);
        }
        return;
    }
    public boolean isValid(int x, int y, char[][] grid)
    {
        return x>=0 && y>=0 && x<grid.length && y<grid[0].length;
    }
}