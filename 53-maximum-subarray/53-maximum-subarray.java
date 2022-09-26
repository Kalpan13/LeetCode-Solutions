class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSoFar = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++)
        {
            sum += nums[i];
            maxSoFar = Math.max(sum, maxSoFar);
            if(sum<0)
                sum = 0;
            
        }
        return maxSoFar;
    }
}