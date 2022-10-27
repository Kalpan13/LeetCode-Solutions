class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        backtrack(0, nums, ans, new ArrayList<>());
        return ans;
    }
    public void backtrack(int ind, int[] nums, List<List<Integer>> ans, List<Integer> curList)
    {
        if(curList.size()==nums.length)
        {
            ans.add(new ArrayList<>(curList));
            return;
        }
            
        
        for(int i=0;i<nums.length;i++)
        {
            if(curList.contains(nums[i]))
                continue;
            curList.add(nums[i]);
            backtrack(i+1,nums, ans, curList);
            curList.remove(curList.size()-1);
        }
    }
}