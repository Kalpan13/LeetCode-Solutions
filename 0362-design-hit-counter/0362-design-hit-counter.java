class HitCounter {

    int[] hits;
    int[] times;
    public HitCounter() {
        hits = new int[300];
        times = new int[300];
    }
    
    public void hit(int timestamp) {
        int newTime = timestamp % 300;
        if(times[newTime]!=timestamp) // reset counter
        {
            times[newTime] = timestamp;
            hits[newTime] = 1;
        }
        else
        {
            hits[newTime]++;
        }
    }
    
    public int getHits(int timestamp) {
        int count = 0;
        for(int i=0;i<300;i++)
        {
            if(timestamp - times[i]<300)
            {
                count+=hits[i];
            }
        }
        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */