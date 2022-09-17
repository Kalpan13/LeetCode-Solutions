class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++)
            q.offer(i);
        
        int lastKilled = -1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<k-1;j++)
                q.offer(q.poll());
            
            lastKilled = q.poll();
        }
        return lastKilled;
    }
}