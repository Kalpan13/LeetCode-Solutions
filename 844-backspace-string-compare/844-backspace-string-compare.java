class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        
        for(char c: s.toCharArray())
        {
            if(c=='#' && !st1.isEmpty())
                st1.pop();
            else if(c=='#')
                continue;
            else
                st1.push(c);
        }
        for(char c: t.toCharArray())
        {
            if(c=='#' && !st2.isEmpty())
                st2.pop();
            else if(c=='#')
                continue;
            else
                st2.push(c);
        }
        while(!st1.isEmpty()&&!st2.isEmpty())
        {
            if(st1.peek()!=st2.peek())
                return false;
            st1.pop();
            st2.pop();
        }
        return (st1.isEmpty() && st2.isEmpty());
    }
}