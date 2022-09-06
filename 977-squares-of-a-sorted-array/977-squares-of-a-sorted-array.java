class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int high = n-1;
        
        int p1 = 0;
        int p2 = n-1;
        
        while(p1<=p2)
        {
            if(Math.abs(nums[p1])>Math.abs(nums[p2]))
            {
                ans[high--] = nums[p1]*nums[p1];
                p1++;
            }
            else
            {
                ans[high--] = nums[p2]*nums[p2];
                p2--;
            }
        }
        return ans;
    }
}