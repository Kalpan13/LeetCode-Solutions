class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        if(n<4)
        {
            return 0;
        }
        int[] possible_ans = {
            nums[3]-nums[n-1],
            nums[2]-nums[n-2],
            nums[1]-nums[n-3],
            nums[0]-nums[n-4],
        };
        for(int i=0;i<4;i++)
            ans = Math.min(Math.abs(possible_ans[i]), ans);
        
        return ans;
        
    }
}