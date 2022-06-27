class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();
        int ng[][] = new int[n*3][m*3];
          
        /*
        Convert / \ to number of island problem
        '/' --> 0 0 1
                0 1 0
                1 0 0
                
        '\' --> 1 0 0
                0 1 0
                0 0 1
                
        */
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i].charAt(j)=='/')
                {
                    ng[i*3][j*3+2] = 1;
                    ng[i*3+1][j*3+1] = 1;
                    ng[i*3+2][j*3] = 1;
                }
                else if(grid[i].charAt(j)=='\\')
                {
                    ng[i*3][j*3] = 1;
                    ng[i*3+1][j*3+1] = 1;
                    ng[i*3+2][j*3+2] = 1;
                }
            }
        }
        int regions = 0;
        
        for(int i=0;i<ng.length;i++)
        {
            for(int j=0;j<ng[0].length;j++)
            {
                regions += countRegions(ng,i,j)>0?1:0;
            }
        }
                            
        
        return regions;
    }
    public int countRegions(int[][] ng, int i, int j)
    {
        if(i<0 || i>=ng.length || j<0 || j>=ng[0].length)
            return 0;
        if (ng[i][j] == 1) // Visited or Boundary
            return 0;
        ng[i][j] = 1;
        return 1 + countRegions(ng,i+1,j)+countRegions(ng,i-1,j) +countRegions(ng,i,j+1) + countRegions(ng,i,j-1);
        
        
    }
}