class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(nums1[i]==nums2[j])
                    dp[i+1][j+1] = dp[i][j]+1;
                else
                    dp[i+1][j+1] = 0;
                max = Math.max(dp[i+1][j+1],max);
            }
        }
        return max;
    }
    
}