class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] f = new boolean[26];
        
        for(char c: sentence.toCharArray())
            f[c-'a'] = true;
        
        for(boolean isPresent:f)
            if(!isPresent)
                return false;
        return true;
    }
}