class Solution {
    public List<String> letterCombinations(String digits) {
        char[][] keyMap = {
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'},
        };
        List<String> ans = new ArrayList<>();
        if(digits.length()==0)
            return ans;
        
        backtrack(ans, digits.toCharArray(), 0, keyMap, new StringBuffer());
        return ans;
    }
    public void backtrack(List<String> ans, char[] digits, int pos, char[][] keyMap, StringBuffer curStr)
    {
        if(pos==digits.length)
        {
            ans.add(curStr.toString());
            return;
        }
        int num = digits[pos]-'2';
        
        for(char c: keyMap[num])
        {
            curStr.append(c);
            backtrack(ans, digits, pos+1, keyMap, curStr);
            curStr.setLength(curStr.length()-1);
        }
    }
}