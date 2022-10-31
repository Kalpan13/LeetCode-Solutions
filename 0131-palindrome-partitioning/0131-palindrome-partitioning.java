class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(0, ans, new ArrayList<>(), s);
        return ans;
    }
    public void backtrack(int pos, List<List<String>> ans, List<String> curList, String s)
    {
        if(pos>=s.length())
        {
            ans.add(new ArrayList<>(curList));
            return;
        }
        
        for(int i=pos;i<s.length();i++)
        {
            if(isPalindrome(s, pos, i))
            {
                curList.add(s.substring(pos, i+1));
                backtrack(i+1, ans, curList, s);
                curList.remove(curList.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end)
    {
        int i = start;
        int j = end;
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}