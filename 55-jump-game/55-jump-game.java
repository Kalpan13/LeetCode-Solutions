class Solution {
    Boolean memo[];
    public boolean canJump(int[] nums) {
        memo = new Boolean[nums.length];
        return canJumpHelper(nums, 0);
    }
    public boolean canJumpHelper(int[] nums, int cur)
    {
        if(cur>=nums.length-1)
            return true;
        
        if(memo[cur]!=null)
            return memo[cur];
        // System.out.println("cur : "+cur);
        for(int i=cur+1;i<=Math.min(nums.length-1, cur+nums[cur]);i++)
        {
            
            // System.out.println("Checking can jump : "+i + " from :"+cur);
            if(canJumpHelper(nums, i))
                return memo[cur] = true;
        }
            
        
        return memo[cur] = false;
    }
}