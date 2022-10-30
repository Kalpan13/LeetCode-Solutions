class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, ans, new ArrayList<>());
        return ans;
    }
    public void backtrack(int[] candidates, int target, int pos, List<List<Integer>> ans, List<Integer> curList)
    {
        if(target<0)
            return;
        if(pos==candidates.length)
        {
            if(target==0)
                ans.add(new ArrayList<>(curList));
            return;
        }
        curList.add(candidates[pos]);
        backtrack(candidates, target-candidates[pos], pos, ans, curList);
        curList.remove(curList.size()-1);
        backtrack(candidates, target, pos+1, ans, curList);

        
    }
}