class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, ans, 0, new ArrayList<>());
        return ans;       
    }
    public void backtrack(int[] nums, int target, List<List<Integer>> ans, int pos, List<Integer> curList)
    {
        if(target<0)
            return;
        if(target==0)
        {
            ans.add(new ArrayList<>(curList));
            return;  
        }
            
        if(pos==nums.length)
            return;
        
        for(int i=pos;i<nums.length;i++)
        {
            if(i>pos && nums[i]==nums[i-1])
                continue;
            curList.add(nums[i]);
            backtrack(nums, target-nums[i], ans, i+1, curList);
            curList.remove(curList.size()-1);
        }
    }
}