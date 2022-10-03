class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxBestPairSum = 0;
        int maxSightSee1Effective = values[0];
        
        for(int i=1;i<values.length;i++)
        {
            maxSightSee1Effective--;
            maxBestPairSum = Math.max(maxBestPairSum, maxSightSee1Effective+values[i]);
            if(values[i]>maxSightSee1Effective)
            {
                maxSightSee1Effective = values[i];
            }
                
        }
        return maxBestPairSum;
    }
}