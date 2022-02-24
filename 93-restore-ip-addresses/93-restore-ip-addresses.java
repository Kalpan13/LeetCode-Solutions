class Solution {
    List<String> ans;
    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        findIP(s, 0, "");
        return ans;
    }
    public void findIP(String s, int dotCount, String IP)
    {
        if(s.length()==0 || dotCount==4)
        {
            if(s.length()==0 && dotCount==4)
                ans.add(IP.substring(1));
            return;
        }
        for(int i=1;i <= (s.charAt(0) == '0' ? 1 : 3) && i <= s.length();i++)
        {
            String domain = s.substring(0,i);
            int domainVal = Integer.parseInt(domain);
            if(domainVal>=0 && domainVal<=255)
                findIP(s.substring(i), dotCount+1, IP+"."+domain); 
        }
        return;
    }
}