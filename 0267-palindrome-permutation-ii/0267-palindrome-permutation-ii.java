class Solution {
    public List<String> generatePalindromes(String s) {
        int[] freq = new int[26];
        for(char c: s.toCharArray())
        {
            freq[c-'a']++;
        }
        int odd_cnt_id = -1;
        for(int i=0;i<26;i++)
        {
            if(freq[i]%2!=0)
            {
                if(odd_cnt_id!=-1)
                    return new ArrayList<>();
                odd_cnt_id = i;
            }
        }
        Set<String> ans = new HashSet<>();
        int n = s.length();
        char odd_char = '-';
        if(odd_cnt_id!=-1)
            odd_char = (char)(odd_cnt_id + 'a');
        
        char[] st = new char[s.length()/2];
        int k = 0;
        for(int i=0;i<26;i++)
        {
            for(int j=0;j<freq[i]/2;j++)
                st[k++] =(char)(i+'a');
        }
        backtrack(0, ans, st, odd_char);
        return new ArrayList<>(ans);
    }
    public void backtrack(int pos, Set<String> ans, char[] st, char odd_char)
    {
        if(pos>=st.length)
        {
            String s = new String(st);
            String sbRev = new StringBuffer(s).reverse().toString();
            // String sbRev = sb.reverse();
            if(odd_char!='-')
                s += odd_char;
            s+= sbRev;
            ans.add(s);
            return;
        }
        for(int i=pos;i<st.length;i++)
        {
            swap(st, i, pos);
            backtrack(pos+1, ans, st, odd_char);
            swap(st, i, pos);
        }
    }
    public void swap(char[] st, int i, int j)
    {
        char tp = st[i];
        st[i] = st[j];
        st[j] = tp;
    }
}