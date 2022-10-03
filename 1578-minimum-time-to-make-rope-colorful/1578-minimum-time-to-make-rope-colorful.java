class Solution {
    public int minCost(String colors, int[] neededTime) {
        int cost = 0;
        char colorsChar[] = colors.toCharArray();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(neededTime[0]);
        for(int i=1;i<colorsChar.length;i++)
        {
            if(colorsChar[i]==colorsChar[i-1]) // Same color as previous
            {
                pq.offer(neededTime[i]);
                // System.out.println(pq);
            }
            else
            {
                pq.clear();
                pq.offer(neededTime[i]);
            }
            while(pq.size()>1)
                    cost+= pq.poll();
        }
        return cost;
    }
    
}