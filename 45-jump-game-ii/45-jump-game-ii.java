class Solution {
    int[] memo;
    public int jump(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo,-1);
        
        return jumpHelper(0, nums);
    }
    public int jumpHelper(int cur, int[] nums)
    {
        if(cur>=nums.length-1)
            return 0;
        if(memo[cur]!=-1)
            return memo[cur];
        int maxSteps = Integer.MAX_VALUE;
        for(int i=cur+1;i<=Math.min(cur+nums[cur],nums.length-1);i++)
        {
            int nextSteps = jumpHelper(i,nums);
            if(nextSteps==Integer.MAX_VALUE)
                continue;
            
            maxSteps = Math.min(maxSteps, nextSteps+1);
        }
        return memo[cur] = maxSteps;
    }
}