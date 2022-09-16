class Solution {
    // 3 --> 0 to 1 conversion
    // 2 --> 1 to 0 conversion
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j] = findState(board, i, j);
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==2)
                    board[i][j] = 0;
                else if(board[i][j]==3)
                    board[i][j] = 1;
            }
        }
    }
    public int findState(int[][] board, int i, int j)
    {
        int[] dx = {1,0,-1,0,1,1,-1,-1};
        int[] dy = {0,1,0,-1,1,-1,1,-1};
        int liveNeighCount = 0;
        for(int d=0;d<8;d++)
        {
            int i1 = i+dx[d];
            int j1 = j+dy[d];
            
            if(i1>=0 && i1<board.length && j1>=0 && j1<board[0].length)
            {
                
                if(board[i1][j1]==1 || board[i1][j1]==2)
                {
                    liveNeighCount++;
                }
                    
            }
        }

        if(board[i][j]==0)
        {
            if(liveNeighCount==3)
                return 3;
            else 
                return 0;
        }
        if(board[i][j]==1)
        {
            if(liveNeighCount>=2 && liveNeighCount<=3)
                return 1;
            else
                return 2;
        }
        return -1;
    }
}