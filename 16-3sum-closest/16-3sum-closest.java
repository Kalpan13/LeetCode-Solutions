class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minSum = nums[0]+nums[1]+nums[2];
        
        for(int i=0;i<nums.length-2;i++)
        {
            int j = i+1;
            int k = nums.length-1;
            
            while(j<k)
            {
                int curSum = nums[j]+nums[k]+nums[i];
                if(curSum==target)
                    return target;
                
                if(Math.abs(curSum-target)<Math.abs(minSum-target))
                {
                    minSum = curSum;
                }
                if(curSum>target)
                {
                    k--;
                }
                else
                {
                    j++;
                }
            }
        }
        return minSum;
        
    }
}