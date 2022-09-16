class Solution {
    public int countDistinct(String s) {
        TrieNode root = new TrieNode();
        int count = 0;
        for(int i=0;i<s.length();i++)
        {
            TrieNode cur = root;
            for(int j=i;j<s.length();j++)
            {
                char c = s.charAt(j);
                
                if(cur.next[c-'a']==null)
                {
                    cur.next[c-'a'] = new TrieNode();
                    count++;
                }
                cur = cur.next[c-'a'];
                
            }
        }
        return count;
    }
}

class TrieNode{
    TrieNode[] next;
    boolean isWord;
    
    TrieNode()
    {
        next = new TrieNode[26];
        isWord = false;
    }
}