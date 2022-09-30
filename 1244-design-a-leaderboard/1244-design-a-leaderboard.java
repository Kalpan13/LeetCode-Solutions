class Leaderboard {
    Map<Integer,Integer> scores;
    public Leaderboard() {
        scores = new HashMap<>();
        
    }
    
    public void addScore(int playerId, int score) {
        scores.put(playerId, scores.getOrDefault(playerId,0)+score);
    }
    
    public int top(int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(Integer key: scores.values())
        {
            pq.offer(key);
            if(pq.size()>K)
                pq.poll();
        }
        int total = 0;
        for(Integer v : pq)
        {
            total = total + v;
        }
        return total;
        
    }
    
    public void reset(int playerId) {
        scores.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */