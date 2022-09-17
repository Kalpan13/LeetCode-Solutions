class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        
        List<List<int[]>> arr = new ArrayList<>();
        int m = mat1.length;
        int n = mat1[0].length;
        int nB = mat2[0].length;
        
        int[][] result = new int[m][nB];
        
        for(int i=0;i<m;i++)
        {
            arr.add(new ArrayList<>());
            for(int j=0;j<n;j++)
            {
                if(mat1[i][j]!=0)
                    arr.get(i).add(new int[]{j,mat1[i][j]});
            }
        }
        for(int i=0;i<m;i++)
        {
            List<int[]> mat1Vals = arr.get(i);
            for(int p=0;p<mat1Vals.size();p++)
            {
                int mat1Col = mat1Vals.get(p)[0];
                int mat1Val = mat1Vals.get(p)[1];
                
                for(int j=0;j<nB;j++)
                {
                    int mat2Val = mat2[mat1Col][j];
                    result[i][j] += mat1Val*mat2Val;     
                }
                
            }
        }
        return result;
    }
}