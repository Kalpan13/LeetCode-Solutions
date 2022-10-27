class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        backtrack(0, nums, ans, new ArrayList<>());
        return ans;
    }
    public void backtrack(int pos, int[] nums, List<List<Integer>> ans, List<Integer> curList)
    {
        
        if(pos==nums.length)
        {
            ans.add(new ArrayList<>(curList));
            return;
        }
            
        
        for(int i=pos;i<nums.length;i++)
        {
            curList.add(nums[i]);
            swap(pos, i, nums);
            backtrack(pos+1, nums, ans, curList);
            curList.remove(curList.size()-1);
            swap(pos, i, nums);
        }
    }
    public void swap(int i, int j, int[] nums)
    {
        int tp = nums[i];
        nums[i] = nums[j];
        nums[j] = tp;
    }
}