class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = 0;
        if(matrix.length==1 && matrix[0].length==1)
          return target==matrix[0][0];  
        while(i<matrix.length || j<matrix[0].length)
        {
            if(j>=matrix[0].length)
            {
                j=0;
                if(i+1<matrix.length)
                    i++;
                else
                    return false;
            }
            int cur = matrix[i][j];
            //System.out.println("i :"+i + " j :"+j + " cur : "+cur);
            if(cur==target)
                return true;
            if(cur<target)
            {
                if(i+1<matrix.length)
                {
                    if(matrix[i+1][j]<target)
                    {
                        i++;
                    }
                    else
                        j++;
                }
                else
                {
                    j++;
                }
            }
            else
                return false;
        }
        return true;
    }
}