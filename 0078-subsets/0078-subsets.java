class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, nums, ans, new ArrayList<>());
        return ans;
    }
    public void backtrack(int pos, int[] nums, List<List<Integer>> ans, List<Integer> curList)
    {
        ans.add(new ArrayList<>(curList));
        for(int i=pos;i<nums.length;i++)
        {
            curList.add(nums[i]);
            backtrack(i+1, nums, ans, curList);
            curList.remove(curList.size()-1);
        }
    }
    
}