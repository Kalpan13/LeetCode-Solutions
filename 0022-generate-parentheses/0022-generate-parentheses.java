class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(n*2, 0, 0, ans, new StringBuffer());
        return ans;
    }
    public void backtrack(int n, int bal, int cnt, List<String> ans, StringBuffer curStr)
    {
        if(curStr.length()==(n))
        {
            ans.add(curStr.toString());
            return;
        }
        
        if(bal>0)
        {
            curStr.append(')');
            backtrack(n, bal-1, cnt, ans, curStr);
            curStr.setLength(curStr.length()-1);
        }
        if(cnt<(n/2))
        {
            curStr.append('(');
            backtrack(n, bal+1, cnt+1, ans, curStr);
            curStr.setLength(curStr.length()-1);
        }
        
    }
}