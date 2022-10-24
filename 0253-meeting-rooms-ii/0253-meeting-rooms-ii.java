class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b)-> (a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0][1]);
        //System.out.println(pq);
        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][0]>=pq.peek())
            {
                pq.poll();
            }
            pq.offer(intervals[i][1]);
        }
        return pq.size();
    }
}