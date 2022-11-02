class Solution {
    public int smallestCommonElement(int[][] mat) {
        int[] pos = new int[mat.length];
        
        while(true)
        {
            int max = findMax(mat, pos);
            boolean changed = false;
            for(int i=0;i<pos.length;i++)
            {
                if(mat[i][pos[i]]<max)
                {
                    pos[i]++;
                    if(pos[i]==mat[0].length)
                        return -1;
                    changed = true;
                }
            }
            if(!changed)
                return mat[0][pos[0]];
        }
    }
    public int findMax(int[][] mat, int[] pos)
    {
        int max = mat[0][pos[0]];
        for(int i=0;i<pos.length;i++)
        {
            max = Math.max(mat[i][pos[i]], max);
        }
        return max;
    }
}