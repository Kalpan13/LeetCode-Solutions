class Solution {

    public boolean exist(char[][] board, String word) {
    
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(dfs(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int ind, int i, int j)
    {
        if(ind==word.length())
            return true;
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || word.charAt(ind)!=board[i][j]  || board[i][j]=='-')
            return false;
        
        char tp = board[i][j];
        board[i][j] = '-';
        
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        
        for(int d=0;d<4;d++)
        {
            if(dfs(board,word,ind+1,i+dx[d],j+dy[d]))
                return true;
        }
        board[i][j] = tp;
        return false;
        
        
    }
}

