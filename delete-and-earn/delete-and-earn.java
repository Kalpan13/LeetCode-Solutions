class Solution {
    public int deleteAndEarn(int[] nums) {
        
        Arrays.sort(nums);
        int[] memo = new int[nums.length];
        Arrays.fill(memo,-1);
        int ans = recurse(nums, 0, memo);
        return ans;
    }
    public int recurse(int[] nums, int i, int[] memo)
    {
        if(i>=nums.length)
            return 0;
        
        if(memo[i]!=-1)
            return memo[i];
        
        int curVal = nums[i];
        int curSum = nums[i];
        
        int st = i + 1;
        
        // Update number of points with curVal 
        while(st<nums.length && nums[st]==curVal)
            curSum += nums[st++];
        
        int prevSt = st;
        
        // Skip all the values of (curVal+1)
        while(st<nums.length && nums[st]==curVal+1)
            st++;
        
        // Ans = Max(take curVal and Skip next, do not take curVal) 
        return memo[i] = Math.max(curSum+recurse(nums, st, memo), recurse(nums, prevSt, memo));
    }
}