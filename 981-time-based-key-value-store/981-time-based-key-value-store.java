class TimeMap {
    Map<String,List<Pair<String,Integer>>> hm;
    public TimeMap() {
        hm = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        hm.putIfAbsent(key, new ArrayList<>());
        hm.get(key).add(new Pair<>(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        
        List<Pair<String,Integer>> valTimes = hm.getOrDefault(key, new ArrayList<>());
        
        if(valTimes.size()==0)
            return "";
        
        //Collections.sort(valTimes, (a,b)-> (a.getValue()-b.getValue()));
        //System.out.println(valTimes);
        int low = 0;
        int high = valTimes.size()-1;
        int target = timestamp;
        if(valTimes.get(high).getValue()<=target)
            return valTimes.get(high).getKey();
        while(low < high)
        {
            int mid = (low+high)/2;
            // System.out.println("low : "+low + " high : "+high + " mid : "+ mid);
            if(valTimes.get(mid).getValue()==target)
                return valTimes.get(mid).getKey();
            if(valTimes.get(mid).getValue()<target)
                high = mid-1;
            else
                low = mid+1;
        }
        return valTimes.get(low).getValue()<=target?valTimes.get(low).getKey():"";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */