class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, ans, new ArrayList<>());
        return ans;
        
    }
    public void backtrack(int[] nums, int pos, List<List<Integer>> ans, List<Integer> curList)
    {
        ans.add(new ArrayList<>(curList));
        
        for(int i=pos;i<nums.length;i++)
        {
            if(i>pos && nums[i]==nums[i-1])
                continue;
            
            curList.add(nums[i]);
            backtrack(nums, i+1, ans, curList);
            curList.remove(curList.size()-1);
        }
    }
}