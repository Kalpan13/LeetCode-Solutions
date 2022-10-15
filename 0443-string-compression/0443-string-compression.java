class Solution {
    public int compress(char[] chars) {
        
        int index = 0;
        int i = 0;
        while(i<chars.length)
        {
            char curChar = chars[i];
            int f = 0;
            while(i<chars.length && chars[i]==curChar)
            {
                i++;
                f++;
            }
            
            chars[index++] = curChar;
            if(f>1 && f<10)
            {
                chars[index++] = (char)(f+'0');
            }
            else if(f>=10)
            {
                String fStr = String.valueOf(f);
                for(char c: fStr.toCharArray())
                    chars[index++] = c;
            }
        }
        return index;
    }
}