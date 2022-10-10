class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()==1)
            return "";
        
        
        int i = 0;
        StringBuffer sb = new StringBuffer();
        int palLength = palindrome.length();
        boolean changed = false;
        while(i<palLength)
        {
            char c = palindrome.charAt(i);
            
            if(c=='a' || changed)
                sb.append(c);
            else if(palLength%2==1 && i==(palLength/2))
                sb.append(c);
            else
            {
                sb.append('a');
                changed = true;
            }
            i++;
                
        }
        if(!changed)
        {
            sb.setLength(sb.length()-1);
            sb.append('b');
        }
            
        return sb.toString();
    }
}