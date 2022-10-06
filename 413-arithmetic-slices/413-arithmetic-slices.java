class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        int count = 0;
        int sum = 0;
        for(int i=2;i<nums.length;i++)
        {
            if(nums[i-1]-nums[i-2]==nums[i]-nums[i-1])
                count++;
            else
            {
                sum+= (count + 1) * (count) /2;
                count = 0;
            }
        }
        
        return sum+= (count+1)*count/2;
    }
}