class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(n, ans, new ArrayList<>(), 2);
        return ans;
    }
    public void backtrack(int n, List<List<Integer>> ans, List<Integer> curList, int low)
    {
        if(n<=1)
        {
            if(curList.size()>1)
            ans.add(new ArrayList<>(curList));
            return;
        }
            
        
        for(int i=low;i<=n;i++)
        {
            if(n%i==0)
            {
                curList.add(i);
                
                backtrack(n/i, ans, curList, i);
                curList.remove(curList.size()-1);
            }
        }
    }
}