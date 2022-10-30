class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, ans, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }
    public void backtrack(int[] nums, int pos, List<List<Integer>> ans, List<Integer> curList, boolean[] used)
    {
        if(pos==nums.length)
        {
            ans.add(new ArrayList<>(curList));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
               
            if(used[i] || (i>0 && nums[i]==nums[i-1] && !used[i-1]))
               continue;
            curList.add(nums[i]);
            used[i] = true;
            backtrack(nums, pos+1, ans, curList, used);
            used[i] = false;
            curList.remove(curList.size()-1);
        }
        
    }
    public void swap(int i, int j, int[] nums)
    {
        int tp = nums[i];
        nums[i] = nums[j];
        nums[j] = tp;
    }
}