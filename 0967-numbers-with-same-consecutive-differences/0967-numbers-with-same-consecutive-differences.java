class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ans = new ArrayList<>();
        for(int i=1;i<10;i++)
        {
            backtrack(n, k, i, ans);
        }
        return ans.stream().mapToInt(i->i).toArray();
        
    }
    public void backtrack(int n, int k, int cur, List<Integer> ans)
    {
        
        String curStr = String.valueOf(cur);
        if(curStr.length()==n)
        {
            ans.add(cur);
            return;
        }
        int lastNum = cur % 10;
        if(lastNum+k<10 && k>0)
        {
            backtrack(n, k, cur*10+lastNum+k, ans);
        }
        if(lastNum-k>=0)
        {
            int nextNum = (lastNum-k);
            backtrack(n, k, cur*10+nextNum, ans);
        }
    }
}