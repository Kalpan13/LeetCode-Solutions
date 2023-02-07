class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int len = words[0].length();
        int n = words.length;
        int l = s.length();
        Map<String,Integer> wordMap = new HashMap<>();
        
        for(String word : words)
        {
            wordMap.put(word, wordMap.getOrDefault(word, 0)+1);
        }
        List<Integer> result = new ArrayList<>();
        Map<String,Integer> curMap = new HashMap<>();
        for(int i=0;i<l-(n*len)+1;i++)
        {
            int j = 0;
            // System.out.println("i :"+i);
            curMap = new HashMap<>();
            while(j<n)
            {
                String curWord = s.substring(i+j*len, i+(j+1)*len);
                if(wordMap.containsKey(curWord))
                {
                    curMap.put(curWord, curMap.getOrDefault(curWord, 0)+1);
                    if(curMap.get(curWord)>wordMap.get(curWord))
                        break;
                }
                else
                {
                    break;
                }
                j++;
            }
            if(j==n)
                result.add(i);
        }
        return result;
    }
}