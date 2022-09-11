class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character,Integer>> st = new Stack<>();
        
        for(char c: s.toCharArray())
        {
            if(st.isEmpty() || st.peek().getKey()!=c)
                st.push(new Pair(c,1));
            else
            {
                if(st.peek().getValue()==k-1)
                {
                    int tp = k-1;
                    while(tp-->0)
                    {
                        st.pop();
                    }
                }
                else
                {
                    st.push(new Pair(c,st.peek().getValue()+1));
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        while(!st.isEmpty())
            sb.append(st.pop().getKey());
        return sb.reverse().toString();
    }
}