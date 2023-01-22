class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Set<String> seen = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]!='.')
                {
                    
                
                    String key = "("+board[i][j]+")";
                    if(!seen.add(key+i) || !seen.add(j+key) || !seen.add(i/3+key+j/3))
                        return false;
                }
            }
        }
        return true;
    }
}