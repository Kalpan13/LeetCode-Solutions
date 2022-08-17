class Solution {
    int[] colors;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        boolean[][] g = new boolean[n][n];
        colors = new int[n];
        for(int[] dislike: dislikes)
        {
            g[dislike[0]-1][dislike[1]-1] = true;
            g[dislike[1]-1][dislike[0]-1] = true;
        }
        for(int i=0;i<n;i++)
        {
            if(colors[i]==0 && !paint(i, 1, g))
                return false;
        }
        return true;
    }
    private boolean paint(int ind, int color, boolean[][] g)
    {
        if(colors[ind]!=0)
            return colors[ind]==color;
        colors[ind] = color;
        for(int j=0;j<g.length;j++)
        {
            if(g[ind][j] && !paint(j, -color, g))
                return false;
        }
        return true;
    }
}