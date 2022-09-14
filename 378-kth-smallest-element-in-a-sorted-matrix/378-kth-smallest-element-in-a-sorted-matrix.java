class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++)
            pq.offer(new int[]{i,0,matrix[i][0]});
        int val = 0;
        while(k-->0)
        {
            int[] triplet = pq.poll();
            int r = triplet[0];
            int c = triplet[1];
            val = triplet[2];
            if(c<n-1)
                pq.offer(new int[]{r,c+1,matrix[r][c+1]});
        }
        return val;
    }
}