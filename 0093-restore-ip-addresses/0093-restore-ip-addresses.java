class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if(!isValid(s))
            return ans;
        
        backtrack(s, 0, new ArrayList<>(), ans);
        return ans;
    }
    public boolean isValid(String s)
    {
        if(s.length()>12 || s.length()<4)
            return false;
        for(char c:s.toCharArray())
        {
            if(!Character.isDigit(c))
                return false;
        }
        return true;
    }
    public void backtrack(String s, int pos, List<String> curIP, List<String> ans)
    {
        
        if(pos==s.length() && curIP.size()==4)
        {
            ans.add(String.join(".",curIP));
            return;
        }
        if(curIP.size()==4 || pos==s.length())
            return;
        
        for(int i=pos;i<Math.min(pos+3, s.length());i++)
        {
            String numStr = s.substring(pos, i+1);
            if(validAddress(numStr))
            {
                curIP.add(numStr);
                backtrack(s, i+1, curIP, ans);
                curIP.remove(curIP.size()-1);
            }
        }
    }
     private boolean validAddress(String address) {
        return !((address.charAt(0) == '0' && address.length() > 1) || Integer.parseInt(address) > 255);
    }
}