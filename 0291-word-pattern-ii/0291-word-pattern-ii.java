class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        Map<Character,String> map = new HashMap<>();
        Set<String> usedWords = new HashSet<>();
        boolean ans = backtrack(s, pattern, 0, 0, map, usedWords);
        return ans;
    }
    public boolean backtrack(String s, String p, int posS, int posP, Map<Character,String> map, Set<String> usedWords)
    {
        if(posS==s.length() && posP==p.length())
            return true;
        if(posS==s.length() || posP==p.length())
            return false;
        
        char curChar = p.charAt(posP);
        if(map.containsKey(curChar))
        {
            String assgnWord = map.get(curChar);
            if(!s.startsWith(assgnWord, posS))
                return false;
            
            return backtrack(s, p, posS+assgnWord.length(), posP+1, map, usedWords);
        }
        for(int i=posS;i<s.length();i++)
        {
            String possibleWord = s.substring(posS, i+1);
            if(usedWords.contains(possibleWord))
                continue;
            
            map.put(curChar, possibleWord);
            usedWords.add(possibleWord);
            if(backtrack(s, p, i+1, posP+1, map, usedWords))
                return true;
            usedWords.remove(possibleWord);
            map.remove(curChar);
        }
        return false;
    }
}