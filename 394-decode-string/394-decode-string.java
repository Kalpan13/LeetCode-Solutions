class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        Stack<Integer> countSt = new Stack<>();
        int i=0;
        while(i<s.length())
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                int num = c-'0';
                
                int j = i+1;
                while(j<s.length() && Character.isDigit(s.charAt(j)))
                {
                    num *= 10;
                    num += (s.charAt(j)-'0');
                    j++;
                }
                i = j;
                countSt.push(num);
                continue;
            }
            else if(c=='[')
            {
                st.push(new String("["));
            }
            else if(c==']')
            {
                StringBuffer sb = new StringBuffer();
                while(!st.peek().equals("["))
                    sb.insert(0, st.pop());
                
                st.pop();
                
                int num = countSt.pop();
                StringBuffer ans = new StringBuffer();
                while(num-->0)
                    ans.append(sb);
                
                st.push(ans.toString());
            }
            else
            {
                st.push(Character.toString(c));
            }
            i++;
        }
        StringBuffer decodedString = new StringBuffer();
        while(!st.isEmpty())
            decodedString.insert(0,st.pop());
        return decodedString.toString();
    }
    
}