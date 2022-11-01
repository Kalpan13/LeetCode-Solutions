class Solution {
    public void nextPermutation(int[] nums) {
        int pivotInd = findPivot(nums);
        // System.out.println("pivotInd :"+pivotInd);
        if(pivotInd == -1)
            reverse(nums, 0, nums.length-1);
        else
        {
            int j = nums.length-1;
            while(nums[j]<=nums[pivotInd])
            {
                j--;
                System.out.println("j :"+j);
            }
                
            swap(nums, pivotInd, j);
            reverse(nums, pivotInd+1, nums.length-1);
        }
    }
    public int findPivot(int[] nums)
    {
        int i = nums.length-2;
        while(i>=0)
        {
            if(nums[i]<nums[i+1])   
                return i;
            i--;
        }
        
        return i;
    }
    public void reverse(int[] nums, int start, int end)
    {
        int i = start;
        int j = end;
        while(i<j)
        {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    public void swap(int[] nums, int i, int j)
    {
        int tp = nums[i];
        nums[i] = nums[j];
        nums[j] = tp;
    }
    // 1 1 3 5 2 6
    // 1 1 3 5 6 2
    // 1 1 3 6 5 2
}