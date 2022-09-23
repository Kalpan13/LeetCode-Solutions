class Solution {
    int[] memo;
    public int rob(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo,-1);
        return helper(nums, nums.length-1);
    }
    public int helper(int[] nums, int i)
    {
        if(i<0)
            return 0;
        if(memo[i]!=-1)
            return memo[i];
        
        return memo[i] = Math.max(helper(nums,i-2)+nums[i], helper(nums, i-1));
    }
    

}