class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int sum = 0;
        int maxSoFar = Integer.MIN_VALUE;
        int totalSum = 0;
        for(int i=0;i<nums.length;i++)
        {
            totalSum += nums[i];
            sum+= nums[i];
            maxSoFar = Math.max(maxSoFar, sum);
            if(sum<0)
                sum = 0;
        }
        
        int maxSumNonCircular = maxSoFar;
        
        sum = 0;
        int minSoFar = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            sum+= nums[i];
            minSoFar = Math.min(sum, minSoFar);
            
            if(sum>0)
                sum = 0;
        }
        int minSumNonCicular = minSoFar;
        // System.out.println("Max Sum :"+maxSumNonCircular + " Min Sum : "+minSumNonCicular);
        return Math.max(maxSumNonCircular, totalSum-minSumNonCicular==0?Integer.MIN_VALUE:(totalSum-minSumNonCicular));
    }
}