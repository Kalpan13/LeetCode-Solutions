class Solution {
    
    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String,Integer> frq = new HashMap<>();
        
        for(String word: words)
        {
            frq.put(word, frq.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((w1,w2)-> frq.get(w1)==frq.get(w2)?w2.compareTo(w1):frq.get(w1)-frq.get(w2));
        
        for(String key : frq.keySet())
        {
            pq.offer(key);
            if(pq.size()>k)
                pq.poll();
        }
        List<String> ans = new ArrayList<>();
        while(!pq.isEmpty())
            ans.add(pq.poll());
        
        Collections.reverse(ans);
        return ans;
    }
}